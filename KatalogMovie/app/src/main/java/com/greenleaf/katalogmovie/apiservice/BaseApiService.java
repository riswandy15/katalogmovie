package com.greenleaf.katalogmovie.apiservice;

import com.greenleaf.katalogmovie.model.ResponseRepos;
import com.greenleaf.katalogmovie.model.ResultsItem;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import io.reactivex.Observable;

public interface BaseApiService {
    @GET("3/search/movie?api_key=9794b8f5fe7dc2310507fc212b73793e&language=en-US")
    Observable<ResponseRepos>  requestRepos(@Query("query") String title);
}
