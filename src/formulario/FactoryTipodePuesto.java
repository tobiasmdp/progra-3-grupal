package formulario;

public class FactoryTipodePuesto {
	public static TipodePuesto getTipodePuesto(String tipo) {
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