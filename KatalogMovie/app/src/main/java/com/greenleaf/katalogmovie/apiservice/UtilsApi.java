package com.greenleaf.katalogmovie.apiservice;

public class UtilsApi {

    private static final String BASE_URL_API="https://api.themoviedb.org/";

    public static BaseApiService getAPIService(){
        return Client.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
