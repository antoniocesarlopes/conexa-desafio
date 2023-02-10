package br.com.conexa.common;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.text.StringEscapeUtils;

import br.com.conexa.model.Film;
import br.com.conexa.model.FilmDTO;

@SuppressWarnings("serial")
public class FilmConstants {
	public static final String API_FILM_BASE_URL = StringEscapeUtils.escapeJava("http://localhost:9090/api/films");
	public static final String INVALID_API_FILM_BASE_URL = StringEscapeUtils.escapeJava("http://localhost:0000/api/films");
	
	public static final Film FILM_EPISODE_04 = new Film("A New Hope", 4, "George Lucas", LocalDate.of(1977, 05, 25));
	public static final Film FILM_EPISODE_05 = new Film("The Empire Strikes Back", 5, "Irvin Kershner", LocalDate.of(1980, 05, 17));
	public static final Film FILM_EPISODE_06 = new Film("Return of the Jedi", 6, "Richard Marquand", LocalDate.of(1983, 05, 25));
	public static final Film FILM_EPISODE_03 = new Film("Revenge of the Sith", 3, "George Lucas", LocalDate.of(2005, 05, 19));
	public static final Film FILM_EPISODE_07 = new Film("Final Battle", 7, "James Cameron", LocalDate.of(2023, 10, 13));
	
	public static final FilmDTO FILM_DTO_EPISODE_04 = new FilmDTO("A New Hope", 4, "George Lucas", "25/05/1977");
	public static final FilmDTO FILM_DTO_EPISODE_05 = new FilmDTO("The Empire Strikes Back", 5, "Irvin Kershner", "17/05/1980");
	public static final FilmDTO FILM_DTO_EPISODE_06 = new FilmDTO("Return of the Jedi", 6, "Richard Marquand", "25/05/1983");
	public static final FilmDTO FILM_DTO_EPISODE_03 = new FilmDTO("Revenge of the Sith", 3, "George Lucas", "19/05/2005");
	public static final FilmDTO FILM_DTO_EPISODE_07 = new FilmDTO("Final Battle", 7, "James Cameron", "13/10/2023");

	public static final List<Film> FILMS = new ArrayList<>() {
		{
			add(FILM_EPISODE_04);
			add(FILM_EPISODE_05);
			add(FILM_EPISODE_06);
			add(FILM_EPISODE_03);
			add(FILM_EPISODE_07);
		}
	};

	public static final FilmDTO[] FILMS_DTO = new FilmDTO[]	{
			FILM_DTO_EPISODE_04,
			FILM_DTO_EPISODE_05,
			FILM_DTO_EPISODE_06,
			FILM_DTO_EPISODE_03
	};
	
	public static final FilmDTO[] FILMS_DTO_FULL = new FilmDTO[]	{
			FILM_DTO_EPISODE_04,
			FILM_DTO_EPISODE_05,
			FILM_DTO_EPISODE_06,
			FILM_DTO_EPISODE_03,
			FILM_DTO_EPISODE_07
	};

}
