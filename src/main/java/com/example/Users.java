package com.example;

import org.bson.types.ObjectId;

import java.util.StringJoiner;
import java.util.stream.Stream;

public class Users {
    String playername;
    String username;
    String game1;
    String game2;
    String game3;

    public Users(String playername, String username, String game1, String game2, String game3) {
        this.playername = playername;
        this.username = username;
        this.game1 = game1;
        this.game2 = game2;
        this.game3 = game3;
    }

    public Users() {
    }


    static Stream<String> toMaster(Users p) {
        return Stream.of(new StringJoiner(", ")
                .add("PlayerName=\33[34m" + p.playername + "\33[0m")
                .add("Username='\33[34m" + p.username + "\33[0m'")
                .add("Game1='\33[34m" + p.game1 + "\33[0m'")
                .add("Game2='\33[34m" + p.game2 + "\33[0m'")
                .add("Game3='\33[34m" + p.game3 + "\33[0m'")


                .toString());
    }

}
