package formulario;

<<<<<<< HEAD
/**
 *<br>
 *La clase ExperienciaMedia es parte del patron Double Dispatch para la categoria del formulario ExperienciaPrevia
 */
=======
>>>>>>> 82225852a058ccbc322004c7f559462455d4ff81
public class ExperienciaMedia implements ExperienciaPrevia{
	
	public double compara(ExperienciaPrevia otracaract) {
		return otracaract.comparaMedia();
	}

	public double comparaNada() {
		return 1.5;
	}

	public double comparaMedia() {
		return 1;
	}

	public double comparaMucha() {
		return -1.5;
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		return "Media";
=======
		return "Experiencia Media";
>>>>>>> 82225852a058ccbc322004c7f559462455d4ff81
	}
    

}
