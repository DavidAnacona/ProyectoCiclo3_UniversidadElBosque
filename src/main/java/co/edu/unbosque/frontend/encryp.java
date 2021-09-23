package co.edu.unbosque.frontend;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class encryp {
	private String claveSecreta = "ubosque";
	
	private SecretKeySpec secretKey(String clave) throws UnsupportedEncodingException, NoSuchAlgorithmException{
		byte[] claveEncriptacion = clave.getBytes("UTF-8");
		
		MessageDigest sha = MessageDigest.getInstance("SHA-1");
		
		claveEncriptacion = sha.digest(claveEncriptacion);
		claveEncriptacion = Arrays.copyOf(claveEncriptacion, 16);
		
		SecretKeySpec secretKey = new SecretKeySpec(claveEncriptacion, "AES");
		
		return secretKey;
	}
	
	public String encriptar(String Password) throws UnsupportedEncodingException{
		SecretKeySpec secretKey = null;
		try {
			secretKey = this.secretKey(claveSecreta);
		} catch (UnsupportedEncodingException | NoSuchAlgorithmException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Cipher cipher = null;
		try {
			cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		} catch (InvalidKeyException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		byte[] passEncriptar = Password.getBytes("UTF-8");
		byte[] bytesEncriptados = null;
		try {
			bytesEncriptados = cipher.doFinal(passEncriptar);
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String encriptado = Base64.getEncoder().encodeToString(bytesEncriptados);
		
		return encriptado;
	}

}
