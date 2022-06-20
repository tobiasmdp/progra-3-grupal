package formulario;
/**
 *<br>
 *La clase utiliza el patron Factory para la creacion de categorias de EstudiosCursados.
 */
public class FactoryEstudiosCursados {
	/**<br> Metodo que recibe una categoria e instancia un nuevo objeto con el mismo nombre(Patron Factory)
	 * @param tipo : Parametro de tipo String con la categoria de EstudiosCursados
	 * <b>Pre: </b> Debe recibir como parametros "Primario", "Secundario" o "Terciario"<br>
	 * <b>Pos: </b> Devuelve un objeto de tipo Primario, Secundario o Terciario<br>
	 */
	public static EstudiosCursados getEstudiosCursados(String tipo) {
		EstudiosCursados respuesta = null;
		if (tipo.equalsIgnoreCase("Primario")) 
			respuesta = new Primario();
		else if (tipo.equalsIgnoreCase("Secundario")) 
			respuesta = new Secundario();
		else if (tipo.equalsIgnoreCase("Terciario")) 
			respuesta = new Terciario();
		return respuesta;
	}
}