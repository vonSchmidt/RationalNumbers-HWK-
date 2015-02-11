package Testing;

import java.util.Random;

import Matrix.Matrix;
import Rationals.ConstructionException;
import Rationals.OperationalException;
import Rationals.Rational;

public class MatrixSamples {

	public static void main(String[] args) {
		
		Matrix m = null;
		try {
			m = new Matrix(2, 3);
			System.out.println(m);
			
			Matrix z = new Matrix(2, 3);
			Rational x [] = 					{
					new Rational(1,2), new Rational(-1,2), new Rational(1,-2), 
					new Rational(11,5), new Rational(-4,92), new Rational(1,2)
				};
			
			z.fill(x);

			Random r = new Random();
			r.nextInt(2);
			
			System.out.println(z);
			
			Matrix res = Matrix.add(m, z);
			System.out.println(res);
			
			System.out.println("\nAdding z to z:");
			System.out.println(Matrix.add(z,z));
			
			
		} catch (ConstructionException e) {
			e.printStackTrace();
		} catch (OperationalException e) {
			e.printStackTrace();
		}
		
	}

}
