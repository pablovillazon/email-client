package com.pablo.emailclient;

import com.pablo.emailclient.Components.Element;
import com.pablo.emailclient.Controllers.MainController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmailClientApplication implements CommandLineRunner {

	private static Logger LOG = LoggerFactory
			.getLogger(EmailClientApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EmailClientApplication.class, args);
	}

	@Override
	public void run(String... args) {
		LOG.info("EXECUTING : command line runner");
		Element emailClient = new MainController().start();

		for (int i = 0; i < args.length; ++i) {
			LOG.info("args[{}]: {}", i, args[i]);
		}
	}
}

