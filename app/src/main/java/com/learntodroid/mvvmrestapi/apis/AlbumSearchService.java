package com.learntodroid.mvvmrestapi.apis;

import com.learntodroid.mvvmrestapi.models.AlbumResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AlbumSearchService {
    @GET("/search?term=all")
    Call<AlbumResponse> searchAlbum();
}