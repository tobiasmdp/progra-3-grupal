package formulario;
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
			respuesta = new MasdeV2();
		return respuesta;
	}
}
