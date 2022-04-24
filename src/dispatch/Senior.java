package dispatch;

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
}
