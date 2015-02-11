package Testing;

import Rationals.ConstructionException;
import Rationals.OperationalException;
import Rationals.Rational;

public class RationalSamples {

	public static void main(String[] args) {
		try {
			
			// R1 //
			Rational r = new Rational(3, 24);
			System.out.println("r = "+r);
			System.out.println("r = "+r.getValue());
			drawDivider();
			// R2 //
			Rational r2 = new Rational(24, -22);
			System.out.println("r2 = "+r2);
			System.out.println("r2 = "+r2.getValue());
			drawDivider();
			// Addition //
			Rational sum = Rational.add(r, r2);
			System.out.println("sum = "+sum);
			System.out.println("sum = "+sum.getValue());
			drawDivider();
			// Division //
			r = new Rational();
			System.out.println("r is now "+r);
			r2.divideBy(r);
			System.out.println("r2 (after being divided by r) = "+r2);
			System.out.println("r2 = "+r2.getValue());
			drawDivider();
			
			
		} catch (ConstructionException e) {
			e.printStackTrace();
		} catch (OperationalException e) {
			System.out.println(" >> Error was hopefully caught. Phew!");
			e.printStackTrace();
		}
		
	}

	
	private static void drawDivider(){
		for(int i=0;i<25;++i) System.out.print("-");
		System.out.println();
	}
}
