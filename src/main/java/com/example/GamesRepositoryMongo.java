package com.example;

import com.mongodb.client.MongoDatabase;

public class GamesRepositoryMongo extends RepositoryMongo<Games> implements GamesRepository {

    @Override
    public void populate() {

    }

    @Override
    public Integer getLastId() {
        MongoDatabase database = mongoClient.getDatabase("sampledb");
        database.getCollection("entrenadores").find().limit(1);
        return null;
    }


}
