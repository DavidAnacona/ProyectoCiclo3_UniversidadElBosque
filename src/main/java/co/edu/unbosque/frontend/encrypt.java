package co.edu.unbosque.frontend;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import co.edu.unbosque.frontend.encryp;

public class encrypt {
	encryp encryptar = new encryp();
	
	public String passEncrypt(String Password) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		String encriptado;
		try {
			encriptado = encryptar.encriptar(Password);
			return encriptado;
		}catch(UnsupportedEncodingException ex) {
			Logger.getLogger(encryp.class.getName()).log(Level.SEVERE, null, ex);
		}
		return "Error";
	}
	
}
