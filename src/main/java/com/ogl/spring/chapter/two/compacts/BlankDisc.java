package com.ogl.spring.chapter.two.compacts;

import com.ogl.spring.chapter.two.soundsystem.CompactDisc;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by ogl on 24/05/16.
 */
@Component
public class BlankDisc implements CompactDisc {

    private String tittle;
    private String artist;
    private List<String> tracks;

    public BlankDisc() {
        super();
    }

    public BlankDisc(String tittle, String artist) {
        this.tittle = tittle;
        this.artist = artist;
    }

    public BlankDisc(String tittle, String artist, List<String> tracks) {
        this.tittle = tittle;
        this.artist = artist;
        this.tracks = tracks;
    }

    @Override
    public void play() {
        System.out.println("Playing " + tittle + " by (BlankDisk) " + artist);
        for (final String track : getTracks()) {
            System.out.println("-Track: " + track);
        }
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<String> getTracks() {
        if (tracks == null) {
            tracks =  new ArrayList<>(0);
        }
        return tracks;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }
}
