package avex.importer;

import java.util.Date;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class AVEXDB {

	
	@SuppressWarnings("deprecation")
	public void ImportAthleteIntoAVEX(BasicDBList athletes)
	{
		try
		{
		
        // To connect to mongodb server
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
                
        // Now connect to your databases
		DB db = mongoClient.getDB("avexchange");
        System.out.println("Connect to database successfully");
			
        //boolean auth = db.authenticate(myUserName, myPassword);
        //System.out.println("Authentication: "+auth);         
			
        DBCollection athleteCollect = db.getCollection("athletes");
        System.out.println("Collection Athletes selected successfully");
		int counter = 0;
        
        for (int i=0; i < athletes.size(); i++) {
           BasicDBObject athlete = new BasicDBObject();
           BasicDBObject tempathlete = (BasicDBObject) athletes.get(i);
           athlete.append("athleteid", tempathlete.get("id"));
           athlete.append("position", tempathlete.get("position"));
           athlete.append("teamid", tempathlete.get("team_id"));
           athlete.append("name", tempathlete.get("player_name"));
           athlete.append("firstname", tempathlete.get("first_name"));
           athlete.append("lastname", tempathlete.get("last_name"));
           athlete.append("birthdate", tempathlete.get("birth_date"));
           athlete.append("draftkingid", tempathlete.get("dk_id"));
           athlete.append("draftkingposition", tempathlete.get("dk_position"));
           athlete.append("totalshares", 1000);
           athlete.append("orderseq", 0);
           athlete.append("currentprice", 0.00);
           athlete.append("isavailable", false);
           athlete.append("isresellable", false);
           athlete.append("imageurl","");
           athlete.append("recordstatusdate", new Date());
           athlete.append("recordstatus", 1);
      	   BasicDBObject query = new BasicDBObject();
     	   query.append("athleteid", athlete.get("athleteid"));
     	   athleteCollect.update(query, athlete, true, false); 
     	   counter++;
     	}        
        
        System.out.println("Inserted Athletes Successfully: " + counter);
        mongoClient.close();	
		}
		catch(Exception ex)
		{
			System.out.println("Exception: " + ex.toString());
		}
	}
	
	@SuppressWarnings("deprecation")
	public void ImportTeamIntoAVEX(BasicDBList teams)
	{
		try
		{
		
        // To connect to mongodb server
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
                
        // Now connect to your databases
		DB db = mongoClient.getDB("avexchange");
        System.out.println("Connect to database successfully");
			
        //boolean auth = db.authenticate(myUserName, myPassword);
        //System.out.println("Authentication: "+auth);         
			
        DBCollection athleteCollect = db.getCollection("teams");
        System.out.println("Collection Teams selected successfully");
		int counter = 0;
        
        for (int i=0; i < teams.size(); i++) {
           BasicDBObject team = new BasicDBObject();
           BasicDBObject tempteam = (BasicDBObject) teams.get(i);
           team.append("teamid", tempteam.get("id"));
           team.append("name",tempteam.get("team_name"));
           team.append("abbreviation", tempteam.get("abbreviation"));
           team.append("city", tempteam.get("city"));
           team.append("recordstatusdate", new Date());
           team.append("recordstatus", 1);
           team.append("imageurl","");
      	   BasicDBObject query = new BasicDBObject();
     	   query.append("teamid", team.get("teamid"));
     	   athleteCollect.update(query, team, true, false); 
     	   counter++;
     	}        
        
        System.out.println("Inserted Teams Successfully: " + counter);
        mongoClient.close();	
		}
		catch(Exception ex)
		{
			System.out.println("Exception: " + ex.toString());
		}
	}	
	
}
