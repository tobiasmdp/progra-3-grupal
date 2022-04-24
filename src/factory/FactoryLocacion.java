package factory;

import dispatch.Locacion;
import dispatch.HomeOffice;
import dispatch.Indistinto;
import dispatch.Presencial;

public class FactoryLocacion {
	public static Locacion factoryGetLocacion(String tipo) {
		Locacion respuesta = null;
		if (tipo.equals("Home Office"))
			respuesta = new HomeOffice();
		else if (tipo.equals("Indistinto"))
			respuesta = new Indistinto();
		else if (tipo.equals("Presencial"))
			respuesta = new Presencial();
		return respuesta;
	}
}
