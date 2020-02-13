package com.ckopecky.qwtakehome;

//This is our AlbumModel class
public class AlbumModel {
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

    //our getters and setters for our album class
    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getReleaseDate() {
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

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getArtistUrl() {
        return artistUrl;
    }

    public void setArtistUrl(String artistUrl) {
        this.artistUrl = artistUrl;
    }

    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    public void setArtworkUrl100(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    //this is a string representation of our class -- it's essentially like "repr" method in Python.
    @Override
    public String toString() {
        return "Album [ranking=" + ranking + ", artistName=" + artistName + ", id=" + id + ", releaseDate=" + releaseDate + ", name=" + name + ", copyright=" + copyright + ", artistUrl=" + artistUrl + ", artworkUrl100="  + artworkUrl100 + ", url=" + url;
    }
}
