package mongoDb.mongoConn.service;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Properties;


public class MongoConnService implements DataService {
    private MongoCollection<Document> collection;

    public MongoConnService(Properties properties) {
        final String mongoUriProp = properties.getProperty("server.db.mongo.uri");
        final String mongoDb = properties.getProperty("server.db.name");
        final String mongoDbCollection = properties.getProperty("server.db.collection");


        MongoClient mongoClient = new MongoClient(new MongoClientURI(mongoUriProp));
        MongoDatabase db = mongoClient.getDatabase(mongoDb);
        collection = db.getCollection(mongoDbCollection);

    }

    @Override
    public void insertDocument(String json) {
        final Document document = Document.parse(json);
        collection.insertOne(document);
    }
}
