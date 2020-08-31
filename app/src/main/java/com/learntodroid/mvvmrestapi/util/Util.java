package com.learntodroid.mvvmrestapi.util;

import com.learntodroid.mvvmrestapi.models.AlbumResponse;

import java.util.List;

public class Util {
    public String StringJoin(List<String> stringList, String delimeter) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stringList.size(); i++) {
            sb.append(stringList.get(i));
            if (i != stringList.size() - 1) {
                sb.append(delimeter);
            }
        }

        return sb.toString();
    }

    public AlbumResponse.Result[] getFilterResult(AlbumResponse.Result[] data, String keyword) {
        AlbumResponse.Result[] temp = new AlbumResponse.Result[data.length];
        int j = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i].getArtistName().contains(keyword) || data[i].getCollectionName().contains(keyword)) {
                temp[j] = data[i];
                j++;
            }
        }
        return temp;
    }
}
