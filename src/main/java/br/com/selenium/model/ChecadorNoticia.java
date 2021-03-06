package br.com.selenium.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder(toBuilder = true)
@Data
@Table(name="checador_noticias")
@NoArgsConstructor
@AllArgsConstructor
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
	
	private String atual;
	
	private String projecao;
	
	private String previo;

}
