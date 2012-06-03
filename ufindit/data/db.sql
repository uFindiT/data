DROP DATABASE IF EXISTS uFindiT;
CREATE DATABASE uFindiT;
USE uFindiT;

CREATE TABLE station(
	name VARCHAR(255),
	linie CHAR(2),
	PRIMARY KEY(name,linie)
	)ENGINE=INNODB;
	
CREATE TABLE strecke(
	aname VARCHAR(255),
	ename VARCHAR(255),
	dauer INT,
	PRIMARY KEY (aname,ename),
	FOREIGN KEY (aname) 
		REFERENCES station (name)
			ON UPDATE CASCADE
			ON DELETE CASCADE,
	FOREIGN KEY (aname)
		REFERENCES station (name)
			ON UPDATE CASCADE
			ON DELETE CASCADE
			)ENGINE=INNODB;
			
INSERT INTO station VALUES ('Reumannplatz','U1');
INSERT INTO station VALUES ('Keplerplatz', 'U1');
INSERT INTO station VALUES ('Südtiroler Platz', 'U1');
INSERT INTO station VALUES ('Taubstummengasse', 'U1');
INSERT INTO station VALUES ('Karlsplatz', 'U1');
INSERT INTO station VALUES ('Stephansplatz', 'U1');
INSERT INTO station VALUES ('Schwedenplatz', 'U1');
INSERT INTO station VALUES ('Nestroyplatz', 'U1');
INSERT INTO station VALUES ('Praterstern', 'U1');
INSERT INTO station VALUES ('Vorgartenstraße', 'U1');
INSERT INTO station VALUES ('Donauinsel', 'U1');
INSERT INTO station VALUES ('Kaisermühlen-VIC', 'U1');
INSERT INTO station VALUES ('Alte Donau', 'U1');
INSERT INTO station VALUES ('Kagran', 'U1');
INSERT INTO station VALUES ('Kagraner Platz', 'U1');
INSERT INTO station VALUES ('Rennbahnweg', 'U1');
INSERT INTO station VALUES ('Aderklaaer Straße', 'U1');
INSERT INTO station VALUES ('Großfeldsiedlung', 'U1');
INSERT INTO station VALUES ('Leopoldau', 'U1');

INSERT INTO station VALUES ('Karlsplatz', 'U2');
INSERT INTO station VALUES ('Museumsquartier', 'U2');
INSERT INTO station VALUES ('Volkstheater', 'U2');
INSERT INTO station VALUES ('Rathaus', 'U2');
INSERT INTO station VALUES ('Schottentor', 'U2');
INSERT INTO station VALUES ('Schottenring', 'U2');
INSERT INTO station VALUES ('Taborstraße', 'U2');
INSERT INTO station VALUES ('Praterstern', 'U2');
INSERT INTO station VALUES ('Messe-Prater', 'U2');
INSERT INTO station VALUES ('Krieau', 'U2');
INSERT INTO station VALUES ('Stadion', 'U2');
INSERT INTO station VALUES ('Donaumarina', 'U2');
INSERT INTO station VALUES ('Donaustadtbrücke', 'U2');
INSERT INTO station VALUES ('Stadlau', 'U2');
INSERT INTO station VALUES ('Hardeggasse', 'U2');
INSERT INTO station VALUES ('Donauspital', 'U2');
INSERT INTO station VALUES ('Aspernstraße' 'U2');

INSERT INTO station VALUES ('Simmering', 'U3');
INSERT INTO station VALUES ('Enkplatz U/Grillgasse', 'U3');
INSERT INTO station VALUES ('Zippererstraße', 'U3');
INSERT INTO station VALUES ('Gasometer', 'U3');
INSERT INTO station VALUES ('Erdberg', 'U3');
INSERT INTO station VALUES ('Schlachthausgasse', 'U3');
INSERT INTO station VALUES ('Kardinal-Nagl-Platz', 'U3');
INSERT INTO station VALUES ('Rochusgasse', 'U3');
INSERT INTO station VALUES ('Landstraße', 'U3');
INSERT INTO station VALUES ('Stubentor', 'U3');
INSERT INTO station VALUES ('Stephansplatz', 'U3');
INSERT INTO station VALUES ('Herrengasse', 'U3');
INSERT INTO station VALUES ('Volkstheater', 'U3');
INSERT INTO station VALUES ('Neubaugasse', 'U3');
INSERT INTO station VALUES ('Zieglergasse', 'U3');
INSERT INTO station VALUES ('Westbahnhof', 'U3');
INSERT INTO station VALUES ('Schweglerstraße', 'U3');
INSERT INTO station VALUES ('Johnstraße', 'U3');
INSERT INTO station VALUES ('Hütteldorfer Straße', 'U3');
INSERT INTO station VALUES ('Kendlerstraße', 'U3');
INSERT INTO station VALUES ('Ottakring', 'U3');


