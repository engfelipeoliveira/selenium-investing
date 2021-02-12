package br.com.selenium.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.selenium.model.ChecadorNoticia;

@Repository
public interface ChecadorNoticiaRepository extends JpaRepository<ChecadorNoticia, Long> {

	ChecadorNoticia findFirstByDiaAndHoraAndPaisAndEvento(String dia, String hora, String pais, String evento);
	
}
