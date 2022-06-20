package excepciones;

/**
 *Esta excepcion es creada cuando un usuario buscado no es encontrado en su arreglo
 */
public class UsuarioNoEncontradoException extends Exception {

	public UsuarioNoEncontradoException(String arg) {
		super(arg);
	}
	
}
