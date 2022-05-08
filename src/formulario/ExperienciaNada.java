package formulario;
/**
 *<br>
 *La clase ExperienciaNada es parte del patron Double Dispatch para la categoria del formulario ExperienciaPrevia
 */
public class ExperienciaNada implements ExperienciaPrevia{
	
	public double compara(ExperienciaPrevia otracaract) {
		return otracaract.comparaNada();
	}


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
		return "Nada ";
	}
    

}
