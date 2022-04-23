package dispatch;

public class Masde50 implements RangoEtario{
    
	public double compara(RangoEtario otracaract) {
		return otracaract.comparaMasde50();
	}
	
	public double comparaMenor40() {
		return -1;
	}
	
	public double comparaEntre40y50() {
		return -0.5;
	}
	
	public double comparaMasde50() {
		return 1;
	}

}

