package capaDeNegocios;

import java.util.ArrayList;

import capaDeDatos.EmpleadoPretenso;
import capaDeDatos.PuestoTrabajo;

public class BolsaDeTrabajo {
private ArrayList<PuestoTrabajo> puestoTrabajos = new ArrayList<PuestoTrabajo>(); 
	
	public BolsaDeTrabajo() {}

	public synchronized void removePuestoTrabajo(PuestoTrabajo nuevo) {
		puestoTrabajos.remove(nuevo);
		notifyAll(); //eliminamos de la bolsa el ticket que tiene un empleado
	}
	
	public synchronized void putPuestoTrabajoEmpleador(PuestoTrabajo nuevo) {
		nuevo.setEstado(0);
		puestoTrabajos.add(nuevo);
		notifyAll(); //avisamos que hay nuevos tickets en la bolsa
	}
	
	public synchronized void putPuestoTrabajoEmpleado(PuestoTrabajo nuevo) {
	int i=0;
		while (i<=puestoTrabajos.size()) //siempre lo va a encontrar porque va a estar
			i++;
		puestoTrabajos.get(i).setEstado(0);
		notifyAll();//avisamos que el ticket en suspenso vuelve a estar disponible
	}
	

	/**
	 * @param empleado (el empleado va a buscar en la bolsa por rubro el que le gusta)
	 * @return retorna null si no encontro uno que le gustaba, retorna el puesto de trabajo si encontro uno 
	 *  
	 */
	public synchronized PuestoTrabajo getPuestoTrabajo(EmpleadoPretenso empleado) { // lo que hace este metodo es recorrer todos los 
	int i=0;
	PuestoTrabajo aux = null;
	while (puestoTrabajos.size()==0) // si no hay nada en la bolsa, tienen que esperar que se use el put
		try {
			wait();
		}
		catch (InterruptedException e) {
		};	
	while (i<=puestoTrabajos.size() && !puestoTrabajos.get(i).getRubro().equals(empleado.getRubro()))
		i++;
	if (puestoTrabajos.get(i).getRubro().equals(empleado.getRubro())) {
		aux=puestoTrabajos.get(i);
		while (aux.getEstado()==1)
			try {
				wait();
			}
			catch (InterruptedException e) {
			};
		aux.setEstado(1);// si llega a esta parte es porque esta disponible el ticket que le gusto (estado 0), lo pasa a 1 porque lo va a usar
	}
	//no me parece bien que retorne null si no encontro al que queria
	notifyAll();
	return aux; 	
	}
}
	
