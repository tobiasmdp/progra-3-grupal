package comisiones;

/*
 * Factory para determinar a que tipo de rubro pertenece cada empleador 
 */
public class FactoryRubro {
	/**
	 ** <b>Pre:</b> el tipo de rubro solo puede ser de Salud, Comercio Local o Comercio Internacional para que este factory funcione. Puede ser escrito en mayusculas o minusculas
	 * @param tipo recibe un string y con este se crea el tipo de persona, 
	 * @return el objeto que representa al tipo de la persona
	 */
	public static TipoRubro getRubro(TipoPersona tPersona ,String tipo) {
		TipoRubro respuesta = null;
		if (tipo.equalsIgnoreCase("Salud")) 
			respuesta = new Salud(tPersona);
		else if (tipo.equalsIgnoreCase("Comercio Local")) 
			respuesta = new Local(tPersona);
		else if (tipo.equalsIgnoreCase("Comercio Internacional")) 
			respuesta = new Internacional(tPersona);
		return respuesta;
	}
}
