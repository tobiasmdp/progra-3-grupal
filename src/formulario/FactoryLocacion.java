package formulario;

public class FactoryLocacion {
	public static Locacion getLocacion(String tipo) {
		Locacion respuesta = null;
		if (tipo.equalsIgnoreCase("Home Office"))
			respuesta = new HomeOffice();
		else if (tipo.equalsIgnoreCase("Indistinto"))
			respuesta = new Indistinto();
		else if (tipo.equalsIgnoreCase("Presencial"))
			respuesta = new Presencial();
		return respuesta;
	}
}
