package formulario;
<<<<<<< HEAD
/**
 *<br>
 *La clase utiliza el patron Factory para la creacion de categorias de ExperienciaPrevia.
 */
=======

>>>>>>> 82225852a058ccbc322004c7f559462455d4ff81
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