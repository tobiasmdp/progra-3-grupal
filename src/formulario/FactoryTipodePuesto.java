package formulario;

public class FactoryTipodePuesto {
	public static TipodePuesto getTipodePuesto(String tipo) {
		TipodePuesto respuesta=null;
		if(tipo.equalsIgnoreCase("Junior"))
			respuesta = new Junior();
		if(tipo.equalsIgnoreCase("Senior"))
			respuesta = new Senior();
		if (tipo.equalsIgnoreCase("Managment"))
			respuesta = new Managment();
		return respuesta;
	}
}