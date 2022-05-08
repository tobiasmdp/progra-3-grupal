package formulario;

public abstract class FactoryRangoEtario {
	public static RangoEtario getRangoEtario(double tipo) {
		RangoEtario respuesta=null;
		if(tipo<40)
			respuesta = new Menosde40();
		if(tipo<=50)
			respuesta = new Entre40Y50();
		else
			respuesta = new Masde50();
		return respuesta;
	}
}