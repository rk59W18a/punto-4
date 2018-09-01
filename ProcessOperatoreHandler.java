package interazione.parte2.punto4;

import java.io.Serializable;

import java.time.LocalDate;

import dominio.parte2.punto4.Categoria;
import dominio.parte2.punto4.Risorsa;
import dominio.parte2.punto4.SottoCategoria;
import logica.parte2.punto4.AnagraficaFruitori;
import logica.parte2.punto4.AnagraficaOperatori;
import logica.parte2.punto4.Archivio;
import logica.parte2.punto4.ArchivioPrestiti;
import logica.parte2.punto4.ArchivioStorico;
import logica.parte2.punto4.Fruitore;
import logica.parte2.punto4.Operatore;
import logica.parte2.punto4.Utente;
import utility.parte2.Costanti;
import utility.parte2.InputDati;

public class ProcessOperatoreHandler extends ProcessHandler implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private AnagraficaOperatori ao;
    
    public ProcessOperatoreHandler(Archivio arc, ArchivioPrestiti ap, AnagraficaFruitori af, AnagraficaOperatori ao, ArchivioStorico as)
    {  
    	super(arc, ap, af, as);
    	this.ao = ao;
    }
    
     public Utente accesso()
	 {
	     String use = "";
	     String pwd = "";
		 boolean end = false;
		 Utente ut = null;
			
		  do
		  {
		      use = InputDati.leggiStringaNonVuota(Costanti.USERNAME);
		      pwd = InputDati.leggiStringaNonVuota(Costanti.PASSWORD);

			  if(ao.accedi(use, pwd))
			  {
				  ut = ao.getUtente(use, pwd);
				  end = true;
			  }
			  else
			  {
				   System.out.println(Costanti.CREDENZIALI_ERRATE);
					 
				   if(InputDati.leggiUpperChar(Costanti.RICHIESTA_PROSECUZIONE, "SN") == 'N')
				   {
					  end = true;
				   }	
			  }
		
		    }while(!end);
			
		 return ut;
    }
	
	public void visualizzaElencoFruitori(Operatore op)
	{
		System.out.println(op.visualizzaElencoFruitori(getAnagraficaFruitori()));
	}
	
     public void aggiungiRisorsa(Operatore op)
     {
     	 Categoria c = null;
     	 SottoCategoria sc = null;
     	 Risorsa nuovar = null;
     	     
     	 System.out.printf(Costanti.CONTENUTO_ARC, getArchivio().stampaElencoCategorie());
     	
         int num1 = InputDati.leggiIntero(Costanti.INS_NUMERO_CAT_AGGIUNTA_RISORSA, Costanti.NUM_MINIMO, (getArchivio().getElencoCategorie()).size());
         c = (getArchivio().getElencoCategorie()).get(num1-Costanti.NUM_MINIMO);
         
         if(c.getElencoSottoCategorie() == null)
         {
         	System.out.printf(Costanti.CAT_SENZA_SOTTO, c.getNome());
           	    
           	if(InputDati.leggiUpperChar(Costanti.INS_PROCEDERE_CAT, "SN") == 'S')
           	{
           	   if((c.getNome()).equalsIgnoreCase(Costanti.LIBRI))  
 	           {
 		      	  nuovar = InserimentoRisorsa.inserisciLibro();
 	           }
 		       else if((c.getNome()).equalsIgnoreCase(Costanti.FILM))
 		       {
		    	        nuovar = InserimentoRisorsa.inserisciFilm();
		       }
 		     
 		       if(nuovar != null)
 		       {
 		    	     if((c.getRisorsa(nuovar.getTitolo()) == null))
 	       	         {
	    	   		     op.aggiungiRisorsa(nuovar, c);
	    	     	     System.out.println(Costanti.OP_SUCCESSO);
	    	   	     }
 	       	         else
 	       	    	    System.out.println(Costanti.OP_NO_SUCCESSO_1);
 	           }
           	}	    
         }
         else if(c.getElencoSottoCategorie().size() == 0)
         {
         	System.out.printf(Costanti.CONTENUTO_ELENCO_SOTTO_VUOTO, c.getNome());
         }
         else
         {
         	System.out.printf(Costanti.CONTENUTO_CAT_SOTTO, c.getNome(), stampaElencoSottocategorie(c));
             	
             if(InputDati.leggiUpperChar(Costanti.INS_PROCEDERE_SOTTO, "SN") == 'S')
             {	 
             	int num2 = InputDati.leggiIntero(Costanti.INS_NUMERO_SOTTO_AGGIUNTA_RISORSA, Costanti.NUM_MINIMO, (c.getElencoSottoCategorie()).size());
             	sc = (c.getElencoSottoCategorie()).get(num2-Costanti.NUM_MINIMO);
         	    	    	    	    	    
             	 if((c.getNome()).equalsIgnoreCase(Costanti.LIBRI))  
         	     {
         	         nuovar = InserimentoRisorsa.inserisciLibro();
         	     }
         	     else if((c.getNome()).equalsIgnoreCase(Costanti.FILM))
         	     {
         	         nuovar = InserimentoRisorsa.inserisciFilm();
         	     }
   	    	   	          
     	         if(nuovar != null)
     	         {
     	          	if(!(c.verificaPresenza(nuovar.getTitolo())))	
	    	   	    {
	    	   	           if(((nuovar.getGenere()).equalsIgnoreCase(sc.getNome())))
	    	   	           {
	    	   		          op.aggiungiRisorsa(nuovar, sc);
	    	      	          System.out.println(Costanti.OP_SUCCESSO);
	    	   	           }
	    	   	           else
	    	    	              System.out.println(Costanti.OP_NO_SUCCESSO_2);
 	                }
	    	   	    else
	    	   	        		  System.out.println(Costanti.OP_NO_SUCCESSO_1);
     	         }
             }    
         }    	
     }
    
     public void rimuoviRisorsa(Operatore op)
     {
        Categoria c = null;
 	    SottoCategoria sc = null;
 	    Risorsa daEliminare = null;
 	    
 	    System.out.printf(Costanti.CONTENUTO_ARC, getArchivio().stampaElencoCategorie());
 	    
 	    int num1 = InputDati.leggiIntero(Costanti.INS_NUMERO_CAT_RIMOZIONE_RISORSA, Costanti.NUM_MINIMO, (getArchivio().getElencoCategorie()).size());
        c = (getArchivio().getElencoCategorie()).get(num1-Costanti.NUM_MINIMO);
     	
         if(c.getElencoSottoCategorie() == null)
     	 {
         	if((c.getElencoRisorse()).size() != 0)
         	{
         		System.out.printf(Costanti.CAT_SENZA_SOTTO, c.getNome());
         		System.out.printf(Costanti.CONTENUTO_CAT_RISORSA, c.getNome(), stampaElencoRisorse(c));

         		if(InputDati.leggiUpperChar(Costanti.INS_PROCEDERE_RISORSA, "SN") == 'S')
     	    	{
         			int num2 = InputDati.leggiIntero(Costanti.INS_NUMERO_RISORSA_RIMOZIONE, Costanti.NUM_MINIMO, (c.getElencoRisorse()).size());
     		      	daEliminare = (c.getElencoRisorse()).get(num2-Costanti.NUM_MINIMO);
     		     	op.rimuoviRisorsa(daEliminare, c);
     		     	getArchivioStorico().aggiungiRisorsaRimossa(daEliminare);
             		System.out.println(Costanti.OP_SUCCESSO);
     	    	}
     	    } 
       	    else
     	    {
         		System.out.printf(Costanti.CONTENUTO_ELENCO_RISORSE_CAT_VUOTO, c.getNome());
     	    }
     	 }
         else if((c.getElencoSottoCategorie()).size() == Costanti.VUOTO)
         {
   	       	System.out.printf(Costanti.CONTENUTO_ELENCO_SOTTO_VUOTO, c.getNome());
         }
         else
         {
         	System.out.printf(Costanti.CONTENUTO_CAT_SOTTO, c.getNome(), stampaElencoSottocategorie(c));
       	       		
       	    if(InputDati.leggiUpperChar(Costanti.INS_PROCEDERE_SOTTO, "SN") == 'S')
       	    {
       	     	int num2 = InputDati.leggiIntero(Costanti.INS_NUMERO_SOTTO_RIMOZIONE_RISORSA, Costanti.NUM_MINIMO, (c.getElencoSottoCategorie()).size());
     	    	sc = (c.getElencoSottoCategorie()).get(num2-Costanti.NUM_MINIMO);
     	    	   
     	    	if(sc.getElencoRisorse().size() != Costanti.VUOTO)
     	      	{
     	           	System.out.printf(Costanti.CONTENUTO_SOTTO, sc.getNome(), stampaElencoRisorse(sc));
     	           	
     	      	    if(InputDati.leggiUpperChar(Costanti.INS_PROCEDERE_RISORSA, "SN") == 'S')
     	      	    {
     	      	     	int num3 = InputDati.leggiIntero(Costanti.INS_NUMERO_RISORSA_RIMOZIONE, Costanti.NUM_MINIMO, (sc.getElencoRisorse()).size());
         	    		daEliminare = (sc.getElencoRisorse()).get(num3-Costanti.NUM_MINIMO);
         	    		op.rimuoviRisorsa(daEliminare, sc);
         	    		getArchivioStorico().aggiungiRisorsaRimossa(daEliminare);
         	           	System.out.println(Costanti.OP_SUCCESSO);
     	      	    }
     	      	}
     	     	else
     	    		    System.out.printf(Costanti.CONTENUTO_ELENCO_RISORSE_SOTTO_VUOTO, sc.getNome());
       	    }   	 	   
         }   
     }
     
     public void visualizzaArchivio(Operatore op)
     {
    	 System.out.println(op.visualizzaArchivio(getArchivio()));
     }
    
     public String sceltaInterrogazione(Operatore o)
     {
  	    int numScelta = InputDati.leggiIntero(Costanti.SCELTA_INTERROGAZIONE, Costanti.NUM_MINIMO, Costanti.NUM_MASSIMO_SCELTA_INTERROGAZIONE);
  	    int anno = 0;
  	    Fruitore f = null;
  	    String s1 = "";
  	    String s2 = "";
  	    
  	    anno = InputDati.leggiIntero(Costanti.INS_ANNO_RICHIESTO, Costanti.ANNO_MINIMO_INTERROGAZIONE, LocalDate.now().getYear());
  	    
  	    switch(numScelta)
  	    {
  	       case 1: s2 = Costanti.NUM_PRESTITI_PER_ANNO + o.numeroPrestitiPerAnno(getArchivioStorico(), anno);
  	    			    break;
  	    		
  	       case 2: s2 = Costanti.NUM_PROROGHE_PER_ANNO + o.numeroProroghePerAnno(getArchivioStorico(), anno);
  	    			    break;
  	       
  	       case 3: s2 = o.risorsaPiuRichiesta(getArchivioStorico(), anno);
  	    	           if(!(s2.equals("")))
  	    	           {
  	    	              s2 = Costanti.TITOLO_RISORSA_PIU_PRESTITI_PER_ANNO + s2;
  	    	           }
  	    	           else
  	    	           {
  	    	        	  s2 = Costanti.TITOLO_RISORSA_SENZA_PRESTITI_PER_ANNO;
  	    	           }
  				       break;
  	    	   
  	       case 4: s1 = InputDati.leggiStringa(Costanti.INS_FRUITORE_RICHIESTO);
  	    			 
  	    		   if(getAnagraficaFruitori().getFruitore(s1) != null)
  	    		   {
  	    			  f = getAnagraficaFruitori().getFruitore(s1);
  	   	        	  s2 = Costanti.NUM_PRESTITI_PER_FRUITORE_PER_ANNO + o.numeroPrestitiPerFruitorePerAnno(getArchivioStorico(), f, anno);
  	    		   }
  	    		   else
  	   			   {
  	   				  s2 = Costanti.FRUITORE_NON_TROVATO;
  	   		 	   }
  	               break;
  	    }  
  	    
  	    return s2;
     }   
}