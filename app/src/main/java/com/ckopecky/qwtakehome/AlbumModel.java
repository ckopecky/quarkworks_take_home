package com.ckopecky.qwtakehome;

public class AlbumModel {

    private String artistName, id, releaseDate, name, copyright, artistUrl, artworkUrl100, url;

    public AlbumModel(String artistName, String releaseDate, String name, String copyright, String artistUrl, String artworkUrl100, String id) {
        this.artistName = artistName;
        this.releaseDate = releaseDate;
        this.name = name;
        this.copyright = copyright;
        this.artistUrl = artistUrl;
        this.artworkUrl100 = artworkUrl100;
        this.id = id;
    }
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

    @Override
    public String toString() {
        return "Album [artistName=" + artistName + ", id=" + id + ", releaseDate=" + releaseDate + ", name=" + name + ", copyright=" + copyright + ", artistUrl=" + artistUrl + ", artworkUrl100="  + artworkUrl100 + ", url=" + url;
    }
}
