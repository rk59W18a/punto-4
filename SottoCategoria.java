package dominio.parte2.punto4;

import java.io.Serializable;
import java.util.ArrayList;

public class SottoCategoria extends Contenitore implements Serializable
{
	/*
	private static final long serialVersionUID = 1L;

    public static final String DESCRIZIONE_SOTTOCATEGORIA = "Nome sottocategoria: %s\n\t";
    public static final String ELENCO_RISORSE_VUOTO = "Al momento non sono presenti risorse\n";
    public static final String INTESTAZIONE_RISORSE = "Risorse in essa contenute:\n";
   
    public SottoCategoria(String ns)
    {
    	super(ns);
    	inizializzaElencoRisorse();
    }
    */
    
	// E' stata creata l'interfaccia IRicercaStrategy, in accordo con il principio
	//della GoF Strategy, ed è stato dunque reimpostato il tipo di parametro
    public ArrayList <Risorsa> ricercaRisorsa(IRicercaStrategy ricerca)
    {
    	return ricerca.ricercaRisorsa(getElencoRisorse()); 
    }
    
    /*
    public String toString()
    {
 	   StringBuffer ris = new StringBuffer();
 	   ris.append(String.format(DESCRIZIONE_SOTTOCATEGORIA, getNome()));
 	   
 	   if(getElencoRisorse().size() == 0)
 		   ris.append(ELENCO_RISORSE_VUOTO);
 	   else
 	   {
 	      ris.append(INTESTAZIONE_RISORSE);
 	      
 		  for(int i = 0; i < getElencoRisorse().size(); i++)
 	      {
 		     Risorsa r = getElencoRisorse().get(i);
 		     ris.append("\t\t" + (i+1) + ")"+ r.toString());
 	      }  
 	   }
 	   
 	   return ris.toString();
    }   
    */
}