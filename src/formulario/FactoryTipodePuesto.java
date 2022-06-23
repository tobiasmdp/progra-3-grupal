package formulario;
<<<<<<< HEAD
/**
 *<br>
 *La clase utiliza el patron Factory para la creacion de categorias de TipodePuesto.
 */
public class FactoryTipodePuesto {
	/**<br> Metodo que recibe una categoria e instancia un nuevo objeto con el mismo nombre(Patron Factory)
	 * @param tipo : Parametro de tipo String con la categoria de TipodePuesto
	 * <b>Pre: </b> Debe recibir como parametros "Junior", "Senior" o "Managment"<br>
	 * <b>Pos: </b> Devuelve un objeto de tipo Junior, Senior o Managment<br>
	 */
=======

public class FactoryTipodePuesto {
>>>>>>> 82225852a058ccbc322004c7f559462455d4ff81
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