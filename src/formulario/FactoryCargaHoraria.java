package formulario;

public class FactoryCargaHoraria {
	public static CargaHoraria getCargaHoraria(String tipo) {
		CargaHoraria respuesta = null;
		if (tipo.equals("CargaExtendida")) 
			respuesta = new CargaExtendida();
		else if (tipo.equals("CargaCompleta")) 
			respuesta = new CargaCompleta();
		else if (tipo.equals("CargaMedia")) 
			respuesta = new CargaMedia();
		return respuesta;
	}
}