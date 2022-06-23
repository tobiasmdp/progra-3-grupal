package formulario;
<<<<<<< HEAD
/**
 *<br>
 *La clase utiliza el patron Factory para la creacion de categorias de RangoEtario.
 */
public abstract class FactoryRangoEtario {
	public static RangoEtario getRangoEtario(double tipo) {
		/**<br> Metodo que recibe una categoria e instancia un nuevo objeto con el mismo nombre(Patron Factory)
		 * @param tipo : Parametro de tipo String con la categoria de RangoEtario
		 * <b>Pre: </b> Debe recibir como parametros un valor de tipo double mayor a 0
		 * <b>Pos: </b> Devuelve un objeto de tipo Menosde50, Entre40y50 o Masde50<br>
		 */
		RangoEtario respuesta=null;
		if(tipo<40)
			respuesta = new Menosde40();
		if(tipo<=50)
			respuesta = new Entre40Y50();
		else
=======

public abstract class FactoryRangoEtario {
	public static RangoEtario getRangoEtario(String tipo) {
		RangoEtario respuesta=null;
		if(tipo.equalsIgnoreCase("Menosde40"))
			respuesta = new Menosde40();
		if(tipo.equalsIgnoreCase("Entre40Y50"))
			respuesta = new Entre40Y50();
		if (tipo.equalsIgnoreCase("Masde50"))
>>>>>>> 82225852a058ccbc322004c7f559462455d4ff81
			respuesta = new Masde50();
		return respuesta;
	}
}