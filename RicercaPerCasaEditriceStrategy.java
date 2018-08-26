package dominio.parte2.punto4;

import java.util.ArrayList;

public class RicercaPerCasaEditriceStrategy implements IRicercaStrategy
{
    private String s;
	
	public RicercaPerCasaEditriceStrategy(String s)
	{
		this.s = s;
	}
	
	public ArrayList <Risorsa> ricercaRisorsa(ArrayList <Risorsa> elencoris) 
	{
		 ArrayList <Risorsa> risorseCercate = new ArrayList <>();
	   	    
	   	 for(int i = 0; i < elencoris.size(); i++)
	   	 {
	   	     Risorsa ris = elencoris.get(i);
	   	     
	   	     if(((Libro)ris).getCasaEditrice().equalsIgnoreCase(s))
	               risorseCercate.add(ris);
	   	 }
	   	    	                    
	   	 return risorseCercate;
	}
}