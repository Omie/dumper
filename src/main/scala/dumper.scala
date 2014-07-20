
import com.typesafe.config.ConfigFactory
import com.mongodb.casbah.Imports._


object dumper {

    def initMongoFromConf() : (String, String, MongoClient) = {
        var conf = ConfigFactory.load

        lazy val _url = conf.getString("mongo.url")
        lazy val _port = conf.getInt("mongo.port")
        lazy val _password = conf.getString("mongo.password")
        lazy val _database = conf.getString("mongo.database")
        lazy val _collection = conf.getString("mongo.collection")
        lazy val _username = conf.getString("mongo.username")

        val uri = MongoClientURI("mongodb://%s:%s@%s:%d/%s" format (_username, _password, _url, _port, _database) )
        val mongoClient = MongoClient(uri)

        return (_database, _collection, mongoClient)
    }

    def getDumpObject(dataType:String, data:String, title:String, tags:String) : MongoDBObject = {
        val newdump = MongoDBObject()
        val newdata = Map (
            "type" -> dataType,
            "data" -> data,
            "title" -> title,
            "tags" -> tags
            )
        newdump += "dump" -> newdata

    } // pushMap


    def main(args: Array[String]) = {

        val (_database, _collection, _mclient) = initMongoFromConf()

        val db = _mclient(_database)
        var collection = db(_collection)

        var newdump = getDumpObject("text", "hello world2", "greeting", "greeting hello world")
        collection.save(newdump)

        println("data dumped")

    }

}
