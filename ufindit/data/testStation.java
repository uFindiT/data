package ufindit.data;

import java.sql.SQLException;
import java.util.ArrayList;

public class testStation {
	public static void main(String[] args) throws SQLException{
		CreateStation cs = new CreateStation();
		cs.createNachfolger();//Initialisiseren der Nachfolger
		ArrayList<Station> al = cs.getStationenListe();
		Algorithm ag = new Algorithm(cs.getStation("Floridsdorf"), cs.getStation("Landstrasse"));
		ag.berechneWeg(cs.getStation("Floridsdorf"));
		ag.createWeg();
	}
}
