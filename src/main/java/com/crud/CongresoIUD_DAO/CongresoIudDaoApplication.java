package com.crud.CongresoIUD_DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CongresoIudDaoApplication implements CommandLineRunner{

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(CongresoIudDaoApplication.class, args);
	}

	@Override
	public void run(String ...args) throws Exception{
		String password = "Contra1234";
		for(int i = 0; i < 2; i++) {
			String encoded = passwordEncoder.encode(password);
			System.out.println("CONTRASEÑA: " + encoded);
		}
	}
}
