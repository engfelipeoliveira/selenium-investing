package br.com.selenium.service;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.selenium.model.ChecadorNoticia;

@Service
public class MainServiceImpl implements MainService {

	private static final Logger LOG = getLogger(MainServiceImpl.class);
	
	private ChecadorNoticiaService checadorNoticiaService;
	
	public MainServiceImpl(ChecadorNoticiaService checadorNoticiaService) {
		super();
		this.checadorNoticiaService = checadorNoticiaService;
	}

	@Value("${url.investing.economic.calendar}")
	private String URL_INVESTING;
	
	private WebDriver setupSelenium() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);
		driver.get(URL_INVESTING);
		
		return driver;
	}

	private Optional<ChecadorNoticia> parseRowToEntity(WebElement row, List<WebElement> cols) {
		String diaHora = row.getAttribute("data-event-datetime");
		if(StringUtils.isNotBlank(diaHora)) {
			//String dia = diaHora.substring(0, 5);
			//String hora = diaHora.substring(6, 10);
			String pais = cols.get(2).getText();
			System.out.println("Importancia : " + cols.get(3).getText());
			System.out.println("Evento : " + cols.get(4).getText());
			System.out.println("Atual : " + cols.get(5).getText());
			System.out.println("Projecao : " + cols.get(6).getText());
			System.out.println("Previo : " + cols.get(7).getText());
			
			return Optional.of(ChecadorNoticia.builder()
					//.dia(dia)
					//.hora(hora)
					.pais(pais)
					.build());			
		}else {
			return Optional.empty();
		}

	}

	@Override
	public void execute() {
		WebDriver driver = this.setupSelenium();
		WebElement table = driver.findElement(By.id("economicCalendarData"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		List<ChecadorNoticia> checadorNoticias = new ArrayList<ChecadorNoticia>();
		
		rows.stream().forEach(row -> {
			List<WebElement> cols = table.findElements(By.tagName("td"));
			
			if(parseRowToEntity(row, cols).isPresent()) {
				checadorNoticias.add(parseRowToEntity(row, cols).get());	
			}
			
		});

		driver.close();
		driver.quit();
		
		this.checadorNoticiaService.save(checadorNoticias);
	}
	
	

}
