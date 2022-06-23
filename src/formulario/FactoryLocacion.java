package formulario;
<<<<<<< HEAD
/**
 *<br>
 *La clase utiliza el patron Factory para la creacion de categorias de Locacion.
 */
public class FactoryLocacion {
	/**<br> Metodo que recibe una categoria e instancia un nuevo objeto con el mismo nombre(Patron Factory)
	 * @param tipo : Parametro de tipo String con la categoria de Locacion
	 * <b>Pre: </b> Debe recibir como parametros "Home Office", "Indistinto" o "Presencial"<br>
	 * <b>Pos: </b> Devuelve un objeto de tipo HomeOffice, Indistinto o Presencial<br>
	 */
=======

public class FactoryLocacion {
>>>>>>> 82225852a058ccbc322004c7f559462455d4ff81
	public static Locacion getLocacion(String tipo) {
		Locacion respuesta = null;
		if (tipo.equalsIgnoreCase("Home Office"))
			respuesta = new HomeOffice();
		else if (tipo.equalsIgnoreCase("Indistinto"))
			respuesta = new Indistinto();
		else if (tipo.equalsIgnoreCase("Presencial"))
			respuesta = new Presencial();
		return respuesta;
	}
}
