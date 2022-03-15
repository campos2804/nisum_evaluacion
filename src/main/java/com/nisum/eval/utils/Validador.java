package com.nisum.eval.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validador {
	public static boolean valCorreo(String correo) {
		
		Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");		
		Matcher mather = pattern.matcher(correo);		
		if (mather.find() ) {
            return true;
        } else {
            return false;
        }
	}
	
	
	
	public static boolean valPass(String password, String regex) {		
		Pattern pattern = Pattern
                .compile(regex);		
		Matcher mather = pattern.matcher(password);		
		if (mather.find()) {
            return true;
        } else {
            return false;
        }
	}
}
