package br.com.conexa.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.com.conexa.model.Film;
import br.com.conexa.service.FilmService;

@Component
public class RunAfterStartup {
	
	@Autowired
	private FilmService filmService;
	
	@EventListener(ApplicationReadyEvent.class)
	public void runAfterStartup() {
	    System.out.println("------------------------------------------------");
	    System.out.println("---S-T-A-R----W-A-R-S---M-O-V-I-E-S-------------");
	    System.out.println("------------------------------------------------");
	    List<Film> persistedFilms = filmService.handleLukeFilmography();
	    if(persistedFilms != null) {
			persistedFilms.stream().forEach( f -> System.out.println(f));
		}
	}

}
