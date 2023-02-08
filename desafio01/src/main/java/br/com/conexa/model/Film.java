package br.com.conexa.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"title", "episode", "director", "releaseDate"})
public class Film {
	
	@JsonProperty("title")
	public String title;
	@JsonProperty("episode_id")
	public Integer episode;
	@JsonProperty("director")
	public String director;
	@JsonProperty("release_date")
	public String releaseDate;

	public Film() {
		super();
	}

	public Film(String title, Integer episode, String director, String releaseDate) {
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

	public String getRelease_date() {
		if(StringUtils.isNotBlank(releaseDate)) {
			//			1977-05-25
			DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd");
			DateFormat targetFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date date;
			try {
				date = originalFormat.parse(releaseDate);
			} catch (ParseException e) {
				return releaseDate;
			}
			return targetFormat.format(date);
		}else {
			return releaseDate;
		}
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

}
