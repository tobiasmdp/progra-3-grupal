package formulario;
<<<<<<< HEAD
/**
 *<br>
 *La clase CargaMedia es parte del patron Double Dispatch para la categoria del formulario CargaHoraria
 */
=======

>>>>>>> 82225852a058ccbc322004c7f559462455d4ff81
public class CargaMedia implements CargaHoraria{
	public double compara(CargaHoraria otracaract) {
		return otracaract.media();
	}

	public double media() {
		return 1;
	}
	public double completa() {
		return -0.5;
	}
	public double extendida() {
		return -1;
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		return "Media    ";
=======
		return "Carga Media ";
>>>>>>> 82225852a058ccbc322004c7f559462455d4ff81
	}
	
	
}
