package formulario;
<<<<<<< HEAD
/**
 *<br>
 *La clase ExperienciaMucha es parte del patron Double Dispatch para la categoria del formulario ExperienciaPrevia
 */
=======

>>>>>>> 82225852a058ccbc322004c7f559462455d4ff81
public class ExperienciaMucha implements ExperienciaPrevia{
	
	public double compara(ExperienciaPrevia otracaract) {
		return otracaract.comparaMucha();
	}

	public double comparaNada() {
		return 2;
	}

	public double comparaMedia() {
		return 1.5;
	}

	public double comparaMucha() {
		return 1;
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		return "Mucha ";
=======
		return "Mucha experiencia";
>>>>>>> 82225852a058ccbc322004c7f559462455d4ff81
	}
    

}
