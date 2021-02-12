package br.com.selenium.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.selenium.model.ChecadorNoticia;
import br.com.selenium.repository.ChecadorNoticiaRepository;

@Service
public class ChecadorNoticiaServiceImpl implements ChecadorNoticiaService {

	private ChecadorNoticiaRepository checadorNoticiaRepository;
	
	public ChecadorNoticiaServiceImpl(ChecadorNoticiaRepository checadorNoticiaRepository) {
		super();
		this.checadorNoticiaRepository = checadorNoticiaRepository;
	}

	@Override
	public void save(List<ChecadorNoticia> checadorNoticia) throws Exception{
		this.checadorNoticiaRepository.saveAll(checadorNoticia);
	}

	@Override
	public ChecadorNoticia getByDiaHoraPaisEvento(String dia, String hora, String pais, String evento) {
		return this.checadorNoticiaRepository.findFirstByDiaAndHoraAndPaisAndEvento(dia, hora, pais, evento);
	}

}
