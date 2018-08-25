package dominio;

public interface ICategoria {
	
	//non si pu� private
	   private int numeroMaxGiorniPrestito;
	   private int numeroMaxGiorniProroga;
	   private int numeroGiorniRichiestaProroga;
	   private int numeroMaxRisorseInPrestito;
	   
	   private ArrayList <Risorsa> elencoRisorse;

	    public String toString();
	    public void aggiungiRisorsa(Risorsa r);
	    public void rimuoviRisorsa(Risorsa r);


}
