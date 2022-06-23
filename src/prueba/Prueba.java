package prueba;

<<<<<<< HEAD
import capaDeNegocios.Agencia;
import capaDePresentacion.ControladorSistema;
import capaDePresentacion.UAdministrador;
import capaDePresentacion.UEmpleado;
import capaDePresentacion.UEmpleador;
=======


import java.util.GregorianCalendar;

import agencia.*;
import formulario.Formulario;
>>>>>>> 82225852a058ccbc322004c7f559462455d4ff81

public class Prueba {

	public static void main(String[] args) {
<<<<<<< HEAD
		
		Agencia.getInstance();

		//------------------ CARGA DE VARIABLES ------------------
		
		/*ORDEN DE LOS ATRIBUTOS
=======
		Agencia.getInstance(); //  asi refencias a la agencia, asi podrias llamar a sus metodos desde cualquier lado
		EmpleadoPretenso empleado1= new EmpleadoPretenso("Usuario1","Contraseña1","Nombre1","Apellido1","Telefono1",1);
		//empleado1.login("Usuario1", empleado1.getPassword());
		/**
		 * podemos llamarlo de las 2 maneras, capaz estarua bueno hacer privado getPswd
		 * ya esta hecho el chckeo de que puede hacer las acciones solo si esta logeado? como se maneja eso?
		 */
		empleado1.nuevoTicket(new GregorianCalendar(), new Formulario("Home Office", "HastaV1", "CargaExtendida", "Junior", "Menosde40", "ExperienciaNada", "Primario"));
		/**
>>>>>>> 82225852a058ccbc322004c7f559462455d4ff81
		 * Home Office Indistinto Presencial // CargaExtendida CargaCompleta CargaMedia // Primario Secundario Terciario // ExperienciaNada ExperienciaMedia ExperienciaMucha
		 * HastaV1 EntreV1yV2 MasdeV2 // Junior Senior Managment // Menosde40 Entre40Y50 Masde50 
		 */
		
<<<<<<< HEAD
		//cada instancia de una sub clase de Usuario se llamara = nombre-de-la-clase + nro de usuario
		//el usuario numero 10 si es empleado, se llamara empleado10
		
		UEmpleado empleado=(UEmpleado)Agencia.getInstance().registroEmpleado("1","1");
		UAdministrador admin=(UAdministrador)Agencia.getInstance().registroAdministrador("pepe", "pepe");
		Agencia.getInstance().crearTicketEmpleado("Indistinto", 80000, "CargaMedia", "senior", 53, "ExperienciaMedia", "primario",empleado);
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
=======
		EmpleadoPretenso empleado2= new EmpleadoPretenso("Usuario2","Contraseña2","Nombre2","Apellido2","Telefono2",2);
		//empleado2.login("Usuario2", empleado2.getPassword());
		empleado2.nuevoTicket(new GregorianCalendar(), 
				new Formulario("Indistinto", "HastaV1", "CargaMedia", "senior", "masde50", "ExperienciaMedia", "secundario"));
		
		EmpleadoPretenso empleado3= new EmpleadoPretenso("Usuario3","Contraseña3","Nombre3","Apellido3","Telefono3",3);
		//empleado3.login("Usuario3", empleado3.getPassword());
		empleado3.nuevoTicket(new GregorianCalendar(), 
				new Formulario("Indistinto", "HastaV1", "CargaMedia", "senior", "masde50", "ExperienciaMedia", "terciario"));
		
		
		Empleador empleador1= new Empleador("Usuario4","Contraseña4","Nombre4","Fisica","Salud");
		//empleador4.login("Usuario4", empleador4.getPassword());
		empleador1.nuevoTicket(new GregorianCalendar(), 
				new Formulario("Indistinto", "HastaV1", "CargaMedia", "senior", "masde50", "ExperienciaMedia", "secundario"),"activo",1,2,3,4,5,6,7,8);
		
		Empleador empleador2= new Empleador("Usuario5","Contraseña5","Nombre5","Juridica","Salud");
		//empleador5.login("Usuario5", empleador5.getPassword());
		empleador2.nuevoTicket(new GregorianCalendar(), 
				new Formulario("Indistinto", "HastaV1", "CargaMedia", "senior", "masde50", "ExperienciaMedia", "secundario"),"activo",8,7,6,5,4,3,2,1);
		
		Empleador empleador3= new Empleador("Usuario6","Contraseña6","Nombre6","Juridica","Salud");
		//empleador6.login("Usuario6", empleador6.getPassword());
		empleador3.nuevoTicket(new GregorianCalendar(), 
				new Formulario("Indistinto", "HastaV1", "CargaMedia", "senior", "masde50", "ExperienciaMedia", "secundario"),"activo",2,4,6,8,10,12,14,16);
			
		
		
		Agencia.getInstance().rondaEncuentrosLaborales();
		
		empleador3.mostrarLista();
		empleador1.mostrarLista();
		empleador2.mostrarLista();
		empleado1.mostrarLista();
		empleado2.mostrarLista();
		empleado3.mostrarLista();
		
	
	}

	
	
>>>>>>> 82225852a058ccbc322004c7f559462455d4ff81
}