INSERT INTO station VALUES ('Hütteldorf', 'U4');
INSERT INTO station VALUES ('Ober St Veit', 'U4');
INSERT INTO station VALUES ('Unter St Veit', 'U4');
INSERT INTO station VALUES ('Braunschweiggasse', 'U4');
INSERT INTO station VALUES ('Hietzing, Kennedybrücke', 'U4');
INSERT INTO station VALUES ('Schönbrunn', 'U4');
INSERT INTO station VALUES ('Meidling Hauptstraße', 'U4');
INSERT INTO station VALUES ('Längenfeldgasse', 'U4');
INSERT INTO station VALUES ('Margaretengürtel', 'U4');
INSERT INTO station VALUES ('Pilgramgasse', 'U4');
INSERT INTO station VALUES ('Kettenbrückengasse', 'U4');
INSERT INTO station VALUES ('Karlsplatz', 'U4');
INSERT INTO station VALUES ('Stadtpark', 'U4');
INSERT INTO station VALUES ('Landstraße', 'U4');
INSERT INTO station VALUES ('Schwedenplatz', 'U4');
INSERT INTO station VALUES ('Schottenring', 'U4');
INSERT INTO station VALUES ('Roßauer Lände', 'U4');
INSERT INTO station VALUES ('Friedensbrücke', 'U4');
INSERT INTO station VALUES ('Spittelau', 'U4');
INSERT INTO station VALUES ('Heiligenstadt', 'U4');

INSERT INTO station VALUES ('Floridsdorf', 'U6');
INSERT INTO station VALUES ('Neue Donau', 'U6');
INSERT INTO station VALUES ('Handelskai', 'U6');
INSERT INTO station VALUES ('Dresdner Straße', 'U6');
INSERT INTO station VALUES ('Jägerstraße', 'U6');
INSERT INTO station VALUES ('Spittelau', 'U6');
INSERT INTO station VALUES ('Nußdorfer Straße', 'U6');
INSERT INTO station VALUES ('Währinger Straße-Volksoper', 'U6');
INSERT INTO station VALUES ('Michelbeuern-AKH', 'U6');
INSERT INTO station VALUES ('Alser Straße', 'U6');
INSERT INTO station VALUES ('Josefstädter Straße', 'U6');
INSERT INTO station VALUES ('Thaliastraße', 'U6');
INSERT INTO station VALUES ('Burggasse-Stadthalle', 'U6');
INSERT INTO station VALUES ('Westbahnhof', 'U6');
INSERT INTO station VALUES ('Burggasse-Stadhalle', 'U6');
INSERT INTO station VALUES ('Westbahnhof', 'U6');
INSERT INTO station VALUES ('Gumpendorfer Straße', 'U6');
INSERT INTO station VALUES ('Längenfeldgasse', 'U6');
INSERT INTO station VALUES ('Niederhofstraße', 'U6');
INSERT INTO station VALUES ('Philadelphiabrücke', 'U6');
INSERT INTO station VALUES ('Tscherttegasse', 'U6');
INSERT INTO station VALUES ('Am Schöpfwerk', 'U6');
INSERT INTO station VALUES ('Alterlaa', 'U6');
INSERT INTO station VALUES ('Erlaaer Straße', 'U6');
INSERT INTO station VALUES ('Perfektastraße', 'U6');
INSERT INTO station VALUES ('Siebenhirten', 'U6');










