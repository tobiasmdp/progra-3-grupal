package prueba;

import capaDeNegocios.Agencia;
import capaDePresentacion.UAdministrador;
import capaDePresentacion.UEmpleado;
import capaDePresentacion.UEmpleador;

public class Prueba {

	public static void main(String[] args) {
		//UAdministrador admin1= new UAdministrador("Mikel","Contra");
		//admin1.setV1(15000);
		
		/*ORDEN DE LOS ATRIBUTOS
		 * Home Office Indistinto Presencial // CargaExtendida CargaCompleta CargaMedia // Primario Secundario Terciario // ExperienciaNada ExperienciaMedia ExperienciaMucha
		 * HastaV1 EntreV1yV2 MasdeV2 // Junior Senior Managment // Menosde40 Entre40Y50 Masde50 
		 */
		
		Agencia.getInstance();
		UEmpleado empleado1=new UEmpleado();
		empleado1.registrarse("Usuario1","Contraseña1","Nombre1","Apellido1","Telefono1",35);
		empleado1.crearTicket("Home Office", 15001, "CargaExtendida", "Senior", 35, "ExperienciaNada", "Primario");

		
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
		empleador2.registrarse("Usuario5","Contraseña5","Nombre5","Juridica","Salud");
		empleador2.crearTicket("Indistinto", 100000, "CargaMedia", "senior", 20, "ExperienciaMedia", "secundario",8,7,6,5,4,3,2,1);
		
		UEmpleador empleador3= new UEmpleador();
		empleador3.registrarse("Usuario6","Contraseña6","Nombre6","Juridica","Salud");
		empleador3.crearTicket("Indistinto", 120000, "CargaMedia", "senior", 25, "ExperienciaMedia", "secundario",2,4,6,8,10,12,14,16);
		
		//testeo del login y logout
		empleador3.logout();
		empleador3.login("Usuario7","Contraseña6");
		
		//testeo de borrado de cuenta
		empleador3.borrarCuenta();
		
		UAdministrador admin1= new UAdministrador("Mikel","Contra");
		admin1.setV1(15000);
		admin1.rondaEncuentrosLaborales();
		
		empleado1.mostrarListaAsignaciones();
		empleado2.mostrarListaAsignaciones();
		
		

		empleado1.elegirUsuario_puntaje("Usuario5");
		empleado1.elegirUsuario_puntaje("Usuario4");
		empleado2.elegirUsuario_puntaje("Usuario6");
		
		empleador1.elegirUsuario_puntaje("Usuario1");
		empleador2.elegirUsuario_puntaje("Usuario3");
		empleador2.elegirUsuario_puntaje("Usuario2");
		
		admin1.rondaContrataciones();
		admin1.mostrarListaContrataciones();
		empleado1.mostrarListaContrataciones();
		empleador1.mostrarListaContrataciones();
		
		
		//Agencia.getInstance().Mostrararreglodebug(Agencia.getInstance().getEmpleadosPretensos());
		//Agencia.getInstance().Mostrararreglodebug2(Agencia.getInstance().getEmpleadores());
	
	}

	
}
