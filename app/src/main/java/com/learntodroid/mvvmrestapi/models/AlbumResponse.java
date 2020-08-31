package com.learntodroid.mvvmrestapi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AlbumResponse {
    public Result results[];

    public class Result {


        @SerializedName("artistName")
        @Expose
        private String artistName;

        @SerializedName("collectionName")
        @Expose
        private String collectionName;

        @SerializedName("collectionPrice")
        @Expose
        private double collectionPrice;

        public String getArtistName() {
            return artistName;
        }

        public void setArtistName(String artistName) {
            this.artistName = artistName;
        }

        public String getCollectionName() {
            return collectionName;
        }

        public void setCollectionName(String collectionName) {
            this.collectionName = collectionName;
        }

        public double getCollectionPrice() {
            return collectionPrice;
        }

        public void setCollectionPrice(double collectionPrice) {
            this.collectionPrice = collectionPrice;
        }
    }
}