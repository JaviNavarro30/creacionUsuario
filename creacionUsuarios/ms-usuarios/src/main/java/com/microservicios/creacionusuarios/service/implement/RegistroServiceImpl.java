package com.microservicios.creacionusuarios.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicios.creacionusuarios.model.PhonesModel;
import com.microservicios.creacionusuarios.model.RegistroUsuarioModel;
import com.microservicios.creacionusuarios.model.UsuarioModel;
import com.microservicios.creacionusuarios.repository.RegistroRepository;
import com.microservicios.creacionusuarios.repository.UsuarioRepository;
import com.microservicios.creacionusuarios.request.RegistroUsuarioRequest;
import com.microservicios.creacionusuarios.response.ListaUsuariosResponse;
import com.microservicios.creacionusuarios.response.MensajeResponse;
import com.microservicios.creacionusuarios.response.RegistroUsuarioResponse;
import com.microservicios.creacionusuarios.responseContainer.ResponseListaUsuariosContainer;
import com.microservicios.creacionusuarios.responseContainer.ResponseRegistroContainer;
import com.microservicios.creacionusuarios.service.IRegistroUsuarioService;
import com.microservicios.creacionusuarios.utils.Utils;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegistroServiceImpl implements IRegistroUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RegistroRepository registroRepository;

    @Override
    public ResponseRegistroContainer registrarUsuario(RegistroUsuarioRequest req) {
        int mailExistente = 0;
        boolean flagPassword = false;
        
        ResponseRegistroContainer responseRegistroContainer = new ResponseRegistroContainer();
        
        RegistroUsuarioResponse registroUsuarioResponse = new RegistroUsuarioResponse();
        MensajeResponse mensajeResponse = new MensajeResponse();

        RegistroUsuarioModel registroUsuarioModel = new RegistroUsuarioModel();
        UsuarioModel usuarioModel = new UsuarioModel();

        List<PhonesModel> phones = new ArrayList<>();


        Utils utils = new Utils();

        try {

            if (utils.isValidEmail(req.getEmail())) {
            	
            	mailExistente = usuarioRepository.emailsRepetidos(req.getEmail());
                
                if (mailExistente != 1) {
                	
                    flagPassword = utils.isValidPassword(req.getPassword());
                    
                    if (flagPassword == true) {
                        
                    	//Registro telefonos
                        phones = utils.setPhones(req.getPhones());

                        
                        //Registro usuarios modelo
                        usuarioModel = utils.setUsuario(usuarioModel, req, phones);
                        usuarioRepository.save(usuarioModel);
    
                        //RegistroUsuario
                        registroUsuarioModel = utils.registroUsuario(usuarioModel, registroUsuarioModel);
                        registroRepository.save(registroUsuarioModel);
  
                       
                        registroUsuarioResponse = utils.registroUsuarioResponse(registroUsuarioModel, registroUsuarioResponse);
                        
                        mensajeResponse.setCodigo(200);
                        mensajeResponse.setMensaje("Operación exitosa");
                        responseRegistroContainer.setMensajeResponse(mensajeResponse);
                        
                    } else {
                        mensajeResponse.setCodigo(400);
                        mensajeResponse.setMensaje("La contraseña debe tener al entre 8 y 16 caracteres,"
                        		+ " considerar un dígito numerico, una minúscula, "
                        		+ " una mayúscula y un caracter no alfanumérico.");
                    }
                    
                } else {
                    mensajeResponse.setCodigo(400);
                    mensajeResponse.setMensaje("El correo ya esta registrado");
                }
                
            } else {
                mensajeResponse.setCodigo(400);
                mensajeResponse.setMensaje("Ingrese un correo válido con el siguiente formato: aaaaaaa@dominio.cl");
            }

        } catch (Exception e) {
            mensajeResponse.setCodigo(500);
            mensajeResponse.setMensaje("Error" + e.getMessage());
        } 
            responseRegistroContainer.setMensajeResponse(mensajeResponse);
            responseRegistroContainer.setRegistroUsuarioResponse(registroUsuarioResponse);

        
        return responseRegistroContainer;
        
    }


	@Override
	public ResponseListaUsuariosContainer obtenerUsuarios(String token) {
		
		String mensajeError = "Token no existente o no activo";
		int codigo404 = 404;
		
		List<UsuarioModel> usuarios = new ArrayList<>();
		RegistroUsuarioModel registroUsuarioModel = new RegistroUsuarioModel();
		ListaUsuariosResponse response = new ListaUsuariosResponse();
		MensajeResponse mensaje = new MensajeResponse();
		
		ResponseListaUsuariosContainer responseListaContainer = new ResponseListaUsuariosContainer();
		
		try {
			registroUsuarioModel = registroRepository.validateToken(token);
			if (registroUsuarioModel.isIsactive() == false) {
				usuarios = null;
				mensaje.setCodigo(codigo404);
				mensaje.setMensaje(mensajeError);
			} else {
				usuarios = usuarioRepository.findAll();
				mensaje.setCodigo(200);
				mensaje.setMensaje("Operación Exitosa");
			}
			response.setUsuarios(usuarios);
		} catch (Exception e) {
			usuarios = null;
			mensaje.setCodigo(codigo404);
			mensaje.setMensaje(mensajeError);
		}
		
		responseListaContainer.setMensajeResponse(mensaje);
		responseListaContainer.setListaUsuariosResponse(response);
		
		return responseListaContainer;
	}
}
