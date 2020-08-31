package com.learntodroid.mvvmrestapi.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.learntodroid.mvvmrestapi.R;
import com.learntodroid.mvvmrestapi.adapters.AlbumSearchResultsAdapter;
import com.learntodroid.mvvmrestapi.models.AlbumResponse;
import com.learntodroid.mvvmrestapi.util.Util;
import com.learntodroid.mvvmrestapi.viewmodels.AlbumSearchViewModel;

import java.util.Arrays;

public class AlbumSearchFragment extends Fragment {
    private AlbumSearchViewModel viewModel;
    private AlbumSearchResultsAdapter adapter;

    private TextInputEditText keywordEditText;
    private Button searchButton;
    public static AlbumResponse.Result[] mData;
    RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_booksearch, container, false);
        viewModel = ViewModelProviders.of(this).get(AlbumSearchViewModel.class);
        viewModel.init();
        viewModel.searchAlbums("all");
        recyclerView = view.findViewById(R.id.fragment_booksearch_searchResultsRecyclerView);

        keywordEditText = view.findViewById(R.id.fragment_booksearch_keyword);
        searchButton = view.findViewById(R.id.btn_search);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String keyword = keywordEditText.getEditableText().toString();
                performSearch(keyword);
            }
        });
        return view;
    }

    public void refreshData(AlbumResponse.Result[] results){
        adapter = new AlbumSearchResultsAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        adapter.setResults(Arrays.asList(results));
    }

    public void performSearch(String keyword) {
        Util util = new Util();
        AlbumResponse.Result[] fData = util.getFilterResult(mData, keyword);
        if (fData != null) {
            adapter.setResults(Arrays.asList(fData));
        }
    }
}