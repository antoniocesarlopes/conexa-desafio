package br.com.conexa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.conexa.model.Film;
import br.com.conexa.model.People;
import br.com.conexa.util.ListUtils;

@Service
public class FilmService {

	private RestTemplate restTemplate;
	private PeopleService peopleService;

	public FilmService(RestTemplate restTemplate, PeopleService peopleService) {
		super();
		this.restTemplate = restTemplate;
		this.peopleService = peopleService;
	}

	public List<Film> list(Integer page, Integer pageSize, String title, Integer episodeId) {

		final String SEARCH_NAME = "Luke";
		
		List<Film> filmList = new ArrayList<>();
		
		var optPeopleLuke = peopleService.findByName(SEARCH_NAME);

		if( optPeopleLuke.isPresent()) {
			filmList = filterFilmResult(title, episodeId, optPeopleLuke.get());
		}
		
		if(filmList != null && !filmList.isEmpty()) {
			filmList = ListUtils.getPage(filmList, page, pageSize);
		}
		
		return filmList;
	}

	private List<Film> filterFilmResult(String title, Integer episodeId, People peopleLuke) {
		List<Film> filmList = new ArrayList<>();
		
		for(String urlFilm : peopleLuke.getFilms()){
			Optional<Film> film = Optional.ofNullable(restTemplate.getForEntity(urlFilm, Film.class).getBody());
			if(film.isPresent()) {
				boolean filtrosOk = true;
				if(StringUtils.isNotBlank(title) && !film.get().getTitle().contains(title)) {
					filtrosOk = false;
				}
				if(episodeId != null && !film.get().getEpisode().equals(episodeId)) {
					filtrosOk = false;
				}
				if(filtrosOk) {
					filmList.add(film.get());
				}
			}
		}
		return filmList;
	}

}
