package dominio.parte2.punto4;

import java.io.Serializable;
import java.util.ArrayList;

public class Categoria extends Contenitore implements Serializable
{
	   private static final long serialVersionUID = 1L;
	   
	   private ArrayList <SottoCategoria> elencoSottoCategorie;
	   
	   private int numeroMaxGiorniPrestito;
	   private int numeroMaxGiorniProroga;
	   private int numeroGiorniRichiestaProroga;
	   private int numeroMaxRisorseInPrestito;

	   public static final String DESCRIZIONE_CATEGORIA_SEMPLICE = "Nome categoria: %s\nRisorse in essa contenute:\n";
	   public static final String DESCRIZIONE_CATEGORIA_COMPOSTA = "Nome categoria: %s\nSottocategorie in essa contenute:\n";
	   public static final String ELENCO_SOTTOCATEGORIE_VUOTO = "\tAl momento non sono presenti sottocategorie\n";
	   public static final String ELENCO_RISORSE_VUOTO = "\t\tAl momento non sono presenti risorse\n";
	   
	   public Categoria(String n, int numPres, int numMaxPro, int numRiPro, int numRis)
	   {
		   super(n);
		   this.numeroMaxGiorniPrestito = numPres;
		   this.numeroMaxGiorniProroga = numMaxPro;
		   this.numeroGiorniRichiestaProroga = numRiPro;
		   this.numeroMaxRisorseInPrestito = numRis;
	   }
	  	   
	   public void inizializzaElencoSottoCategorie()
	   {
		   elencoSottoCategorie = new ArrayList <SottoCategoria> ();
	   }
	   
	   public int getNumeroMaxGiorniPrestito()
	   {
		   return numeroMaxGiorniPrestito;
	   }
	   
	   public int getNumeroMaxGiorniProroga()
	   {
		   return numeroMaxGiorniProroga;
	   }
	   
	   public int getNumeroGiorniRichiestaProroga()
	   {
		   return numeroGiorniRichiestaProroga;
	   }
	   
	   public int getNumeroMaxRisorseInPrestito()
	   {
		   return numeroMaxRisorseInPrestito;
	   }
	 
	   public ArrayList <SottoCategoria> getElencoSottoCategorie() 
	   {
		   return elencoSottoCategorie;
	   }
	 
	   public void aggiungiSottoCategoria(SottoCategoria sc)
	   {
		   elencoSottoCategorie.add(sc);
	   }
	  
	   public boolean verificaPresenza(String t)
	   {
		  boolean presente = false;
		   
		  for(int i = 0; i < elencoSottoCategorie.size(); i++)
		  {
			  SottoCategoria sc = elencoSottoCategorie.get(i);
			  
			  for(int j = 0; j < sc.getElencoRisorse().size(); j++)
			  {
				  Risorsa r = sc.getElencoRisorse().get(j);
				  
				  if(r.getTitolo().equalsIgnoreCase(t))
				  {
					  presente = true;
					  break;
				  }	   
			  }
		   }
		   return presente;
	   }
	 
	   public ArrayList <Risorsa> ricercaRisorsa(IRicercaStrategy ricerca)
	   {
		   ArrayList <Risorsa> risorseCercate = new ArrayList <>();
		   
		   if(elencoSottoCategorie == null)
		   { 
			   risorseCercate = ricerca.ricercaRisorsa(getElencoRisorse());
		   }
		   else
		   {
			   for(int i = 0; i < elencoSottoCategorie.size(); i++)
			   {
				   SottoCategoria sc = elencoSottoCategorie.get(i);
				   risorseCercate.addAll(sc.ricercaRisorsa(ricerca));
			   }
		   }
		   
		   return risorseCercate;
	   }
	   
	   public String toString()
	   {
		   StringBuffer ris = new StringBuffer();
		   
		   if(elencoSottoCategorie == null)
		   {
		       ris.append(String.format(DESCRIZIONE_CATEGORIA_SEMPLICE, getNome()));
		   
		       if(getElencoRisorse().size() == 0)
		    	       ris.append(ELENCO_RISORSE_VUOTO);
		       else
		       {
		          for(int i = 0; i < getElencoRisorse().size(); i++)
		          {
			         Risorsa r = getElencoRisorse().get(i);
			         ris.append("\t\t" + (i+1) + ")"+ r.toString());
		          }
		       }
		   }
		   else
		   {
			   ris.append(String.format(DESCRIZIONE_CATEGORIA_COMPOSTA, getNome()));
			   
			   if(elencoSottoCategorie.size() == 0)
				    ris.append(ELENCO_SOTTOCATEGORIE_VUOTO);
			   else
			   {
			      for(int i = 0; i < elencoSottoCategorie.size(); i++)
		          {
			         SottoCategoria s = elencoSottoCategorie.get(i);
			         ris.append("\t"+ (i+1) + ")"+ s.toString());
		          }
		        }
		    }
		   
		   return ris.toString();
	   }	   
}