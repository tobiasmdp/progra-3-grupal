package capaDePresentacion;

import javax.swing.AbstractListModel;

import capaDeDatos.EmpleadoPretenso;
import capaDeDatos.Empleador;
import capaDeNegocios.Agencia;

public class ModeloListaEmpleadoBolsaTrabajo extends AbstractListModel{

	@Override
	public int getSize() {
		return Agencia.getInstance().getSimempleadores().size();
	}

	@Override
	public Object getElementAt(int index) {
		EmpleadoPretenso e=Agencia.getInstance().getSimempleado().get(index);
		return e;
	}

}
