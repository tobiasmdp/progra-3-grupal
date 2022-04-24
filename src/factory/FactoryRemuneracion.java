package factory;

import dispatch.Remuneracion;
import dispatch.HastaV1;
import dispatch.EntreV1yV2;
import dispatch.MasdeV2;

public class FactoryRemuneracion {
	public Remuneracion getRemuneracion(String tipo) {
		Remuneracion respuesta = null;
		if (tipo.equals("HastaV1")) 
			respuesta = new HastaV1();
		else if (tipo.equals("EntreV1yV2")) 
			respuesta = new EntreV1yV2();
		else if (tipo.equals("MasdeV2")) 
			respuesta = new MasdeV2();
		return respuesta;
	}
}
