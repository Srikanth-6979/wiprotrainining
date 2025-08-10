package com.wipro.filesdemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileDemo1 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		String ip = "//D:Wipro_logo.png";
        String op = "//D:Wipro_logo_new.png";

        try (
            FileInputStream fi = new FileInputStream(ip);
            FileOutputStream fo = new FileOutputStream(op);
        ) {
            byte[] buffer = new byte[1024];
            int bytesRead = 0;

            try {
            	while ((bytesRead = fi.read(buffer)) != -1) {
                    fo.write(buffer, 0, bytesRead);
                }
            

            	System.out.println("Image copied....");
            } catch (IOException e) {
            	System.out.println("Error : " + e.getMessage());
            }
        }
	}

}
