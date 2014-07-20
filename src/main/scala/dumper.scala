
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

    def getDumpObject(dataType:String, data:String, tags:String) : MongoDBObject = {
        val newdump = MongoDBObject()
        val newdata = Map (
            "type" -> dataType,
            "data" -> data,
            "tags" -> tags
            )
        newdump += "dump" -> newdata

    } // pushMap


    def main(args: Array[String]) = {
        parser.parse(args, Config()) map { config =>

          val (_database, _collection, _mclient) = initMongoFromConf()

          val db = _mclient(_database)
          var collection = db(_collection)

          var newdump = getDumpObject(config.dataType, config.data, config.tags)
          collection.save(newdump)

          println("data dumped")

        } getOrElse {
          // arguments are bad, error message will have been displayed
        }

    }

    var dataType:String = null;
    val parser = new scopt.OptionParser[Config]("dumper") {
      head("dumper", "1.x")
      opt[String]('t', "type") action { (x, c) =>
        c.copy(dataType = x) } text("type of data. text|url|imageurl")
      opt[String]('T', "tags") action { (x, c) =>
        c.copy(tags = x) } text("list of related tags separated by space in double quotes")
      help("help") text("prints this usage text")
      arg[String]("data") required() action { (x, c) =>
        c.copy(data = x) } text("data to be dumped")
    }

}
