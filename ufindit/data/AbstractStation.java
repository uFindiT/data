package ufindit.data;

public interface AbstractStation {
	//-name: String
	/**
	 * -String name
	 * - list<Station, Integer> nachf(ALLE nachfolgerstationen werden gespeichert)
	 * - Station vorg (Der Vorgänger von dem gekommen wird 
	 * - Int Duration
	 * - boolean locked
	 * - boolean umstieg
	 * - Strign linie
	 * @param a
	 */
	public void changePrevious(AbstractStation a);
	public void setDuration(int t); 
	public int getDuration();
	public void lock(); //Setzt Attribut lock auf true!
	public boolean isLocked();
	public void isUmstieg();//Prüft ob vom Vorgänger zu dieser Station sich die line(String) geändert hat. Wenn ja wird Umstieg auf true gesetzt!
	public String getLinie();//returnt linie;
	/**
	 * Im Konstruktor werden die ganzen Attribute aus der Datenbank gelesen. 
	 * Vorg. wird am Anfang null gelassen. locked ist false umstieg ist false ges. ist 10000!
	 */
}
