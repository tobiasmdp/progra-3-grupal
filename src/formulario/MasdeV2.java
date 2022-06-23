package formulario;
<<<<<<< HEAD
/**
 *<br>
 *La clase MasdeV2 es parte del patron Double Dispatch para la categoria del formulario Remuneracion
 */
=======

>>>>>>> 82225852a058ccbc322004c7f559462455d4ff81
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
<<<<<<< HEAD
		return "Mas de V2           ";
	}
	 
=======
		return "Mas de V2 ";
	}
	
>>>>>>> 82225852a058ccbc322004c7f559462455d4ff81
}

