package com.example;

import com.mongodb.client.*;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class RepositoryMongo<T> implements Repository<T> {
    static MongoClient mongoClient;
    @Override
    public void init() {
        mongoClient = MongoClients.create("mongodb://localhost");
    }

    @Override
    public void insert(Object o)  {

        MongoDatabase database = mongoClient.getDatabase("sampledb");
        MongoCollection<Document> collection = database.getCollection(getTableName());
        Document doc = new Document();

        for (Field field : getFields()) {
            try {
                doc.append(field.getName(),o.getClass().getDeclaredField(field.getName()).get(o));
            } catch (IllegalAccessException | NoSuchFieldException e) {
                e.printStackTrace();
            }
        }

        collection.insertOne(doc);
    }

    @Override
    public List<T> getAll() {
        List<T> entrenadores = new ArrayList<>();
        MongoDatabase database = mongoClient.getDatabase("sampledb");
        database.getCollection(getTableName()).find().forEach(document ->{
                T t = getNewInstance();
            for (Field field : getFields()) {
                try {
                    if (t.getClass().getDeclaredField(field.getName()).getType() == int.class){
                        t.getClass().getDeclaredField(field.getName()).set(t, document.getInteger(field.getName()));
                    }else if (t.getClass().getDeclaredField(field.getName()).getType() == String.class){
                        t.getClass().getDeclaredField(field.getName()).set(t, document.getString(field.getName()));
                    }else if (t.getClass().getDeclaredField(field.getName()).getType() == ObjectId.class){
                        t.getClass().getDeclaredField(field.getName()).set(t, document.getObjectId(field.getName()));
                    }

                } catch (IllegalAccessException | NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }
                entrenadores.add(t);
        });

        return  entrenadores;
    }

    @Override
    public void update(Object o, String name) {
        MongoDatabase database = mongoClient.getDatabase("sampledb");
        try {

            Bson updates = null;
            for (int i = 0; i <getFields().length -1 ; i++) {
                if (getFields()[i].get(o) != null) {
                    updates = Updates.combine(
                            Updates.addToSet(getFields()[i].getName(), o.getClass().getDeclaredField(getFields()[i].getName()).get(o))
                    );
                }
            }
            database.getCollection(getTableName()).findOneAndUpdate(eq("title",name),updates);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String name) {
        MongoDatabase database = mongoClient.getDatabase("sampledb");
        database.getCollection(getTableName()).findOneAndDelete(eq("title",name));
    }

}
