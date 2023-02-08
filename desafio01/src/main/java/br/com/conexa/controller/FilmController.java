package br.com.conexa.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.conexa.model.Film;
import br.com.conexa.service.FilmService;

@RestController
@RequestMapping("/api/films")
public class FilmController {

	private FilmService filmService;

	public FilmController(FilmService filmService) {
		super();
		this.filmService = filmService;
	}

	@GetMapping
	public ResponseEntity<List<Film>> list(
			@RequestParam(value = "page", defaultValue = "1") Integer page, 
			@RequestParam(value = "size", defaultValue = "10") Integer pageSize,
			@RequestParam(required = false) String title,
			@RequestParam(required = false) Integer episode)

	{
		List<Film> films = filmService.list(page, pageSize, title, episode);
		return ResponseEntity.ok(films);
	}

}
