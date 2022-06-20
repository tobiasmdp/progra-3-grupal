package comisiones;

/**
 *Factory para determinar de que tipo de persona es cada empleador
 */
public class FactoryPersona {
	/**
	 * <b>Pre:</b> el tipo de persona solo puede ser Juridica o Fisica para que este factory funcione. Puede ser escrito en mayusculas o minusculas
	 * @param tipo recibe un string y con este se crea el tipo de persona, 
	 * @return el objeto que representa al tipo de la persona
	 */
	public static IPersona getPersona(String tipo) {
		IPersona respuesta = null;
		if (tipo.equalsIgnoreCase("Juridica")) 
			respuesta = new Juridica();
		else if (tipo.equalsIgnoreCase("Fisica")) 
			respuesta = new Fisica();
		return respuesta;
	}
}