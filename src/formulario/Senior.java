package formulario;
<<<<<<< HEAD
/**
 *<br>
 *La clase Senior es parte del patron Double Dispatch para la categoria del formulario TipodePuesto
 */
=======

>>>>>>> 82225852a058ccbc322004c7f559462455d4ff81
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
<<<<<<< HEAD

		@Override
		public double calculaComision() {
			return 0.9;
		}
=======
>>>>>>> 82225852a058ccbc322004c7f559462455d4ff81
}
