package interazione;

import java.io.File;

import logica.*;
import utility.*;

public class LoadClass 
{
	 private File gestoreRisorse = new File(Costanti.NOME_FILE);
	 
	 private static LoadClass instance;
	    
	 private RaccoltaDati rd = null;
	 private AnagraficaFruitori af = null;
	 private AnagraficaOperatori ao = null;
	 private Archivio arc = null;
	 private ArchivioPrestiti ap = null;
	 private ArchivioStorico as = null;

	 private boolean caricamentoRiuscito = false;
	 
	 private LoadClass() {};
	 
	 public static LoadClass getinstance()
	 {
		 if(instance == null)
		 {
			 instance = new LoadClass();
		 }
		 return instance;
	 }
		
	 public void inizializza() 
	 {
		if (gestoreRisorse.exists())
		{
			try 
			{
				rd = (RaccoltaDati)ServizioFile.caricaSingoloOggetto(gestoreRisorse);
				af = RaccoltaDati.getInstance(af, ao, arc, ap, as).getAnagraficaFruitori();
				ao = RaccoltaDati.getInstance(af, ao, arc, ap, as).getAnagraficaOperatori();
				arc =  RaccoltaDati.getInstance(af, ao, arc, ap, as).getArchivio();
				ap = RaccoltaDati.getInstance(af, ao, arc, ap, as).getArchivioPrestiti();
				as =  RaccoltaDati.getInstance(af, ao, arc, ap, as).getArchivioStorico();
			}
			catch (ClassCastException e)
			{
				System.out.println(Costanti.MSG_NO_CAST);
			}
			catch(NullPointerException a)
			{
				System.out.println();
			}
			finally
			{
				if (af != null && ao != null && arc != null && ap != null && as != null)
				{
					System.out.println(Costanti.MSG_OK_FILE);
					caricamentoRiuscito = true;
				}
			}		
		 }
		
		if (!caricamentoRiuscito)				
		{
			System.out.println(Costanti.MSG_NO_FILE);				
			af = new AnagraficaFruitori();
			ao = new AnagraficaOperatori();
			arc = new Archivio();
			ap = new ArchivioPrestiti();
			as = new ArchivioStorico();
			
			StrutturaSistema.aggiuntaOperatoriPreimpostati(ao);
			StrutturaSistema.creazioneStrutturaArchivioLibri(arc);
			StrutturaSistema.creazioneStrutturaArchivioFilm(arc);
		}
	}
	    
	public AnagraficaFruitori getAnagraficaFruitori()
	{
	   return af;
	}
	    
    public AnagraficaOperatori getAnagraficaOperatori()
	{
	   return ao;
    }
	    
    public Archivio getArchivio()
	{
	   return arc;
	}
	    
	public ArchivioPrestiti getArchivioPrestiti()
	{
       return ap;
	}
	    
	public ArchivioStorico getArchivioStorico()
	{
	   return as;
	}
	    
	public void salva() 
	{	
	  System.out.println(Costanti.MSG_SALVA);
	  ServizioFile.salvaSingoloOggetto(gestoreRisorse, RaccoltaDati.getInstance(af, ao, arc, ap, as));
    } 
	
}
