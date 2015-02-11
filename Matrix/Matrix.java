package Matrix;

import Rationals.OperationalException;
import Rationals.Rational;
import Rationals.ConstructionException;

/**
 * An instance of this class is used
 * to represent a Matrix of Rational
 * numbers.
 * 
 * 
 * @author (@zshulu) Bruno Farjallah
 *  
 */
public class Matrix {

	private int rows, columns;
	public int getRows() {
		return rows;
	}

	/**
	 * Get the number of columns in
	 * a Matrix.
	 */
	public int getColumns() {
		return columns;
	}

	private Rational matrix [][];
	
	/**
	 * Fills the Matrix with an
	 * array of Rational numbers.
	 * @param x - Rational[]
	 * @throws ConstructionException if there is
	 * a size mismatch between the array and the
	 * Matrix
	 * @see {@link ConstructionException}
	 */
	public void fill(Rational x []) throws ConstructionException{
		if(x.length != rows*columns)
			throw new ConstructionException("Size Mismatch!");
		int k = 0;
		for(int i=0; i<rows;i++)
			for(int j=0; j<columns; j++, k++)
				matrix[i][j] = x[k];
	}
	
	/**
     * Creates a new Matrix of
     * Rational numbers.
     * <p>
     * This constructor creates a Matrix of 
     * Rational numbers with the following
     * attributes.
     * @param  rows - the number of rows
     * @param  cols - the number of columns
     * @throws ConstructionException if any denominator has a zero value
     * @see {@link ConstructionException}
     */
	public Matrix(int rows, int cols) throws ConstructionException{
		matrix = new Rational[rows][cols];
		this.rows = rows; this.columns = cols;
		for(int i=0; i<rows;i++)
			for(int j=0; j<columns; j++)
				matrix[i][j] = new Rational();
	}
	
	/**
     * Returns the sum of two Matrix objects.
     * 
     * @param  a - a Matrix object
     * @param  b - a Matrix object
     * @return the Matrix object 
     * that is the sum of a and b 
     * @throws ConstructionException if any denominator has a zero value
     * @throws OperationalException if there is a size mismatch between
     * a and b
     * @see {@link ConstructionException}
     * @see {@link OperationalException}
     */
	public static Matrix add(Matrix a, Matrix b) throws OperationalException, ConstructionException{
		if(a.rows != b.rows || a.columns != b.columns) 
			throw new OperationalException
			("Cannot add size unmatched Matrixes");
		Matrix result = new Matrix(a.rows, a.columns);
		for(int i=0; i<a.rows;i++)
			for(int j=0; j<a.columns; j++)
				result.matrix[i][j] = Rational.add(a.matrix[i][j], b.matrix[i][j]);
		return result;
	}
	
	/**
     * Overrides java.lang.Object.toString().
     * <p>
     * @return a representation of a Matrix object 
     */
	@Override
	public String toString(){
		// ⌉⌊|
		String e = "";
		String d = "";
		int i = 0;
		for(;i<6;i++)
			d+=" ";
		for(i=0;i<columns;i++)
			e+=d;
		
		String s = "⌈"+e+"   ⌉\n";
		for(Rational[] row : matrix){
			s += "|";
			for(Rational r : row){
				s+=String.format("%6s", r);
			}
			s+="   "+"|\n";
		}
		
		return s+"⌊"+e+"   ⌋\n";
	}
	
	/**
     * Overrides java.lang.Object.equals(Object).
     * <p>
     * Checks that two Matrix objects are identical.
     * @param o - Object
     * @return true if invoking Matrix is identical
     * to o
     */
	@Override
	public boolean equals(Object o){
		if(!(o instanceof Matrix)) return false;
		Matrix tmp = (Matrix)o;
		if(!(tmp.columns == columns && tmp.rows == rows)) return false;
		for(int i=0; i<rows; i++)
			for(int j=0; j<columns; j++)
				if(tmp.matrix[i][j] != matrix[i][j])
					return false;
		return true;
	}
}
