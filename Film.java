package dominio;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Questa classe rappresenta il modello di un Film
 */
public class Film extends Risorsa implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String regista;
    private Persona attore_i;
    private int durataInMinuti;
    
    public static final String DESCRIZIONE_FILM = "Titolo: %s\n\t\tRegista: %s\n\t\tAttore/i: %s\n\t\tGenere: %s\n\t\tLingua: %s\n\t\tDurata (in minuti): %d\n\t\tAnno di uscita: %d\n\t\tNumero licenze: %d\n";
    
    /**
     * Metodo costruttore della classe Film
     * 
     * @pre: a != null
     * 
     * @param titolo: titolo del film
     * @param licenze: numero delle licenze del film
     * @param genere: genere del film
     * @param annoPub: anno di pubblicazione del film
     * @param lingua: lingua audio del film
     * @param r: regista del film
     * @param a: attore/i del film
     * @param dm: durata in minuti del film
     */
    public Film(String titolo, int licenze, String genere, int annoPub, String lingua, String r, Persona a, int dm)
    {
    	    super(titolo, licenze, genere, annoPub, lingua);
    	    this.regista = r;
    	    this.attore_i = a;
    	    this.durataInMinuti =dm;
    }
    
    /**
     * Metodi get per il ritorno dei vari attributi della classe Film
     * @return i vari attributi della classe Film
     */
    public String getRegista()
    {
    	    return regista;
    }
    
    public String getAttore()
    {
        	return attore_i.getSoggetti();
    }
    
    public int getDurata()
    {
    	    return durataInMinuti;
    }
        
    /**
     * Metodo toString() per la creazione di una stringa descrittiva contenente i vari attributi dell'oggetto Film
     * 
     * @pre: attore_i != null
     * 
     * @return la stringa descrittiva del film
     */
    public String toString()
    {
       StringBuffer ris = new StringBuffer();
       String att = getAttore();
       
       ris.append(String.format(DESCRIZIONE_FILM, getTitolo(), regista, att, getGenere(), getLingua(), durataInMinuti, getAnnoPub(), getNumLicenze()));
       return ris.toString();
    }
}