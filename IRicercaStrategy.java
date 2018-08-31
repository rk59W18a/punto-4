package dominio.parte2.punto4;

import java.util.ArrayList;

// Sono state ridenominate sia l'interface Ricerca sia le classi che la implementano
// aggiungendo il suffisso -Strategy
public interface IRicercaStrategy 
{
   ArrayList <Risorsa> ricercaRisorsa(ArrayList <Risorsa> r);
}
