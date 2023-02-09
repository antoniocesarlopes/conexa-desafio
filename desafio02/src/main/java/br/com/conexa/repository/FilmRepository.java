package br.com.conexa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.conexa.model.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long>{
	
}