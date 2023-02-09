package br.com.conexa.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"title", "episode", "director", "releaseDate"})
public class FilmDTO {
	
	@JsonProperty("title")
	public String title;
	@JsonProperty("episode_id")
	public Integer episode;
	@JsonProperty("director")
	public String director;
	@JsonProperty("release_date")
	public String releaseDate;

	public FilmDTO() {
		super();
	}

	public FilmDTO(String title, Integer episode, String director, String releaseDate) {
		super();
		this.title = title;
		this.episode = episode;
		this.director = director;
		this.releaseDate = releaseDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getEpisode() {
		return episode;
	}

	public void setEpisode(Integer episode) {
		this.episode = episode;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public LocalDate getReleaseDateFormated() {
		if(StringUtils.isNotBlank(this.releaseDate)) {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			return LocalDate.parse(this.releaseDate, formatter);
		}
		return null;
	}
	
	@Override
	public String toString() {
		return "Film [title=" + title + ", episode=" + episode + ", director=" + director + ", releaseDate=" + getReleaseDate() + "]";
	}

}
