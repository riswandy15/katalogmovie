package com.greenleaf.katalogmovie.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ResponseRepos{

	@SerializedName("page")
	private int page;

	@SerializedName("total_results")
	private int totalResults;

	@SerializedName("total_pages")
	private int totalPages;

	@SerializedName("results")
	private List<ResultsItem> results;

	public void setPage(int page){
		this.page = page;
	}

	public int getPage(){
		return page;
	}

	public void setTotalPages(int totalPages){
		this.totalPages = totalPages;
	}

	public int getTotalPages(){
		return totalPages;
	}

	public void setResults(List<ResultsItem> results){
		this.results = results;
	}

	public List<ResultsItem> getResults(){
		return results;
	}

	public void setTotalResults(int totalResults){
		this.totalResults = totalResults;
	}

	public int getTotalResults(){
		return totalResults;
	}

	@Override
 	public String toString(){
		return 
			"ResponseRepos{" + 
			"page = '" + page + '\'' +
			",total_results = '" + totalResults + '\'' +
			",total_pages = '" + totalPages + '\'' + 
			",results = '" + results + '\'' +
			"}";
		}
}