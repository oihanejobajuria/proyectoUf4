package com.example;

import org.bson.types.ObjectId;

import java.util.StringJoiner;
import java.util.stream.Stream;

public class Games {
    String title;
    String year;
    String description;
    Integer id;
    ObjectId _id;

    public Games(String title, String year, String description, Integer id) {
        this.title = title;
        this.year = year;
        this.description = description;
        this.id = id;
    }

    public Games(String title, String year, String description, ObjectId _id) {
        this.title = title;
        this.year = year;
        this.description = description;
        this._id = _id;
    }

    public Games(String title, String year, String description) {
        this.title = title;
        this.year = year;
        this.description = description;
    }

    public Games() {
    }


    static Stream<String> toMaster(Games p) {
        return Stream.of(new StringJoiner(", ")
                .add("Id=\33[34m" + p.id + "\33[0m")
                .add("Name='\33[34m" + p.title + "\33[0m'")
                .add("Year='\33[34m" + p.year + "\33[0m'")
                .add("Description='\33[34m" + p.description + "\33[0m'")

                .toString());
    }
    static Stream<String> toMasterMongo(Games p) {
        return Stream.of(new StringJoiner(", ")
                .add("Id=\33[34m" + p._id + "\33[0m")
                .add("Title='\33[34m" + p.title + "\33[0m'")
                .add("Year='\33[34m" + p.year + "\33[0m'")
                .add("Description='\33[34m" + p.description + "\33[0m'")
                .toString());
    }

}