INSERT INTO strecke VALUES ('Reumannplatz', 'Keplerplatz', 2);
INSERT INTO strecke VALUES ('Keplerplatz', 'Südtiroler Platz',2 );
INSERT INTO strecke VALUES ('Südtiroler Platz', 'Taubstummengasse',1);
INSERT INTO strecke VALUES ('Taubstummengasse', 'Karlsplatz',2 );
INSERT INTO strecke VALUES ('Karlsplatz', 'Stehansplatz',2 );
INSERT INTO strecke VALUES ('Stehansplatz', 'Schwedenplatz',1 );
INSERT INTO strecke VALUES ('Schwedenplatz', 'Nestroyplatz',1 );
INSERT INTO strecke VALUES ('Nestroyplatz', 'Praterstern', 1);
INSERT INTO strecke VALUES ('Praterstern', 'Vorgartenstraße',1 );
INSERT INTO strecke VALUES ('Vorgartenstraße', 'Donauinsel',2 );
INSERT INTO strecke VALUES ('Donauinsel', 'Kaisermühlen-VIC',1 );
INSERT INTO strecke VALUES ('Kaisermühlen-VIC', 'Alte Donau',2 );
INSERT INTO strecke VALUES ('Alte Donau', 'Kagran', 1);
INSERT INTO strecke VALUES ('Kagran', 'Kagraner Platz',2 );
INSERT INTO strecke VALUES ('Kagraner Platz', 'Rennbahnweg',2 );
INSERT INTO strecke VALUES ('Rennbahnweg', 'Aderklaaer Straße',1 );
INSERT INTO strecke VALUES ('Aderklaaer Straße', 'Großfeldsiedlung',1 );
INSERT INTO strecke VALUES ('Großfeldsiedlung', 'Leopoldau', 2);


INSERT INTO strecke VALUES ('Karlsplatz', 'Museumsquartier',2 );
INSERT INTO strecke VALUES ('Museumsquartier', 'Volkstheater',1 );
INSERT INTO strecke VALUES ('Volkstheater', 'Rathaus', 2);
INSERT INTO strecke VALUES ('Rathaus', 'Schottentor',2 );
INSERT INTO strecke VALUES ('Schottentor', 'Schottenring',1 );
INSERT INTO strecke VALUES ('Schottenring', 'Taborstraße', 1);
INSERT INTO strecke VALUES ('Taborstraße', 'Praterstern', 2);
INSERT INTO strecke VALUES ('Praterstern', 'Messe-Prater',2 );
INSERT INTO strecke VALUES ('Messe-Prater', 'Krieau',1 );
INSERT INTO strecke VALUES ('Krieau', 'Stadion',1 );
INSERT INTO strecke VALUES ('Stadion', 'Donaumarina', );
INSERT INTO strecke VALUES ('Donaumarina', 'Donaustadtbrücke',1 );
INSERT INTO strecke VALUES ('Donaustadtbrücke', 'Stadlau',2 );
INSERT INTO strecke VALUES ('Stadlau', 'Hardeggasse',1 );
INSERT INTO strecke VALUES ('Hardeggasse', 'Donauspital',2 );
INSERT INTO strecke VALUES ('Donauspital', 'Aspernstraße',1 );

INSERT INTO strecke VALUES ('Simmering', 'Enkplatz U/Grillgasse',1 );
INSERT INTO strecke VALUES ('Enkplatz U/Grillgasse', 'Zippererstraße',1 );
INSERT INTO strecke VALUES ('Zippererstraße', 'Gasometer', 1);
INSERT INTO strecke VALUES ('Gasometer', 'Erdberg',2 );
INSERT INTO strecke VALUES ('Erdberg', 'Schlachthausgasse',1 );
INSERT INTO strecke VALUES ('Schlachthausgasse', 'Kardinal-Nagl-Platz',1 );
INSERT INTO strecke VALUES ('Kardinal-Nagl-Platz', 'Rochusgasse',1 );
INSERT INTO strecke VALUES ('Rochusgasse', 'Landstraße',2 );
INSERT INTO strecke VALUES ('Landstraße', 'Stubentor',1 );
INSERT INTO strecke VALUES ('Stubentor', 'Stephansplatz',1 );
INSERT INTO strecke VALUES ('Stephansplatz', 'Herrengasse',2 );
INSERT INTO strecke VALUES ('Herrengasse', 'Volkstheater',1 );
INSERT INTO strecke VALUES ('Volkstheater', 'Neubaugasse',2 );
INSERT INTO strecke VALUES ('Neubaugasse', 'Zieglergasse',1 );
INSERT INTO strecke VALUES ('Zieglergasse', 'Westbahnhof',1 );
INSERT INTO strecke VALUES ('Westbahnhof', 'Schweglerstraße',1 );
INSERT INTO strecke VALUES ('Schweglerstraße', 'Johnstraße',2 );
INSERT INTO strecke VALUES ('Johnstraße', 'Hütteldorfer Straße',1 );
INSERT INTO strecke VALUES ('Hütteldorfer Straße', 'Kendlerstraße',1 );
INSERT INTO strecke VALUES ('Kendlerstraße', 'Ottakring',1);


