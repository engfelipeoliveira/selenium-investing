package br.com.selenium.service;

import java.util.List;

import br.com.selenium.model.ChecadorNoticia;

public interface ChecadorNoticiaService {

	void save(List<ChecadorNoticia> checadorNoticia) throws Exception;
	ChecadorNoticia getByDiaHoraPaisEvento(String dia, String hora, String pais, String evento);

}
