package formulario;

public class FactoryRemuneracion {
	public static Remuneracion getRemuneracion(String tipo) {
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