package comisiones;

public class Salud implements IRubro{

	@Override
	public double comisionFisica() {
		return 0.6;
	}

	@Override
	public double comisionJuridica() {
		return 0.8;
	}


	@Override
	public String toString() {
		return "Salud";
	}

	
}
