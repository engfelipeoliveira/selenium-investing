package br.com.selenium;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import br.com.selenium.service.MainService;

@SpringBootApplication
@EnableScheduling
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
	}

	@Scheduled(cron = "${job.cron}")
	private void execute() throws InterruptedException {
		this.mainService.execute();

	}

}
