package comisiones;

public class FactoryPersona {
	public static IPersona getPersona(String tipo) {
		IPersona respuesta = null;
		if (tipo.equalsIgnoreCase("Juridica")) 
			respuesta = new Juridica();
		else if (tipo.equalsIgnoreCase("Fisica")) 
			respuesta = new Fisica();
		return respuesta;
	}
}