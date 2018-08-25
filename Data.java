package interazione;

import java.time.LocalDate;

public class Data {

	LocalDate data;
	
	public Data(LocalDate d) {
		data = d;
	}
	
	public Data() {
		data = LocalDate.now();
	}
	
	public boolean verificaDataSuccessiva(LocalDate d) {
		LocalDate.now().isAfter(d);
	}
	
	public boolean verificaDataCoincidente(LocalDate d) {
		LocalDate.now().equals(d);
	}
	
	public LocalDate aumentaAnni(LocalDate d, int numeroAnni) {
		return d.plusYears(numeroAnni);
	}
}
