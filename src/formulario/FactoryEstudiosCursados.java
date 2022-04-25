package formulario;

public class FactoryEstudiosCursados {
	public static EstudiosCursados getEstudiosCursados(String tipo) {
		EstudiosCursados respuesta = null;
		if (tipo.equals("Primario")) 
			respuesta = new Primario();
		else if (tipo.equals("Secundario")) 
			respuesta = new Secundario();
		else if (tipo.equals("Terciario")) 
			respuesta = new Terciario();
		return respuesta;
	}
}