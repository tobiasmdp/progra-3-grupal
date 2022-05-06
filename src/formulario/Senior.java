package formulario;

public class Senior  implements TipodePuesto{
		
		public double compara(TipodePuesto otracaract) {
			return otracaract.comparaSenior();
		}
		
		public double comparaJunior() {
			return 0.5;
		}

		public double comparaSenior() {
			return 1;
		}

		public double comparaManagment() {
			return 0.5;
		}
		//junior.comparo(senior)=-0,5

		@Override
		public String toString() {
			return "Senior";
		}

		@Override
		public double calculaComision() {
			return 0.9;
		}
}
