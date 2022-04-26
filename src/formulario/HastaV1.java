package formulario;

import agencia.Agencia;

public class HastaV1 implements Remuneracion {
	
	public double compara(Remuneracion otracaract) {
		return otracaract.comparaHastaV1();
	}
	public double comparaHastaV1() {
		return 1;
	}
	public double comparadeV2aV1() {
		return 1;
	}
	public double comparaMasdeV2() {
		return 1;
	}
	@Override
	public String toString() {
		return "Menos de "+ Agencia.getInstance().getV1()+"      ";
	}
	
}
