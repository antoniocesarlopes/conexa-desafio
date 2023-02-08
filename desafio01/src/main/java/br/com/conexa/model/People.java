package br.com.conexa.model;

import java.util.ArrayList;

public class People{
    public String name;
    public ArrayList<String> films;
    
	public People() {
		super();
	}

	public People(String name, ArrayList<String> films) {
		super();
		this.name = name;
		this.films = films;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public ArrayList<String> getFilms() {
		return films;
	}

    
}
