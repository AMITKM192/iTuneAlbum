package com.learntodroid.mvvmrestapi.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.learntodroid.mvvmrestapi.models.AlbumResponse;
import com.learntodroid.mvvmrestapi.repositories.AlbumRepository;

import java.util.ArrayList;

public class AlbumSearchViewModel extends AndroidViewModel {
    private AlbumRepository albumRepository;
    private AlbumResponse.Result[] albumResponseLiveData;

    public AlbumSearchViewModel(@NonNull Application application) {
        super(application);
    }

    public void init() {
        albumRepository = new AlbumRepository();
    }

    public void searchAlbums(String keyword) {
        albumRepository.searchAlbums(keyword);
    }

}