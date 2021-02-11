package br.com.selenium;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.selenium.service.MainService;

@SpringBootApplication
public class SeleniumInvestingApplication implements CommandLineRunner {
	
	private final MainService mainService;
	
	public SeleniumInvestingApplication(MainService mainService) {
		this.mainService = mainService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SeleniumInvestingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.mainService.execute();
	}

}
