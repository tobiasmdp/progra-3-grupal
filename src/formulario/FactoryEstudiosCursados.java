package formulario;

public class FactoryEstudiosCursados {
	public static EstudiosCursados getEstudiosCursados(String tipo) {
		EstudiosCursados respuesta = null;
		if (tipo.equalsIgnoreCase("Primario")) 
			respuesta = new Primario();
		else if (tipo.equalsIgnoreCase("Secundario")) 
			respuesta = new Secundario();
		else if (tipo.equalsIgnoreCase("Terciario")) 
			respuesta = new Terciario();
		return respuesta;
	}
}