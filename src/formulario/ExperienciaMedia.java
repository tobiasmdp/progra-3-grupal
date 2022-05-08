package formulario;

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
		return "Experiencia Media";
	}
    

}
