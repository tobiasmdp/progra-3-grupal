package formulario;
<<<<<<< HEAD
/**
 *<br>
 *La clase utiliza el patron Factory para la creacion de categorias de CargaHoraria.
 */
public class FactoryCargaHoraria {
	/**<br> Metodo que recibe una categoria e instancia un nuevo objeto con el mismo nombre(Patron Factory)
	 * @param tipo : Parametro de tipo String con la categoria de CargaHoria
	 * <b>Pre: </b> Debe recibir como parametros "CargaExtendida", "CargaCompleta" o "CargaMedia"<br>
	 * <b>Pos: </b> Devuelve un objeto de tipo CargaExtendida,CargaCompleta o CargaMedia<br>
	 */
=======

public class FactoryCargaHoraria {
>>>>>>> 82225852a058ccbc322004c7f559462455d4ff81
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