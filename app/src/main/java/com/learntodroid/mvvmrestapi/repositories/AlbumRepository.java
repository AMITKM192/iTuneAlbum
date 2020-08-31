package com.learntodroid.mvvmrestapi.repositories;

import com.learntodroid.mvvmrestapi.apis.AlbumSearchService;
import com.learntodroid.mvvmrestapi.models.AlbumResponse;
import com.learntodroid.mvvmrestapi.views.AlbumSearchFragment;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class AlbumRepository {
    private static final String ALBUM_SEARCH_SERVICE_BASE_URL = "https://itunes.apple.com";

    private AlbumSearchService albumSearchService;
    private AlbumResponse albumResponseLiveData;

    public AlbumRepository() {
        albumResponseLiveData = new AlbumResponse();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        albumSearchService = new retrofit2.Retrofit.Builder()
                .baseUrl(ALBUM_SEARCH_SERVICE_BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(AlbumSearchService.class);
    }

    public void searchAlbums(String keyword) {
        albumSearchService.searchAlbum()
                .enqueue(new Callback<AlbumResponse>() {
                    @Override
                    public void onResponse(Call<AlbumResponse> call, Response<AlbumResponse> response) {
                        if (response.body() != null) {
                            albumResponseLiveData = response.body();
                            AlbumSearchFragment albumSearchFragment= new AlbumSearchFragment();
                            albumSearchFragment.refreshData(albumResponseLiveData.results);
                        }
                    }

                    @Override
                    public void onFailure(Call<AlbumResponse> call, Throwable t) {
                        albumResponseLiveData = null;
                    }
                });
    }

}