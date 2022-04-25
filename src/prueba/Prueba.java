package prueba;



import java.util.GregorianCalendar;

import agencia.*;
import formulario.Formulario;

public class Prueba {

	public static void main(String[] args) {
		Agencia.getInstance(); //  asi refencias a la agencia, asi podrias llamar a sus metodos desde cualquier lado
		EmpleadoPretenso empleado1= new EmpleadoPretenso("Usuario1","Contraseña1","Nombre1","Apellido1","Telefono1",1);
		//empleado1.login("Usuario1", empleado1.getPassword());
		/**
		 * podemos llamarlo de las 2 maneras, capaz estarua bueno hacer privado getPswd
		 * ya esta hecho el chckeo de que puede hacer las acciones solo si esta logeado? como se maneja eso?
		 */
		empleado1.nuevoTicket(new GregorianCalendar(), new Formulario("Home Office", "HastaV1", "CargaExtendida", "Junior", "Menosde40", "ExperienciaNada", "Primario"));
		/**
		 * Home Office Indistinto Presencial // CargaExtendida CargaCompleta CargaMedia // Primario Secundario Terciario // ExperienciaNada ExperienciaMedia ExperienciaMucha
		 * HastaV1 EntreV1yV2 MasdeV2 // Junior Senior Managment // Menosde40 Entre40Y50 Masde50 
		 */
		
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
		
		
	
	}

	
	
}
