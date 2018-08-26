package logica.parte2.punto4;

import java.io.Serializable;

import dominio.parte2.punto4.*;


public class Operatore extends Utente implements Serializable
{
	private static final long serialVersionUID = 1L;

    public Operatore(String n, String c, String u, String p)
    {
   	     super(n, c, u, p);
    }
    
    public String visualizzaElencoFruitori(AnagraficaFruitori e)
    {
   	   return e.toString();
    }
    
    public void aggiungiRisorsaCategoria(Risorsa r, Categoria s)
    {
    	 s.aggiungiRisorsa(r);
    }
    
    public void rimuoviRisorsaCategoria(Risorsa r, Categoria s)
    {
    	 s.rimuoviRisorsa(r);
    }
    
    public String visualizzaArchivio(Archivio a)
    {
    	 return a.toString();
    }
    
    public int numeroPrestitiPerAnno(ArchivioStorico as, int anno)
    {
    	 return as.numeroPrestitiPerAnno(anno);
    }
    
    public int numeroProroghePerAnno(ArchivioStorico as, int anno)
    {
	     return as.numeroProroghePerAnno(anno);
    }
   
    public String risorsaPiuRichiesta(ArchivioStorico as, int anno)
    {
    	 return as.risorsaPiuRichiesta(anno);
    }
    
    public int numeroPrestitiPerFruitorePerAnno(ArchivioStorico as, Fruitore f, int anno)
    {
    	 return as.numeroPrestitiPerFruitorePerAnno(f, anno);
    }   
}