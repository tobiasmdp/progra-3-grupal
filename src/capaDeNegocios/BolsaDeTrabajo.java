package capaDeNegocios;

import java.util.ArrayList;

import capaDeDatos.EmpleadoPretenso;
import capaDeDatos.PuestoTrabajo;

public class BolsaDeTrabajo {
private ArrayList<PuestoTrabajo> puestoTrabajos = new ArrayList<PuestoTrabajo>(); 
	
	public BolsaDeTrabajo() {}

	public synchronized void putPuestoTrabajo(PuestoTrabajo nuevo) {
		puestoTrabajos.add(nuevo);
	}
	
	public synchronized PuestoTrabajo getPuestoTrabajo(EmpleadoPretenso empleado) {
	int i=0;
	PuestoTrabajo aux;
		while (i<puestoTrabajos.size() && !puestoTrabajos.get(i).getRubro().equals(empleado.getRubro()))
			i++;
		if (i!=puestoTrabajos.size()) {
			aux=puestoTrabajos.get(i);
			while (aux.getEstado()==2)
				try {
					wait();
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				};
			if aux.getEstado()
		}
		else
		  aux=null;
		notifyAll();
		return aux; 	
	}
}
	
