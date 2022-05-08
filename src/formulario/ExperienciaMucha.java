package formulario;

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
		return "Mucha experiencia";
	}
    

}
