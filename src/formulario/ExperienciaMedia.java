package formulario;

/**
 *<br>
 *La clase ExperienciaMedia es parte del patron Double Dispatch para la categoria del formulario ExperienciaPrevia
 */
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
		return "Media";
	}
    

}
