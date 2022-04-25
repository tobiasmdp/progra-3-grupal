package formulario;

public class MasdeV2 implements Remuneracion{
	public double compara(Remuneracion otracaract) {
		return otracaract.comparaMasdeV2();
	}
	public double comparaHastaV1() {
		return -1;
	}
	public double comparadeV2aV1() {
		return -0.5;
	}
	public double comparaMasdeV2() {
		return 1;
	}
	@Override
	public String toString() {
		return "Mas de V2 ";
	}
	
}

