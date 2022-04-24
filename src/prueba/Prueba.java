package prueba;

import agencia.*;

public class Prueba {

	public static void main(String[] args) {
		Agencia.getInstance(); //  asi refencias a la agencia, asi podrias llamar a sus metodos desde cualquier lado
		EmpleadoPretenso empleado1= new EmpleadoPretenso("Usuario1","Contraseña1","Nombre1","Apellido1","Telefono1",1);
		empleado1.login("Usuario1", empleado1.getPassword()); // podemos llamarlo de las 2 maneras, capaz estarua bueno hacer privado getPswd
		
		//ya esta hecho el chckeo de que puede hacer las acciones solo si esta logeado? como se maneja eso?
		
		
	
		

	}

}
