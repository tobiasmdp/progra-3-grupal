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
		
		UEmpleado empleado=(UEmpleado)Agencia.getInstance().registroEmpleado("1","1","nahuel","nievas","223444444",23);
		Agencia.getInstance().crearTicketEmpleado("Indistinto", 80000, "CargaMedia", "senior", "ExperienciaMedia", "primario",empleado);
		UEmpleado empleado2=(UEmpleado)Agencia.getInstance().registroEmpleado("2","2","nahuel","nievas","223444444",24);
		Agencia.getInstance().crearTicketEmpleado("Indistinto", 80000, "CargaMedia", "senior", "ExperienciaMedia", "primario",empleado2);
		UAdministrador admin=(UAdministrador)Agencia.getInstance().registroAdministrador("pepe", "pepe");
		Agencia.getInstance().crearTicketEmpleado("Indistinto", 80000, "CargaMedia", "senior", "ExperienciaMedia", "primario",empleado);
		Agencia.getInstance().registroEmpleado("2","2");
		Agencia.getInstance().registroEmpleado("3","3");
		Agencia.getInstance().registroEmpleado("4","4");
		Agencia.getInstance().registroEmpleador("5","5");
		UEmpleador empleador=(UEmpleador)Agencia.getInstance().registroEmpleador("6","6");
		Agencia.getInstance().crearTicketEmpleador("Indistinto", 100000, "CargaMedia", "senior", 20, "ExperienciaMedia", "secundario",8,7,6,5,4,3,2,1,empleador);
		Agencia.getInstance().registroEmpleador("7","7");
		Agencia.getInstance().registroEmpleador("8","8");
		ControladorSistema controlador=new ControladorSistema();
	}
}
