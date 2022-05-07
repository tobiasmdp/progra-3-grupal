package formulario;

/**
 * @author Se modifico la tabla segun nuestro criterio.
 * Se cambiaron los siguientes casos:
 * Si la empresa busca junior y hay managment, suma 0
 * Si la empresa busca junior y hay senior, suma 0.5
 * Si la empresa busca managment y hay senior, suma 0,5
 * Si la empresa busca managment y hay managment, suma 1
 *
 */
public interface TipodePuesto {
	double compara(TipodePuesto caract);
	double comparaJunior();
	double comparaSenior();
	double comparaManagment();
	double calculaComision();
}
