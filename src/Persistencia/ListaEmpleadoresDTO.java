package Persistencia;

import java.util.ArrayList;

public class ListaEmpleadoresDTO {
	private ArrayList<EmpleadorDTO> listaEmpleadores = new ArrayList<EmpleadorDTO>();
	
	public ListaEmpleadoresDTO() {
	}

	public ArrayList<EmpleadorDTO> getListaEmpleadores() {
		return listaEmpleadores;
	}

	public void setListaEmpleadores(ArrayList<EmpleadorDTO> listaEmpleadores) {
		this.listaEmpleadores = listaEmpleadores;
	}
}
