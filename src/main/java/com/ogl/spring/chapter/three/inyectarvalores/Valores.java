package com.ogl.spring.chapter.three.inyectarvalores;

/**
 * Created by ogl on 22/08/16.
 */
public class Valores {
    private String title;
    private String artist;

    public Valores() {
    }

    public Valores(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
