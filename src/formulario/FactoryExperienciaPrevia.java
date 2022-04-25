package formulario;

public class FactoryExperienciaPrevia {
	public static ExperienciaPrevia getExperienciaPrevia(String tipo) {
		ExperienciaPrevia respuesta = null;
		if (tipo.equalsIgnoreCase("ExperienciaNada")) 
			respuesta = new ExperienciaNada();
		else if (tipo.equalsIgnoreCase("ExperienciaMedia")) 
			respuesta = new ExperienciaMedia();
		else if (tipo.equalsIgnoreCase("ExperienciaMucha")) 
			respuesta = new ExperienciaMucha();
		return respuesta;
	}
}