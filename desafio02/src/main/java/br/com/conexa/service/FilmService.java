package br.com.conexa.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.conexa.model.Film;
import br.com.conexa.model.FilmDTO;
import br.com.conexa.repository.FilmRepository;

@Service
public class FilmService {
	
	private static final String API_FILM_BASE_URL = StringEscapeUtils.escapeJava("http://localhost:9090/api/films");

	private RestTemplate restTemplate;
	
	private FilmRepository filmRepository;

	public FilmService(RestTemplate restTemplate, FilmRepository filmRepository) {
		super();
		this.restTemplate = restTemplate;
		this.filmRepository = filmRepository;
	}
	
	public void handleLukeFilmography() {
		
		var searchForLukeResult = getFilmList();

		if(searchForLukeResult.isPresent()) {
			
			List<Film> persistedFilms = saveFilmList(searchForLukeResult.get());
			
			if(persistedFilms != null) {
				persistedFilms.stream().forEach( f -> System.out.println(f));
			}
			
		}	
	}

	private List<Film> saveFilmList(FilmDTO[] filmDTOs) {
		List<FilmDTO> filmList = new ArrayList<>(Arrays.asList(filmDTOs));
		filmList.add(addNewFilmRelease());
		
		return filmRepository
				.saveAllAndFlush(this.parseListDTO(filmList));
	}

	private Optional<FilmDTO[]> getFilmList() {
		return Optional.ofNullable(
				restTemplate
				.getForEntity(API_FILM_BASE_URL, FilmDTO[].class)
				.getBody()
				);
	}
	
	private FilmDTO addNewFilmRelease() {
		FilmDTO newRelease = new FilmDTO();
		newRelease.setTitle("Final Battle");
		newRelease.setEpisode(7);
		newRelease.setDirector("James Cameron");
		newRelease.setReleaseDate("13/10/1983");
		
		return newRelease;
	}
	
	private Iterable<Film> parseListDTO(List<FilmDTO> filmList) {
		List<Film> parsedFilmList = new ArrayList<>();
		if(filmList != null) {
			parsedFilmList = filmList
					.stream()
					.map(dto -> parseDTO(dto))
					.collect(Collectors.toList());
		}
		return parsedFilmList;
	}

	private Film parseDTO(FilmDTO dto) {
		return new Film(dto.getTitle(), dto.getEpisode(), dto.getDirector(), dto.getReleaseDateFormated());
	}
	
}
