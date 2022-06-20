package capaDeNegocios;

import java.util.Comparator;

/**
 *<b>
 *Clase que sobreescribe el metodo compare para ordenar las listas por puntajes.
 */
public class UsuarioComparator implements Comparator<Usuario_puntaje> {
	
	@Override
	public int compare(Usuario_puntaje u2, Usuario_puntaje u1) {
		return ((Double)u1.getPuntaje()).compareTo((Double)u2.getPuntaje());
	}
}
