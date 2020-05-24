package br.com.romero.jobapigatos.schedules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.romero.jobapigatos.services.CatService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UpdateSchedule {

	@Autowired
	private CatService catService; 
	
	
	@Scheduled(fixedDelay = 5 * 60000)
	public void update() {
		log.info("Atualizando a api de Gatos -> init_process");
		catService.loadingCats();
	}
}
