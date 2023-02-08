package br.com.conexa.service;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.conexa.model.People;
import br.com.conexa.model.PeopleSearchResult;

@Service
public class PeopleService {

	private static final String API_BASE_URL = "https://swapi.dev/api/";

	private RestTemplate restTemplate;

	public PeopleService(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}

	public Optional<People> findByName(String name) {
		final String QUERY_PEOPLE_SEARCH = "people?search=%s";

		var searchForLukeResult = Optional.ofNullable(
				restTemplate
				.getForEntity(String.format(API_BASE_URL + QUERY_PEOPLE_SEARCH, name), PeopleSearchResult.class)
				.getBody()
				);

		if(searchForLukeResult.isPresent()) {
			return searchForLukeResult.get().getFirstResult();
		}	


		return Optional.empty();
	}


}
