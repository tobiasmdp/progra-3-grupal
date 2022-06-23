package formulario;

<<<<<<< HEAD
import capaDeNegocios.Agencia;
/**
 *<br>
 *La clase HastaV1 es parte del patron Double Dispatch para la categoria del formulario Remuneracion
 */
=======
>>>>>>> 82225852a058ccbc322004c7f559462455d4ff81
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
<<<<<<< HEAD
		return "Menos de "+ Agencia.getInstance().getV1()+"      ";
=======
		return "Hasta V1 ";
>>>>>>> 82225852a058ccbc322004c7f559462455d4ff81
	}
	
}
