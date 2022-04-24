package factory;

import dispatch.EstudiosCursados;
import dispatch.Primario;
import dispatch.Secundario;
import dispatch.Terciario;

public class FactoryEstudiosCursados {
	public static EstudiosCursados factoryGetEstudiosCursados(String tipo) {
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