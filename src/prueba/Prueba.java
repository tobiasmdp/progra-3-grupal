package prueba;

import java.util.GregorianCalendar;

import agencia.*;
import formulario.Formulario;

public class Prueba {

	public static void main(String[] args) {
		Agencia.getInstance(); //  asi refencias a la agencia, asi podrias llamar a sus metodos desde cualquier lado
		EmpleadoPretenso empleado1= new EmpleadoPretenso("Usuario1","Contraseña1","Nombre1","Apellido1","Telefono1",1);
		empleado1.login("Usuario1", empleado1.getPassword());
		/**
		 * podemos llamarlo de las 2 maneras, capaz estarua bueno hacer privado getPswd
		 * ya esta hecho el chckeo de que puede hacer las acciones solo si esta logeado? como se maneja eso?
		 */
		empleado1.nuevoTicket(new GregorianCalendar(), 
				new Formulario("Home Office", "CargaExtendida", "Primario", "ExperienciaNada", "HastaV1", "Junior", "Menosde40"));
		/**
		 * Home Office Indistinto Presencial // CargaExtendida CargaCompleta CargaMedia // Primario Secundario Terciario // ExperienciaNada ExperienciaMedia ExperienciaMucha
		 * HastaV1 EntreV1yV2 MasdeV2 // Junior Senior Managment // Menosde40 Entre40Y50 Masde50 
		 */
		
		EmpleadoPretenso empleado2= new EmpleadoPretenso("Usuario2","Contraseña2","Nombre2","Apellido2","Telefono2",2);
		empleado2.login("Usuario2", empleado2.getPassword());
		empleado2.nuevoTicket(new GregorianCalendar(), 
				new Formulario("Indistinto", "CargaCompleta", "Secundario", "ExperienciaMedia", "EntreV1yV2", "Senior", "Entre40Y50"));
		
		EmpleadoPretenso empleado3= new EmpleadoPretenso("Usuario3","Contraseña3","Nombre3","Apellido3","Telefono3",3);
		empleado3.login("Usuario3", empleado3.getPassword());
		empleado3.nuevoTicket(new GregorianCalendar(), 
				new Formulario("Presencial", "CargaMedia", "Terciario", "ExperienciaMucha", "MasdeV2", "Managment", "Masde50"));
		
		
		EmpleadoPretenso empleador4= new EmpleadoPretenso("Usuario4","Contraseña4","Nombre4","Apellido4","Telefono4",4);
		empleador4.login("Usuario4", empleador4.getPassword());
		empleador4.nuevoTicket(new GregorianCalendar(), 
				new Formulario("Home Office", "CargaExtendida", "Primario", "ExperienciaNada", "HastaV1", "Junior", "Menosde40"));
		
		EmpleadoPretenso empleador5= new EmpleadoPretenso("Usuario5","Contraseña5","Nombre5","Apellido5","Telefono5",5);
		empleador5.login("Usuario5", empleador5.getPassword());
		empleador5.nuevoTicket(new GregorianCalendar(), 
				new Formulario("Indistinto", "CargaCompleta", "Secundario", "ExperienciaMedia", "EntreV1yV2", "Senior", "Entre40Y50"));
		
		EmpleadoPretenso empleador6= new EmpleadoPretenso("Usuario6","Contraseña6","Nombre6","Apellido6","Telefono6",6);
		empleador6.login("Usuario6", empleador6.getPassword());
		empleador6.nuevoTicket(new GregorianCalendar(), 
				new Formulario("Presencial", "CargaMedia", "Terciario", "ExperienciaMucha", "MasdeV2", "Managment", "Masde50"));
			
		
		
		Agencia.getInstance().rondaEncuentrosLaborales();
		
		
	
	}

	
	
}
