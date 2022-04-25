package formulario;

public class EntreV1yV2 implements Remuneracion{
	
	public double compara(Remuneracion otracaract) {
		return otracaract.comparadeV2aV1();
	}
	public double comparaHastaV1() {
		return 0.5;
	}
	public double comparadeV2aV1() {
		return 1;
	}
	public double comparaMasdeV2() {
		return 1;
	}
}
