package capaDeNegocios;

import java.util.ArrayList;

import capaDeDatos.PuestoTrabajo;

public class BolsaDeTrabajo {
	private ArrayList<PuestoTrabajo> puestoTrabajos = new ArrayList<PuestoTrabajo>();
	private int cantlocal = 0, cantinternacional = 0, cantsalud = 0;

	public BolsaDeTrabajo() {
	}

	public synchronized void removePuestoTrabajo(PuestoTrabajo nuevo) {
		puestoTrabajos.remove(nuevo);
		notifyAll(); // eliminamos de la bolsa el ticket que tiene un empleado
	}

	public synchronized void putPuestoTrabajoEmpleador(PuestoTrabajo nuevo) {
		nuevo.setEstado("disponible");
		if (nuevo.getRubro().equals("salud"))
			cantsalud += 1;
		else if (nuevo.getRubro().equals("local"))
			cantlocal += 1;
		else
			cantinternacional += 1;
		puestoTrabajos.add(nuevo);
		notifyAll(); // avisamos que hay nuevos tickets en la bolsa
	}

	public synchronized void putPuestoTrabajoEmpleado(PuestoTrabajo nuevo) { // la diferencia que en esete busco el que
																				// habia usado para para cambiarle el
																				// estado
		int i = 0;
		while (i <= puestoTrabajos.size() && !nuevo.equals(puestoTrabajos.get(i))) // siempre lo va a encontrar porque
																					// va a estar
			i++;
		puestoTrabajos.get(i).setEstado("disponible");
		if (nuevo.getRubro().equals("salud"))
			cantsalud += 1;
		else if (nuevo.getRubro().equals("local"))
			cantlocal += 1;
		else
			cantinternacional += 1;
		notifyAll();// avisamos que el ticket en suspenso vuelve a estar disponible
	}

	/**
	 * @param empleado (el empleado va a buscar en la bolsa por rubro el que le
	 *                 gusta)
	 * @return retorna null si no encontro uno que le gustaba, retorna el puesto de
	 *         trabajo si encontro uno
	 * 
	 */
	public synchronized PuestoTrabajo getPuestoTrabajo(EmpleadoSimulado empleado) { // lo que hace este metodo es
																					// recorrer todos los
		int i = 0;
		while (puestoTrabajos.size() == 0) { // si no hay nada en la bolsa, tienen que esperar que se use el put
			try {
				wait();
			} catch (InterruptedException e) {
			}
			;
		}
		if (empleado.getRubro().equals("salud")) // si el que busca esta en 0, quiere decir que no hay ningun ticket
													// disponible
			while (cantsalud == 0) {
				try {
					wait();
				} catch (InterruptedException e) {
				}
				;
			}
		else if (empleado.getRubro().equals("local"))
			while (cantlocal == 0) {
				try {
					wait();
				} catch (InterruptedException e) {
				}
				;
			}
		else if (empleado.getRubro().equals("internacional"))
			while (cantinternacional == 0) {
				try {
					wait();
				} catch (InterruptedException e) {
				}
				;
			}
		while (i <= puestoTrabajos.size() && !puestoTrabajos.get(i).getRubro().equals(empleado.getRubro())
				&& !puestoTrabajos.get(i).getEstado().equals("consulta"))
			i++;

		if (puestoTrabajos.get(i).getRubro().equals("salud"))
			cantsalud -= 1;
		else if (puestoTrabajos.get(i).getRubro().equals("local"))
			cantlocal -= 1;
		else
			cantinternacional -= 1;
		puestoTrabajos.get(i).setEstado("consulta");
		return puestoTrabajos.get(i);
	}
}
