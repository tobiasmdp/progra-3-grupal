package capaDeNegocios;

import java.util.ArrayList;

import capaDeDatos.EmpleadoPretenso;
import capaDeDatos.PuestoTrabajo;

public class BolsaDeTrabajo {
private ArrayList<PuestoTrabajo> puestoTrabajos = new ArrayList<PuestoTrabajo>(); 
	
	public BolsaDeTrabajo() {}

	public void removePuestoTrabajo(PuestoTrabajo nuevo) {
		puestoTrabajos.remove(nuevo);
	}
	
	public synchronized void putPuestoTrabajo(PuestoTrabajo nuevo) {
		puestoTrabajos.add(nuevo);
	}
	

	/**
	 * @param empleado (el empleado va a buscar en la bolsa por rubro el que le gusta)
	 * @return retorna null si la bolsa esta vacia o no encontro uno que le gustaba, retorna el puesto de trabajo si encontro uno 
	 */
	public synchronized PuestoTrabajo getPuestoTrabajo(EmpleadoPretenso empleado) { // lo que hace este metodo es recorrer todos los 
	int i=0;
	PuestoTrabajo aux;
		while (i<puestoTrabajos.size() && !puestoTrabajos.get(i).getRubro().equals(empleado.getRubro()))
			i++;
		if (i!=puestoTrabajos.size()) {
			aux=puestoTrabajos.get(i);
			while (aux.getEstado()==1)
				try {
					wait();
				}
				catch (InterruptedException e) {
				};
			// si llega a esta parte es porque esta disponible el ticket que le gusto (estado 0)
			if (aux.getLocacion().equals(empleado.getLocacion()))
				removePuestoTrabajo(aux);
			else 
				aux=null;
		}
		else
		  aux=null; //no parece estar bien este null
		notifyAll();
		return aux; 	
	}
}
	
