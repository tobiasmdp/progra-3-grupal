package formulario;
<<<<<<< HEAD
/**
 *<br>
 *La clase ExperienciaNada es parte del patron Double Dispatch para la categoria del formulario ExperienciaPrevia
 */
=======

>>>>>>> 82225852a058ccbc322004c7f559462455d4ff81
public class ExperienciaNada implements ExperienciaPrevia{
	
	public double compara(ExperienciaPrevia otracaract) {
		return otracaract.comparaNada();
	}

<<<<<<< HEAD

=======
>>>>>>> 82225852a058ccbc322004c7f559462455d4ff81
	public double comparaNada() {
		return 1;
	}

	public double comparaMedia() {
		return -0.5;
	}

	public double comparaMucha() {
		return -2;
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		return "Nada ";
=======
		return "Nada de experiencia";
>>>>>>> 82225852a058ccbc322004c7f559462455d4ff81
	}
    

}
