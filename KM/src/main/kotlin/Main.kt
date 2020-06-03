import com.mongodb.MongoClient
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import java.util.Arrays;
import com.mongodb.Block;

import com.mongodb.client.MongoCursor;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;


fun main(){
    println("hi")

    var mongoClient = MongoClient()

    var database = mongoClient.getDatabase("DataBase")

    var collection = database.getCollection("db-1")

    var documents = ArrayList<Document>()
    for (i in 1..100){
        documents.add(Document("i",i))
    }
    collection.insertMany(documents)
    for(i in collection.find()){
        println(i.toJson())
        println("-----------------------------------")
    }

}