package ufindit.data;

import java.sql.SQLException;
import java.util.ArrayList;

public class testStation {
	public static void main(String[] args) throws SQLException{
		CreateStation cs = new CreateStation();
		cs.createNachfolger();//Initialisiseren der Nachfolger
	    ArrayList<Station> al = cs.getStationen();
		Algorithm ag = new Algorithm(cs.getStation("Kagran"), cs.getStation("Jaegerstrasse"), al);
		ag.berechneWeg(cs.getStation("Kagran"));
		ag.createWeg(cs);
	}
}
