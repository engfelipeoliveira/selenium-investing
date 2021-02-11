package br.com.selenium.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Entity
@Builder(toBuilder = true)
@Data
public class ChecadorNoticia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String dia;
	
	private String hora;
	
	private String pais;
	
	private String forca;
	
	private String evento;
	
	private String isDiscurso;
	
	private BigDecimal atual;
	
	private BigDecimal projecao;
	
	private BigDecimal previo;

}
