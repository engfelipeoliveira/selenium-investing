package br.com.selenium.service;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class MainServiceImpl implements MainService {

	private static final Logger LOG = getLogger(MainServiceImpl.class);
	
	private WebDriver setupSelenium() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://br.investing.com/economic-calendar/");
		
		return driver;
	}

	@Override
	public void execute() {
		WebDriver driver = this.setupSelenium();
		WebElement table = driver.findElement(By.id("economicCalendarData"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for(WebElement row : rows) {
			List<WebElement> cols = table.findElements(By.tagName("td"));
			System.out.println("Hora : " + row.getAttribute("data-event-datetime"));
			System.out.println("Moeda : " + cols.get(2).getText());
			System.out.println("Importancia : " + cols.get(3).getText());
			System.out.println("Evento : " + cols.get(4).getText());
			System.out.println("Atual : " + cols.get(5).getText());
			System.out.println("Projecao : " + cols.get(6).getText());
			System.out.println("Previo : " + cols.get(7).getText());
			
			System.out.println("-------------------------------------------------");
		}
		
		driver.close();		
		driver.quit();
	}
	
	

}
