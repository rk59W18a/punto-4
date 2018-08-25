package dominio;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Questa classe rappresenta il modello di un Libro
 */
public class Libro extends Risorsa implements Serializable
{
	private static final long serialVersionUID = 1L;
	
    private Persona autore_i; 
    private int numPagine;
    private String casaEditrice;
    
   public static final String DESCRIZIONE_LIBRO = "Titolo: %s\n\t\tAutore/i: %s\n\t\tNumero pagine: %d\n\t\tAnno di pubblicazione: %d\n\t\tCasa editrice: %s\n\t\tLingua: %s\n\t\tGenere: %s\n\t\tNumero licenze: %d\n";
    
    /**
    * Metodo costruttore della classe Libro
    * 
    * @pre: a != null
    * @post: autore_i != null
    * 
    * @param titolo: titolo del libro
    * @param licenze: numero delle licenze del libro
    * @param a: autore/i del libro
    * @param np: numero delle pagine del libro
    * @param annoPub: anno di pubblicazione del libro
    * @param ce: casa editrice del libro
    * @param lingua: lingua in cui e' scritto il libro
    * @param genere: genere del libro
    */
    public Libro(String titolo, int licenze, String genere, int annoPub, String lingua, Persona a, int np, String ce)
    {
    	   super(titolo, licenze, genere, annoPub, lingua);
    	   this.autore_i = a;
    	   this.numPagine = np;
    	   this.casaEditrice = ce;
    }
    
    /**
    * Metodi get per il ritorno dei vari attributi della classe Libro
    * @return i vari attributi della classe Libro
    */
    public String getAutore()
    {
        	return autore_i.getSoggetti();
    }
        
    public String getCasaEditrice()
    {
    	    return casaEditrice;
    }
    
    /**
     * Metodo toString() per la creazione di una stringa descrittiva contenente i vari attributi dell'oggetto Libro
     * 
     * @pre: autore_i != null
     * 
     * @return la stringa descrittiva del libro
     */
    public String toString()
    {
       StringBuffer ris = new StringBuffer();
       String aut = getAutore();
       
       ris.append(String.format(DESCRIZIONE_LIBRO, getTitolo(), aut, numPagine, getAnnoPub(), casaEditrice, getLingua(), getGenere(), getNumLicenze()));
       return ris.toString();
    }
    
}