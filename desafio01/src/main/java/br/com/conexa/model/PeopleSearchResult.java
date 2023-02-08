package br.com.conexa.model;

import java.util.ArrayList;
import java.util.Optional;

public class PeopleSearchResult{
	public int count;
	public Object next;
	public Object previous;
	public ArrayList<People> results;

	public PeopleSearchResult() {
		super();
	}

	public PeopleSearchResult(int count, Object next, Object previous, ArrayList<People> results) {
		super();
		this.count = count;
		this.next = next;
		this.previous = previous;
		this.results = results;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Object getNext() {
		return next;
	}

	public void setNext(Object next) {
		this.next = next;
	}

	public Object getPrevious() {
		return previous;
	}

	public void setPrevious(Object previous) {
		this.previous = previous;
	}

	public ArrayList<People> getResults() {
		return results;
	}

	public void setResults(ArrayList<People> results) {
		this.results = results;
	}

	public boolean hasResults() {
		return this.results != null && !this.results.isEmpty();
	}

	public Optional<People> getFirstResult() {
		return this.hasResults() ? this.results.stream().findFirst() : Optional.empty();
	}

}
