package com.miraz.tvmaze.model.apiservice;


import com.miraz.tvmaze.model.entitites.CastCredit;
import com.miraz.tvmaze.model.entitites.Episode;
import com.miraz.tvmaze.model.entitites.Search;
import com.miraz.tvmaze.model.entitites.SearchPerson;
import com.miraz.tvmaze.model.entitites.Show;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("shows")
    Call<List<Show>> getShows( @Query("page") int page);

    @GET("search/shows")
    Call<List<Search>> getQuery(@Query("q") String query);

    @GET("shows/{id}/episodes")
    Call<List<Episode>> getEpisodes(@Path("id") int id);

    @GET("search/people")
    Call<List<SearchPerson>> getPeople(@Query("q") String query);

    @GET("people/{id}/castcredits?embed=show")
    Call<List<CastCredit>> getCastCredits(@Path("id") int id);

    @GET("shows/{id}")
    Call<Show> getShow(@Path("id") int id);

}
