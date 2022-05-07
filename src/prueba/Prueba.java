package prueba;



import java.util.GregorianCalendar;

import capaDeNegocios.Agencia;
import capaDePresentacion.UAdministrador;
import capaDePresentacion.UEmpleado;
import capaDePresentacion.UEmpleador;

public class Prueba {

	public static void main(String[] args) {
		//UAdministrador admin1= new UAdministrador("Mikel","Contra");
		//admin1.setV1(15000);
		Agencia.getInstance();
		UEmpleado empleado1=new UEmpleado();
		empleado1.registrarse("Usuario1","Contraseña1","Nombre1","Apellido1","Telefono1",35);
		empleado1.crearTicket("Home Office", 15001, "CargaExtendida", "Senior", 35, "ExperienciaNada", "Primario");
		/*ORDEN DE LOS ATRIBUTOS
		 * Home Office Indistinto Presencial // CargaExtendida CargaCompleta CargaMedia // Primario Secundario Terciario // ExperienciaNada ExperienciaMedia ExperienciaMucha
		 * HastaV1 EntreV1yV2 MasdeV2 // Junior Senior Managment // Menosde40 Entre40Y50 Masde50 
		 */
		
		UEmpleado empleado2= new UEmpleado();
		empleado2.registrarse("Usuario2","Contraseña2","Nombre2","Apellido2","Telefono2",51);
		empleado2.crearTicket("Indistinto", 100000, "CargaMedia", "senior", 51, "ExperienciaMedia", "secundario");
		
		UEmpleado empleado3= new UEmpleado();
		empleado3.registrarse("Usuario3","Contraseña3","Nombre3","Apellido3","Telefono3",53);
		empleado3.crearTicket("Indistinto", 80000, "CargaMedia", "senior", 53, "ExperienciaMedia", "primario");
		
		UEmpleador empleador1= new UEmpleador();
		empleador1.registrarse("Usuario4","Contraseña4","Nombre4","Fisica","Salud");
		empleador1.crearTicket("Indistinto", 180000, "CargaMedia", "Managment",60, "ExperienciaMedia", "secundario",1,1,3,4,5,6,7,8);
		
		UEmpleador empleador2= new UEmpleador();
		empleador1.registrarse("Usuario5","Contraseña5","Nombre5","Juridica","Salud");
		empleador1.crearTicket("Indistinto", 100000, "CargaMedia", "senior", 20, "ExperienciaMedia", "secundario",8,7,6,5,4,3,2,1);
		
		UEmpleador empleador3= new UEmpleador();
		empleador1.registrarse("Usuario6","Contraseña6","Nombre6","Juridica","Salud");
		empleador1.crearTicket("Indistinto", 120000, "CargaMedia", "senior", 25, "ExperienciaMedia", "secundario",2,4,6,8,10,12,14,16);
		
		UAdministrador admin1= new UAdministrador("Mikel","Contra");
		admin1.setV1(15000);
		admin1.rondaEncuentrosLaborales();
		
	/*
		
		
		empleador3.mostrarLista();
		empleador1.mostrarLista();
		empleador2.mostrarLista();
		
		empleado1.mostrarLista();
		empleado2.mostrarLista();
		empleado3.mostrarLista();

		*/
		Agencia.getInstance().Mostrararreglodebug(Agencia.getInstance().getEmpleadosPretensos());
		Agencia.getInstance().Mostrararreglodebug2(Agencia.getInstance().getEmpleadores());
	
	}

	
}
