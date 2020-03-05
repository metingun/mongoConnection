package mongoDb.mongoConn.controller;


import mongoDb.mongoConn.service.MongoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
@RequestMapping(value = "/restful", produces = "application/json", method = RequestMethod.POST)

public class MongoConnController {
    @Autowired
    MongoService mongoService;

    private static final Logger LOGGER = LoggerFactory.getLogger( MongoConnController.class );

    @RequestMapping(value = "/mongoConn", method = RequestMethod.POST, produces = "application/json")

    public String mongoConn() {
        try {
            mongoService.addDocument();
            return "Tamamlandı.";
        } catch (Exception e) {
            LOGGER.error( e.getMessage(), e );
            return null;
        }
    }
}

