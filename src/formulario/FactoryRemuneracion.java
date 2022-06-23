package formulario;
<<<<<<< HEAD
/**
 *<br>
 *La clase utiliza el patron Factory para la creacion de categorias de Agencia.
 */
import capaDeNegocios.Agencia;

public class FactoryRemuneracion {
	/**<br> Metodo que recibe una categoria e instancia un nuevo objeto con el mismo nombre(Patron Factory)
	 * @param tipo : Parametro de tipo String con la categoria de Remuneracion
	 * <b>Pre: </b> Debe recibir como parametros un valor de tipo double mayor a 0
	 * <b>Pos: </b> Devuelve un objeto de tipo HastaV1, EntreV1yV2 o MasdeV2<br>
	 */
	public static Remuneracion getRemuneracion(double tipo) {
		Remuneracion respuesta = null;
		if (tipo<=Agencia.getInstance().getV1()) 
			respuesta = new HastaV1();
		else if (tipo<Agencia.getInstance().getV2()) 
			respuesta = new EntreV1yV2();
		else 
=======

public class FactoryRemuneracion {
	public static Remuneracion getRemuneracion(String tipo) {
		Remuneracion respuesta = null;
		if (tipo.equalsIgnoreCase("HastaV1")) 
			respuesta = new HastaV1();
		else if (tipo.equalsIgnoreCase("EntreV1yV2")) 
			respuesta = new EntreV1yV2();
		else if (tipo.equalsIgnoreCase("MasdeV2")) 
>>>>>>> 82225852a058ccbc322004c7f559462455d4ff81
			respuesta = new MasdeV2();
		return respuesta;
	}
}
