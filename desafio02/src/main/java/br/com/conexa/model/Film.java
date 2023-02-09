package br.com.conexa.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="films")
public class Film implements Serializable {
	
	private static final long serialVersionUID = -188891432348065457L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "title", nullable = false, length = 80)
	public String title;
	
	@Column(name = "episode_id", nullable = false)
	public Integer episode;
	
	@Column(name = "director", nullable = false, length = 80)
	public String director;
	
	@Column(name = "release_date", nullable = false)
	@Temporal(TemporalType.DATE)
	public LocalDate releaseDate;

	public Film() {
		super();
	}
	
	public Film(Long id, String title, Integer episode, String director, LocalDate releaseDate) {
		super();
		this.id = id;
		this.title = title;
		this.episode = episode;
		this.director = director;
		this.releaseDate = releaseDate;
	}

	public Film(String title, Integer episode, String director, LocalDate releaseDate) {
		this(null, title, episode, director, releaseDate);
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

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getReleaseDateStr() {
		if(releaseDate != null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			return releaseDate.format(formatter);
		}else {
			return null;
		}
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", title=" + title + ", episode=" + episode + ", director=" + director + ", releaseDate=" + getReleaseDateStr() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(director, episode, id, releaseDate, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Film)) {
			return false;
		}
		Film other = (Film) obj;
		return Objects.equals(director, other.director) && Objects.equals(episode, other.episode)
				&& Objects.equals(id, other.id) && Objects.equals(releaseDate, other.releaseDate)
				&& Objects.equals(title, other.title);
	}
	
}
