package com.example;


import org.bson.types.ObjectId;

import java.util.StringJoiner;
import java.util.stream.Stream;

public class Musicas {

    String title;
    String artist;
    String disk;
    String year;
    Integer id;
    ObjectId _id;

    public Musicas(String title, String artist, String disk, String year) {
        this.title = title;
        this.artist = artist;
        this.disk = disk;
        this.year = year;
    }

    public Musicas(String title, String artist, String disk, String year, ObjectId _id) {
        this.title = title;
        this.artist = artist;
        this.disk = disk;
        this.year = year;
        this._id = _id;
    }

    public Musicas(String title, String artist, String disk, String year, Integer id) {
        this.title = title;
        this.artist = artist;
        this.disk = disk;
        this.year = year;
        this.id = id;
    }

    public Musicas() {
    }


    static Stream<String> toMaster(Musicas p) {
        return Stream.of(new StringJoiner(", ")
                .add("Id=\33[34m" + p.id + "\33[0m")
                .add("Title='\33[34m" + p.title + "\33[0m'")
                .add("Artist='\33[34m" + p.artist + "\33[0m'")
                .add("Disk='\33[34m" + p.disk + "\33[0m'")
                .add("Year='\33[34m" + p.year + "\33[0m'")
                .toString());
    }
    static Stream<String> toMasterMongo(Musicas p) {
        return Stream.of(new StringJoiner(", ")
                .add("Id=\33[34m" + p._id + "\33[0m")
                .add("Title='\33[34m" + p.title + "\33[0m'")
                .add("Artist='\33[34m" + p.artist + "\33[0m'")
                .add("Disk='\33[34m" + p.disk + "\33[0m'")
                .add("Year='\33[34m" + p.year + "\33[0m'")
                .toString());
    }
}
