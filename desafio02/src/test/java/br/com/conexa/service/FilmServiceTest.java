package br.com.conexa.service;

import static br.com.conexa.common.FilmConstants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.conexa.model.Film;
import br.com.conexa.model.FilmDTO;
import br.com.conexa.repository.FilmRepository;

@ExtendWith(MockitoExtension.class)
@SuppressWarnings("serial")
public class FilmServiceTest {
	
	  @InjectMocks
	  private FilmService filmService;

	  @Mock
	  private FilmRepository filmRepository;
	  
	  @Mock
	  private RestTemplate restTemplate;


	  @Test
	  public void listFilm_returnAllLukeFilms_plusNewRelease() {
		  
          when(restTemplate.getForEntity(
            API_FILM_BASE_URL, FilmDTO[].class))
          .thenReturn(new ResponseEntity<FilmDTO[]>(FILMS_DTO, HttpStatus.OK));
          
          when(filmRepository
			.saveAllAndFlush(FILMS)).thenReturn(FILMS);
		  
		  List<Film> sut = filmService.handleLukeFilmography();
		  
		  assertThat(sut).isNotNull();
		  assertThat(sut).isNotEmpty();
		  assertThat(sut).hasSize(5);
		  assertThat(sut.get(4)).isEqualTo(FILM_EPISODE_07);
	  }
	  
	  @Test
	  public void listFilm_WithClientOffLine_ThrowsException() {
	    when(restTemplate.getForEntity(
	    		INVALID_API_FILM_BASE_URL, FilmDTO[].class)).thenThrow(new RuntimeException());

	    assertThatThrownBy(() -> filmService.handleLukeFilmography()).isInstanceOf(RuntimeException.class);
	  }
	  
}
