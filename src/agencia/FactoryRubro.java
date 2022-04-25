package agencia;

public class FactoryRubro {
	public static IRubro getRubro(String tipo) {
		IRubro respuesta = null;
		if (tipo.equalsIgnoreCase("Salud")) 
			respuesta = new Salud();
		else if (tipo.equalsIgnoreCase("Comercio Local")) 
			respuesta = new Local();
		else if (tipo.equalsIgnoreCase("Comercio Internacional")) 
			respuesta = new Internacional();
		return respuesta;
	}
}
