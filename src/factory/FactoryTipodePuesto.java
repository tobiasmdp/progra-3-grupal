package factory;

import dispatch.TipodePuesto;
import dispatch.Junior;
import dispatch.Senior;
import dispatch.Managment;

public class FactoryTipodePuesto {
	public static TipodePuesto factoryGetTipodePuesto(String tipo) {
		TipodePuesto respuesta=null;
		if(tipo.equals("Junior"))
			respuesta = new Junior();
		if(tipo.equals("Senior"))
			respuesta = new Senior();
		if (tipo.equals("Managment"))
			respuesta = new Managment();
		return respuesta;
	}
}