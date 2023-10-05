package utils;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import ec.espe.edu.contacts.model.Contact;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Christian Novoa
 */
public class DBManager {
    private Properties prop = new Properties();

    public MongoClient connect() {
        //TODO connect to db
        MongoClient mongo = null;
        try {
            String username = prop.getProperty("MONGO_USERNAME");
            String password = prop.getProperty("MONGO_PASSWORD");
            String database = prop.getProperty("MONGO_DATABASE");

            String connectionString = String.format("mongodb://%s:%s@clusteraws-shard-00-00.6k7qv.mongodb.net:27017,clusteraws-shard-00-01.6k7qv.mongodb.net:27017,clusteraws-shard-00-02.6k7qv.mongodb.net:27017/%s?ssl=true&replicaSet=atlas-cgm0yh-shard-0&authSource=admin&retryWrites=true&w=majority", username, password, database);

            MongoClientURI mongoUri = new MongoClientURI(connectionString);
            mongo = new MongoClient(mongoUri);
        } catch (Exception e) {
            mongo = null;
        }
        return mongo;
    }

    public DBManager() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Lo siento, no se puede encontrar el archivo de configuración.");
                return;
            }
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