INSERT INTO strecke VALUES ('Hütteldorf', 'Ober St Veit', 2);
INSERT INTO strecke VALUES ('Ober St Veit', 'Unter St Veit',1 );
INSERT INTO strecke VALUES ('Unter St Veit', 'Braunschweiggasse',2 );
INSERT INTO strecke VALUES ('Braunschweiggasse', 'Hietzing, Kennedybrücke',1 );
INSERT INTO strecke VALUES ('Hietzing, Kennedybrücke', 'Schönbrunn',2 );
INSERT INTO strecke VALUES ('Schönbrunn', 'Meidling Hauptstraße',1 );
INSERT INTO strecke VALUES ('Meidling Hauptstraße', 'Längenfeldgasse',1 );
INSERT INTO strecke VALUES ('Längenfeldgasse', 'Margaretengürtel',2 );
INSERT INTO strecke VALUES ('Margaretengürtel', 'Pilgramgasse',2 );
INSERT INTO strecke VALUES ('Pilgramgasse', 'Kettenbrückengasse',1 );
INSERT INTO strecke VALUES ('Kettenbrückengasse', 'Karlsplatz',2 );
INSERT INTO strecke VALUES ('Karlsplatz', 'Stadtpark',2 );
INSERT INTO strecke VALUES ('Stadtpark', 'Landstraße', 2);
INSERT INTO strecke VALUES ('Landstraße', 'Schwedenplatz',2 );
INSERT INTO strecke VALUES ('Schwedenplatz', 'Schottenring', 1);
INSERT INTO strecke VALUES ('Schottenring', 'Roßauer Lände',2 );
INSERT INTO strecke VALUES ('Roßauer Lände', 'Friedensbrücke',1 );
INSERT INTO strecke VALUES ('Friedensbrücke', 'Spittelau',1 );
INSERT INTO strecke VALUES ('Spittelau', 'Heiligenstadt',2 );



INSERT INTO strecke VALUES ('Floridsdorf', 'Neue Donau', 2);
INSERT INTO strecke VALUES ('Neue Donau', 'Handelskai', 1);
INSERT INTO strecke VALUES ('Handelskai', 'Dresdner Straße', 1);
INSERT INTO strecke VALUES ('Dresdner Straße', 'Jägerstraße',1 );
INSERT INTO strecke VALUES ('Jägerstraße', 'Spittelau',1 );
INSERT INTO strecke VALUES ('Spittelau', 'Nußdorfer Straße',2 );
INSERT INTO strecke VALUES ('Nußdorfer Straße', 'Währinger Straße-Volksoper',1 );
INSERT INTO strecke VALUES ('Währinger Straße-Volksoper', 'Michelbeuern-AKH',2 );
INSERT INTO strecke VALUES ('Michelbeuern-AKH', 'Alser Straße', 1);
INSERT INTO strecke VALUES ('Alser Straße', 'Josefstädter Straße',2 );
INSERT INTO strecke VALUES ('Josefstädter Straße', 'Thaliastraße',2 );
INSERT INTO strecke VALUES ('Thaliastraße', 'Burggasse-Stadthalle', 1);
INSERT INTO strecke VALUES ('Burggasse-Stadthalle', 'Westbahnhof', 2);
INSERT INTO strecke VALUES ('Westbahnhof', 'Gumpendorfer Straße', 1);
INSERT INTO strecke VALUES ('Gumpendorfer Straße', 'Längenfeldgasse',1 );
INSERT INTO strecke VALUES ('Längenfeldgasse', 'Niederhofstraße',1 );
INSERT INTO strecke VALUES ('Niederhofstraße', 'Philadelphiabrücke', 2);
INSERT INTO strecke VALUES ('Philadelphiabrücke', 'Tscherttegasse',2 );
INSERT INTO strecke VALUES ('Tscherttegasse', 'Am Schöpfwerk', 1);
INSERT INTO strecke VALUES ('Am Schöpfwerk', 'Alterlaa', 2);
INSERT INTO strecke VALUES ('Alterlaa', 'Erlaaer Straße',2 );
INSERT INTO strecke VALUES ('Erlaaer Straße', 'Perfektastraße', 1);
INSERT INTO strecke VALUES ('Perfektastraße', 'Siebenhirten',1 );
