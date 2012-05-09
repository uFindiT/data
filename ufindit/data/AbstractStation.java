package ufindit.data;

public interface AbstractStation {
	//-name: String
	/**
	 * -String name
	 * - list<Station, Integer> nachf(ALLE nachfolgerstationen werden gespeichert)
	 * - Station vorg (Der Vorg�nger von dem gekommen wird 
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
	public boolean isUmstieg();//Pr�ft ob vom Vorg�nger zu dieser Station sich die line(String) ge�ndert hat. Wenn ja wird Umstieg auf true gesetzt!
	public String getLinie();//returnt linie;
	/**
	 * Im Konstruktor werden die ganzen Attribute aus der Datenbank gelesen. 
	 * Vorg. wird am Anfang null gelassen. locked ist false umstieg ist false ges. ist 10000!
	 */
}
