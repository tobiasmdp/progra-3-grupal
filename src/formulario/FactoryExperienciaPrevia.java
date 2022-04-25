package formulario;

public class FactoryExperienciaPrevia {
	public static ExperienciaPrevia getExperienciaPrevia(String tipo) {
		ExperienciaPrevia respuesta = null;
		if (tipo.equals("ExperienciaNada")) 
			respuesta = new ExperienciaNada();
		else if (tipo.equals("ExperienciaMedia")) 
			respuesta = new ExperienciaMedia();
		else if (tipo.equals("ExperienciaMucha")) 
			respuesta = new ExperienciaMucha();
		return respuesta;
	}
}