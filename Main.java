package interazione.parte2.punto4;

import logica.parte2.punto4.AnagraficaFruitori;
import logica.parte2.punto4.AnagraficaOperatori;
import logica.parte2.punto4.Archivio;
import logica.parte2.punto4.ArchivioPrestiti;
import logica.parte2.punto4.ArchivioStorico;

public class Main 
{	
	public static void main(String[] args) 
	{
		LoadClass.getinstance().inizializza();
		
		Archivio arc = LoadClass.getinstance().getArchivio();
		ArchivioPrestiti ap = LoadClass.getinstance().getArchivioPrestiti();
		AnagraficaFruitori af = LoadClass.getinstance().getAnagraficaFruitori();
		AnagraficaOperatori ao = LoadClass.getinstance().getAnagraficaOperatori();
		ArchivioStorico as = LoadClass.getinstance().getArchivioStorico();
	
		ProcessOperatoreHandler processOperatore = new ProcessOperatoreHandler(arc, ap, af, ao, as);  
        ProcessFruitoreHandler processFruitore = new ProcessFruitoreHandler(arc, ap, af, as);    
		
		MenuHandler gestore = new MenuHandler();
		gestore.logicaMenu(processOperatore,processFruitore);

		LoadClass.getinstance().salva();
	}
}