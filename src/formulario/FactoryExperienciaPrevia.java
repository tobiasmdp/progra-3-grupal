package formulario;
/**
 *<br>
 *La clase utiliza el patron Factory para la creacion de categorias de ExperienciaPrevia.
 */
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