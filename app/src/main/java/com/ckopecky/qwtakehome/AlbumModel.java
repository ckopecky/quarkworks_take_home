package com.ckopecky.qwtakehome;

import java.io.Serializable;

//This is our AlbumModel class
public class AlbumModel implements Serializable {
    //instantiate our needed vars
    private String artistName, id, releaseDate, name, copyright, artistUrl, artworkUrl100, url, ranking;

    //this is our constructor
    public AlbumModel() {
        this.artistName = artistName;
        this.releaseDate = releaseDate;
        this.name = name;
        this.copyright = copyright;
        this.artistUrl = artistUrl;
        this.artworkUrl100 = artworkUrl100;
        this.id = id;
        this.ranking = ranking;
    }
    String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    String getArtistUrl() {
        return artistUrl;
    }

    public void setArtistUrl(String artistUrl) {
        this.artistUrl = artistUrl;
    }

    String getArtworkUrl100() {
        return artworkUrl100;
    }

    public void setArtworkUrl100(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }

    String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    String getRanking() {
        return ranking;
    }

    void setRanking(String ranking) {
        this.ranking = ranking;
    }

    @Override
    public String toString() {
        return "Album [ranking=" + ranking + ", artistName=" + artistName + ", id=" + id + ", releaseDate=" + releaseDate + ", name=" + name + ", copyright=" + copyright + ", artistUrl=" + artistUrl + ", artworkUrl100="  + artworkUrl100 + ", url=" + url;
    }
}
