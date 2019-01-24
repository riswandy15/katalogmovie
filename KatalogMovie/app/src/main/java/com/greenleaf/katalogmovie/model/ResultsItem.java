package com.greenleaf.katalogmovie.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResultsItem{

	@SerializedName("vote_count")
	private int voteCount;

	@SerializedName("id")
	private int id;

	@SerializedName("video")
	private boolean video;

	@SerializedName("vote_average")
	private double voteAverage;

	@SerializedName("title")
	private String title;

	@SerializedName("popularity")
	private double popularity;

	@SerializedName("poster_path")
	private String posterPath;

	@SerializedName("original_language")
	private String originalLanguage;

	@SerializedName("original_title")
	private String originalTitle;

	@SerializedName("genre_ids")
	private List<Integer> genreIds;

	@SerializedName("backdrop_path")
	private String backdropPath;

	@SerializedName("adult")
	private boolean adult;

	@SerializedName("overview")
	private String overview;

	@SerializedName("release_date")
	private String releaseDate;

	public void setOverview(String overview){
		this.overview = overview;
	}

	public String getOverview(){
		return overview;
	}

	public void setOriginalLanguage(String originalLanguage){
		this.originalLanguage = originalLanguage;
	}

	public String getOriginalLanguage(){
		return originalLanguage;
	}

	public void setOriginalTitle(String originalTitle){
		this.originalTitle = originalTitle;
	}

	public String getOriginalTitle(){
		return originalTitle;
	}

	public void setVideo(boolean video){
		this.video = video;
	}

	public boolean isVideo(){
		return video;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setGenreIds(List<Integer> genreIds){
		this.genreIds = genreIds;
	}

	public List<Integer> getGenreIds(){
		return genreIds;
	}

	public void setPosterPath(String posterPath){
		this.posterPath = posterPath;
	}

	public String getPosterPath(){
		return posterPath;
	}

	public void setBackdropPath(String backdropPath){
		this.backdropPath = backdropPath;
	}

	public String getBackdropPath(){
		return backdropPath;
	}

	public void setReleaseDate(String releaseDate){
		this.releaseDate = releaseDate;
	}

	public String getReleaseDate(){
		return releaseDate;
	}

	public void setVoteAverage(double voteAverage){
		this.voteAverage = voteAverage;
	}

	public double getVoteAverage(){
		return voteAverage;
	}

	public void setPopularity(double popularity){
		this.popularity = popularity;
	}

	public double getPopularity(){
		return popularity;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setAdult(boolean adult){
		this.adult = adult;
	}

	public boolean isAdult(){
		return adult;
	}

	public void setVoteCount(int voteCount){
		this.voteCount = voteCount;
	}

	public int getVoteCount(){
		return voteCount;
	}

	@Override
 	public String toString(){
		return
			"ResultsItem{" +
			"vote_count = '" + voteCount + '\'' +
			",id = '" + id + '\'' +
			",video = '" + video + '\'' +
			",vote_average = '" + voteAverage + '\'' +
			",title = '" + title + '\'' +
			",popularity = '" + popularity + '\'' +
			",poster_path = '" + posterPath + '\'' +
			",original_language = '" + originalLanguage + '\'' + 
			",original_title = '" + originalTitle + '\'' +
			",genre_ids = '" + genreIds + '\'' +
			",backdrop_path = '" + backdropPath + '\'' +
			",adult = '" + adult + '\'' +
			",overview = '" + overview + '\'' +
			",release_date = '" + releaseDate + '\'' +
			"}";
		}
}