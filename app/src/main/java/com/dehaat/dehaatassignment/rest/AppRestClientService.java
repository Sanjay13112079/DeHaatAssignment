package com.dehaat.dehaatassignment.rest;

import com.dehaat.dehaatassignment.data.AuthorsData;
import com.google.gson.JsonElement;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AppRestClientService {

    @GET("https://673941ce-1e8f-4a94-ae11-7f490105f07f.mock.pstmn.io/getAuthors/")
    Call<AuthorsData.Data> getListOfAuthors();

}
