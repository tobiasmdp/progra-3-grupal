package formulario;

import capaDeNegocios.Agencia;

public class FactoryRemuneracion {
	public static Remuneracion getRemuneracion(double tipo) {
		Remuneracion respuesta = null;
		if (tipo<=Agencia.getInstance().getV1()) 
			respuesta = new HastaV1();
		else if (tipo<Agencia.getInstance().getV2()) 
			respuesta = new EntreV1yV2();
		else 
			respuesta = new MasdeV2();
		return respuesta;
	}
}
