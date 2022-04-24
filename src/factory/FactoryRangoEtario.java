package factory;

import dispatch.RangoEtario;
import dispatch.Menosde40;
import dispatch.Entre40Y50;
import dispatch.Masde50;

public abstract class FactoryRangoEtario {
	public static RangoEtario factoryGetRangoEtario(String tipo) {
		RangoEtario respuesta=null;
		if(tipo.equals("Menosde40"))
			respuesta = new Menosde40();
		if(tipo.equals("Entre40Y50"))
			respuesta = new Entre40Y50();
		if (tipo.equals("Masde50"))
			respuesta = new Masde50();
		return respuesta;
	}
}