package formulario;

public abstract class FactoryRangoEtario {
	public static RangoEtario getRangoEtario(String tipo) {
		RangoEtario respuesta=null;
		if(tipo.equalsIgnoreCase("Menosde40"))
			respuesta = new Menosde40();
		if(tipo.equalsIgnoreCase("Entre40Y50"))
			respuesta = new Entre40Y50();
		if (tipo.equalsIgnoreCase("Masde50"))
			respuesta = new Masde50();
		return respuesta;
	}
}