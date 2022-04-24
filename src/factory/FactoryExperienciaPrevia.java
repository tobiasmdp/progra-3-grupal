package factory;

import dispatch.ExperienciaPrevia;
import dispatch.ExperienciaNada;
import dispatch.ExperienciaMedia;
import dispatch.ExperienciaMucha;

public class FactoryExperienciaPrevia {
	public static ExperienciaPrevia factoryGetExperienciaPrevia(String tipo) {
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