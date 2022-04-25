package formulario;

public abstract class FactoryRangoEtario {
	public static RangoEtario getRangoEtario(String tipo) {
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