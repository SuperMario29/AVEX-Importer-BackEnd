package avex.importer;

import avex.athletedata.AthleteDataApi;
import com.mongodb.BasicDBList;


public class ImportApplication {
		
	public void ImportAthleteData()
	{
		AVEXDB avexDB = new AVEXDB();
		AthleteDataApi athleteApi = new AthleteDataApi();
		BasicDBList teamList = athleteApi.GetNBATeams();
		avexDB.ImportTeamIntoAVEX(teamList);
		BasicDBList athleteList = athleteApi.GetAllNBAAthletes();
		avexDB.ImportAthleteIntoAVEX(athleteList);
	}
}

