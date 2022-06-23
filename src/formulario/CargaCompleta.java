package formulario;
<<<<<<< HEAD
/**
 *<br>
 *La clase CargaCompleta es parte del patron Double Dispatch para la categoria del formulario CargaHoraria
 */
public class CargaCompleta implements CargaHoraria {

	
	/**
	 *@param otracaract : Parametro String que contiene la clase que invoca el patron Double Dispatch
	 */
=======

public class CargaCompleta implements CargaHoraria{


>>>>>>> 82225852a058ccbc322004c7f559462455d4ff81
	public double compara(CargaHoraria otracaract) {
		return otracaract.completa();
	}

	public double media() {
		return -0.5;
	}

	public double completa() {
		return 1;
	}

	public double extendida() {
		return 1;
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		return "Completa ";
	}

=======
		return "Carga Completa";
	}

	
>>>>>>> 82225852a058ccbc322004c7f559462455d4ff81
}
