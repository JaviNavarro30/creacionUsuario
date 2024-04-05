package com.microservicios.creacionusuarios.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.microservicios.creacionusuarios.model.PhonesModel;
import com.microservicios.creacionusuarios.model.RegistroUsuarioModel;
import com.microservicios.creacionusuarios.model.UsuarioModel;
import com.microservicios.creacionusuarios.request.RegistroUsuarioRequest;
import com.microservicios.creacionusuarios.response.RegistroUsuarioResponse;

public class Utils {
	
    public boolean isValidEmail(String email) {
   	 String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
   }

    public boolean isValidPassword(String password) {
       String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,16}$";
       Pattern pattern = Pattern.compile(regex);
       Matcher matcher = pattern.matcher(password);
       return matcher.matches();
   }

    public String generateToken() {
   	 return UUID.randomUUID().toString();
   }
    
    public List<PhonesModel> setPhones (List<PhonesModel> phones){
    	 	
    	for (int i = 0; i > phones.size(); i++) {
            PhonesModel phone = new PhonesModel();
            phone.setNumber(phones.get(i).getNumber());
            phone.setCitycode(phones.get(i).getCitycode());
            phone.setContrycode(phones.get(i).getContrycode());
            phones.add(phone);
        }
    	
    	return phones;
    	
    }
    
    public UsuarioModel setUsuario (UsuarioModel usuario, RegistroUsuarioRequest req, List<PhonesModel> phones){
    	
    	usuario.setName(req.getName());
    	usuario.setEmail(req.getEmail());
    	usuario.setPassword(req.getPassword());
    	usuario.setPhones(phones);

    	return usuario;
    }
    
    public RegistroUsuarioModel registroUsuario (UsuarioModel usuario, RegistroUsuarioModel registro) {
    	
    	registro.setId(generateToken());
    	registro.setCreated(Calendar.getInstance().getTime());
    	registro.setModified(Calendar.getInstance().getTime());
    	registro.setLast_login(Calendar.getInstance().getTime());
    	registro.setToken(registro.getId());
    	registro.setIsactive(true);
    	registro.setFkUsuario(usuario);
    	
    	
    	return registro;
    	
    }
    
    public RegistroUsuarioResponse registroUsuarioResponse (RegistroUsuarioModel registro, RegistroUsuarioResponse res) {
    	
    	res.setId(registro.getToken());
    	res.setCreated(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(registro.getCreated()));
    	res.setModified(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(registro.getModified()));
    	res.setLastLogin(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(registro.getLast_login()));
    	res.setToken(registro.getToken());
    	res.setIsActive(registro.isIsactive());
    	
    	return res;
    }

}
