package Suport;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Generator {
	public static String registrarDataHora() {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		return new SimpleDateFormat("yyyyMMddhhmmss").format(ts);
		
		
		
		
	}

}