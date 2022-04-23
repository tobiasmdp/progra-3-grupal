package paquete;

import agencia.Agencia;

public class EmpleadoPretenso extends Usuario {
	private String datosPersonales;

	public EmpleadoPretenso(String nombreUsuario, String contra, String datosPersonales) {
		super(nombreUsuario, contra);
		Agencia.getInstance().addEmpleadoPretenso(this);
		this.datosPersonales = datosPersonales;
	}

	
	public EmpleadoPretenso registro(String nombreUsuario,String contra) {
		Agencia.getInstance().addEmpleadoPretenso(this);
		return new Empleador(nombreUsuario,contra);
	}

	public String getDatosPersonales() {
		return datosPersonales;
	}


	public void setDatosPersonales(String datosPersonales) {
		this.datosPersonales = datosPersonales;
	}


	@Override
	public void actualizarPuntaje() {
		/*
		por cada Ticket finalizado suma 50 puntos
 		por no ser elegido por ningún empleado pretenso resta 20 puntos.
 		por ser primero en la Lista de Empleadores suma 10 puntos por cada una.
		*/
	}

	@Override
	public double calcularComisiones() {
		return tPersona.calcularComisiones(rubro);
	}

}