package prueba;

import java.util.ArrayList;

import capaDeDatos.EmpleadoPretenso;
import capaDeDatos.Empleador;
import capaDeNegocios.Agencia;
import capaDeNegocios.Contratacion;
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
		
		
		UEmpleado empleado1=new UEmpleado();
		empleado1.registrarse("Usuario1","Contraseña1","Nombre1","Apellido1","Telefono1",35);
		empleado1.crearTicket("Home Office", 15001, "CargaExtendida", "Senior", 35, "ExperienciaNada", "Primario");
		
		UEmpleado empleado2= new UEmpleado();
		empleado2.registrarse("Usuario2","Contraseña2","Nombre2","Apellido2","Telefono2",51);
		empleado2.crearTicket("Indistinto", 100000, "CargaMedia", "senior", 51, "ExperienciaMedia", "secundario");
		
		UEmpleado empleado3= new UEmpleado();
		empleado3.registrarse("Usuario3","Contraseña3","Nombre3","Apellido3","Telefono3",53);
		empleado3.crearTicket("Indistinto", 80000, "CargaMedia", "senior", 53, "ExperienciaMedia", "primario");
		
		UEmpleador empleador4= new UEmpleador();
		empleador4.registrarse("Usuario4","Contraseña4","Nombre4","Fisica","Salud");
		empleador4.crearTicket("Indistinto", 180000, "CargaMedia", "Managment",60, "ExperienciaMedia", "secundario",1,1,3,4,5,6,7,8);
		
		UEmpleador empleador5= new UEmpleador();
		empleador5.registrarse("Usuario5","Contraseña5","Nombre5","Juridica","Salud");
		empleador5.crearTicket("Indistinto", 100000, "CargaMedia", "senior", 20, "ExperienciaMedia", "secundario",8,7,6,5,4,3,2,1);
		
		UEmpleador empleador6= new UEmpleador();
		empleador6.registrarse("Usuario6","Contraseña6","Nombre6","Juridica","Salud");
		empleador6.crearTicket("Indistinto", 120000, "CargaMedia", "senior", 25, "ExperienciaMedia", "secundario",2,4,6,8,10,12,14,16);
		
		UEmpleado empleado8= new UEmpleado();
		empleado8.registrarse("Usuario8","Contraseña8","Nombre8","Apellido8","Telefono8",53);
		empleado8.crearTicket("Indistinto", 80000, "CargaMedia", "senior", 53, "ExperienciaMedia", "primario");
		
		UAdministrador admin7= new UAdministrador("Usuario7","Contraseña7");
		admin7.setV1(80000);
		admin7.setV2(350000);
		admin7.setVencimientoTicket(3);
		
		//------------------ RONDA DE ENCUENTROS LABORALES ------------------1
		String nombreArchivo = "Agencia-EmpleadorNadaMas.xml" ;
		Agencia.getInstance().cargarAgencia(nombreArchivo);
		admin7.gatillarRonda();
		
		empleado1.mostrarListaAsignaciones();
		empleador4.mostrarListaAsignaciones();
		
		//testeo del login y logout
		empleador6.logout();
		empleador6.login("Usuario6","Contraseña6");
		
		//testeo de borrado de cuenta
		empleador6.borrarCuenta();

		//El empleado 1 elige al usuario4, luego el usuario 5 pausa su ticket,
		//el empleado 1 lo intenta elegir, luego el usuario 5 se reactiva y el empleado 1 lo elige
		empleado1.elegirUsuario_puntaje("Usuario4");
		empleador5.cambiarEstadoTicket("suspendido");
		empleado1.elegirUsuario_puntaje("Usuario5");
		empleador5.cambiarEstadoTicket("activo");
		empleado1.elegirUsuario_puntaje("Usuario5");
		
		
		//se forman 2 contrataciones 
		empleado1.elegirUsuario_puntaje("Usuario4");
		empleado2.elegirUsuario_puntaje("Usuario5");
		
		empleador4.elegirUsuario_puntaje("Usuario1");
		empleador5.elegirUsuario_puntaje("Usuario2");
		
		empleador5.elegirUsuario_puntaje("Usuario3"); //este deberia no ser contratado
		
		//------------------ RONDA DE CONTRATACIONES  ------------------1
		
		admin7.gatillarRonda();
		
		//ver la lista de contratacion para todos
		admin7.mostrarListaContrataciones();
		empleado1.mostrarListaContrataciones();	
		empleador4.mostrarListaContrataciones();
		empleado8.cambiarEstadoTicket("suspendido");
		//------------------ RONDA DE ENCUENTROS LABORALES ------------------2
		
		admin7.gatillarRonda();
		
		//prueba de cambio de estado para un empleado
		empleador5.mostrarListaAsignaciones();
		empleador5.elegirUsuario_puntaje("Usuario8"); //no deberia poder elegirlo
		empleado8.cambiarEstadoTicket("activo");
		
		//------------------ RONDA DE CONTRATACIONES  ------------------2
		
		admin7.gatillarRonda();
		
		//------------------ RONDA DE ENCUENTROS LABORALES ------------------3
		admin7.gatillarRonda();
		
		
		//------------------ RONDA DE CONTRATACIONES  ------------------3
		
		admin7.gatillarRonda();
				
		//------------------ RONDA DE ENCUENTROS LABORALES ------------------4
		admin7.gatillarRonda();
			
		//------------------ RONDA DE CONTRATACIONES  ------------------4
				
		admin7.gatillarRonda();	
		//------------------ RONDA DE ENCUENTROS LABORALES ------------------5
		admin7.gatillarRonda();
				
				
		//------------------ RONDA DE CONTRATACIONES  ------------------5
				
		admin7.gatillarRonda();
		
		
		ArrayList<Empleador> empleadores;
		ArrayList<EmpleadoPretenso> empleados;
		ArrayList<Contratacion> contrataciones;
		//Agencia.getInstance().guardarAgencia(nombreArchivo);
		empleadores = Agencia.getInstance().getEmpleadores();
		empleados = Agencia.getInstance().getEmpleadosPretensos();
		contrataciones = Agencia.getInstance().getContrataciones();
		System.out.println("asdas");
		
	}
}
