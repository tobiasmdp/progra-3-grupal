package formulario;

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
    

}
