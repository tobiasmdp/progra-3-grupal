package capaDeNegocios;

import java.util.ArrayList;
import java.util.Observable;

import capaDeDatos.PuestoTrabajo;

public class EmpleadorSimulado extends Observable implements Runnable {
	private BolsaDeTrabajo bolsa;
	private ArrayList<PuestoTrabajo> mispuestotrabajo = new ArrayList<PuestoTrabajo>();
	private String nombre;
	private String estado;
	public EmpleadorSimulado(String nombreUsuario, BolsaDeTrabajo bolsa) {
		this.nombre = nombreUsuario;
		this.bolsa = bolsa;
	}

	public void nuevosPuestosTrabajos(PuestoTrabajo trabajo) {
		mispuestotrabajo.add(trabajo);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BolsaDeTrabajo getBolsa() {
		return bolsa;
	}

	public void setBolsa(BolsaDeTrabajo bolsa) {
		this.bolsa = bolsa;
	}

	public ArrayList<PuestoTrabajo> getMispuestotrabajo() {
		return mispuestotrabajo;
	}

	public void setMispuestotrabajo(ArrayList<PuestoTrabajo> mispuestotrabajo) {
		this.mispuestotrabajo = mispuestotrabajo;
	}

	public void run() {
		for (int i=0; i<mispuestotrabajo.size();i++) {
			bolsa.putPuestoTrabajoEmpleador(mispuestotrabajo.get(i));
			this.estado=this.nombre +" publico un puesto de trabajo con Locacion: "+ this.mispuestotrabajo.get(i).getLocacion()+ " Rubro:"+ this.mispuestotrabajo.get(i).getRubro();
			setChanged();
			notifyObservers("EstadoEmpleador");
			Util.espera();
		}
	}
	public String getEstado() {
		return estado;
	}

	@Override
	public String toString() {
		return "Bolsa=" + bolsa + ", Mispuestotrabajo=" + mispuestotrabajo + ", Nombre=" + nombre
				+ ", Estado=" + estado + "]";
	}
	
}
