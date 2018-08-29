package dominio.parte2.punto4;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Contenitore implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private ArrayList <Risorsa> elencoRisorse;
	 
	 public Contenitore(String n)
	 {
		 this.nome = n;
	 }
	 
	 public void inizializzaElencoRisorse()
	 {
		   elencoRisorse = new ArrayList <Risorsa> ();
	 }
	 
	 public String getNome()
	 {
		   return nome;
	 }
	 
	 public ArrayList <Risorsa> getElencoRisorse()  
	 {
		   return elencoRisorse;
	 }
	 
	 public Risorsa getRisorsa(String t)
	 {
		   for(int i = 0; i < elencoRisorse.size(); i++)
		   {
			   Risorsa r = elencoRisorse.get(i);
			   if(r.getTitolo().equalsIgnoreCase(t))
				   return r;
		   }
		   
		   return null;
	 }
	 
	 public void aggiungiRisorsa(Risorsa r)  
	 {
		   elencoRisorse.add(r);
	 }
	  
	 public void rimuoviRisorsa(Risorsa r)  
	 {
		   elencoRisorse.remove(r);   
	 }
	   
	 public abstract ArrayList <Risorsa> ricercaRisorsa(IRicercaStrategy ricerca);
	  
	 public abstract String toString();
}
