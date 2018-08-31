package dominio.parte2.punto3;

import java.io.Serializable;
import java.util.ArrayList;

public class RicercaPerAttore implements Ricerca, Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String s;
	
	public RicercaPerAttore(String s)
	{
		this.s = s;
	}
	
	public ArrayList <Risorsa> ricercaRisorsa(ArrayList <Risorsa> elencoris) 
	{
		 ArrayList <Risorsa> risorseCercate = new ArrayList <>();
	   	    
	   	 for(int i = 0; i < elencoris.size(); i++)
	   	 {
	   	     Risorsa ris = elencoris.get(i);
	   	    	    
	   	     if(((Film)ris).getAttore().toLowerCase().indexOf((s).toLowerCase()) > -1)
					risorseCercate.add(ris);
	   	 }
	   	    	                    
	   	 return risorseCercate;
	}
}