package prueba;

import capaDeNegocios.Agencia;
import capaDePresentacion.ControladorSistema;
import capaDePresentacion.UAdministrador;
import capaDePresentacion.UEmpleado;
import capaDePresentacion.UEmpleador;

public class Prueba {

	public static void main(String[] args) {
		
		Agencia.getInstance();

		//------------------ CARGA DE VARIABLES ------------------
		
		/*ORDEN DE LOS ATRIBUTOS
		 * Home Office Indistinto Presencial // CargaExtendida CargaCompleta CargaMedia // Primario Secundario Terciario // ExperienciaNada ExperienciaMedia ExperienciaMucha
		 * HastaV1 EntreV1yV2 MasdeV2 // Junior Senior Managment // Menosde40 Entre40Y50 Masde50 
		 */
		
		//cada instancia de una sub clase de Usuario se llamara = nombre-de-la-clase + nro de usuario
		//el usuario numero 10 si es empleado, se llamara empleado10
		
		String nombreArchivo = "Agencia.xml" ;
		Agencia.getInstance().cargarAgencia(nombreArchivo);
		UAdministrador admin=(UAdministrador)Agencia.getInstance().registroAdministrador("pepe", "pepe");
		Agencia.getInstance().rondaEncuentrosLaborales();
		ControladorSistema controlador=new ControladorSistema();
		//Agencia.getInstance().rondaEncuentrosLaborales();
	
		//Agencia.getInstance().guardarAgencia(nombreArchivo); //ESTE LLAMADO SE REALIZA EN LOS LOGOUT DEL CONTROLOADOR DEL SISTEMA, A FIN DE PERSISTIR
																//LOS EVENTOS GATILLADOS POR EL USUARIO QUE UTILIZA LA VENTANA
	}
}
