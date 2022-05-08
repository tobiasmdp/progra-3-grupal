package agencia;

import java.util.Comparator;

public class UsuarioComparator implements Comparator<Usuario_puntaje> {
	//esta clase se usa para ordenar las listas generadas en base al puntaje obtenido en la ronda de encuentros
	@Override
	public int compare(Usuario_puntaje u2, Usuario_puntaje u1) {
		return ((Double)u1.getPuntaje()).compareTo((Double)u2.getPuntaje());
	}
}
