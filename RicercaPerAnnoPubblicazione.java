package dominio.parte2.punto3;

import java.util.ArrayList;

public class RicercaPerAnnoPubblicazione implements Ricerca
{
    private int n;
	
	public RicercaPerAnnoPubblicazione(String s)
	{
		this.n = Integer.parseInt(s);
	}
	
	public ArrayList <Risorsa> ricercaRisorsa(ArrayList <Risorsa> elencoris) 
	{
		 ArrayList <Risorsa> risorseCercate = new ArrayList <>();
	   	    
	   	 for(int i = 0; i < elencoris.size(); i++)
	   	 {
	   	     Risorsa ris = elencoris.get(i);
	   	     
	   	    if(ris.getAnnoPub() ==  n)
	             risorseCercate.add(ris);
	   	     
	   	 }
	   	    	                    
	   	 return risorseCercate;
	}
}
