package formulario;

public class FactoryCargaHoraria {
	public static CargaHoraria getCargaHoraria(String tipo) {
		CargaHoraria respuesta = null;
		if (tipo.equalsIgnoreCase("CargaExtendida")) 
			respuesta = new CargaExtendida();
		else if (tipo.equalsIgnoreCase("CargaCompleta")) 
			respuesta = new CargaCompleta();
		else if (tipo.equalsIgnoreCase("CargaMedia")) 
			respuesta = new CargaMedia();
		return respuesta;
	}
}