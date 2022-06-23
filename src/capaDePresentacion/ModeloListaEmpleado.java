package capaDePresentacion;

import javax.swing.AbstractListModel;

import capaDeDatos.EmpleadoPretenso;
import capaDeNegocios.Agencia;

public class ModeloListaEmpleado extends AbstractListModel{

	@Override
	public int getSize() {
		return Agencia.getInstance().getEmpleadores().size();
	}

	@Override
	public Object getElementAt(int index) {
		EmpleadoPretenso e=Agencia.getInstance().getEmpleadosPretensos().get(index);
		return e;
	}

}
