package dominio;

import java.util.ArrayList;

public class Persona {
	
    private ArrayList <String> soggetti;
    
    public Persona(ArrayList <String> s) {
    	soggetti = s;
    }
    
    public String getSoggetti(){
        	StringBuffer aut = new StringBuffer();
        
        	for(int i = 0; i < soggetti.size(); i++)
        	{
     	       	aut.append(soggetti.get(i));
     	       	if(i < soggetti.size()-1)
     	       		aut.append("-");
        	}
        	
        	return aut.toString();
    }

}
