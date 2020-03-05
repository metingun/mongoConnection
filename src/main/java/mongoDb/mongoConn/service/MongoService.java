package mongoDb.mongoConn.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Properties;

@Service
public class MongoService {

    private DataService dataServe;

    public MongoService() {

        Properties config = new Properties();
        try {
            config.load(this.getClass().getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        dataServe =new MongoConnService( config );
    }
    public void addDocument(){
        String json = "{" +
                "'id':1" +
                ",'leftCardName':'Metin'" +
                ",'leftCardJob':'Software Development'" +
                ",'leftCardAbility':'Futbol'" +
                ",'leftImage':'close.png'" +
                "}";
        dataServe.insertDocument( json );
    }

}
