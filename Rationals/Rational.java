package Rationals;

/**
 * An instance of this class is used
 * to represent a Rational number.
 * 
 * 
 * @author (@zshulu) Bruno Farjallah
 *  
 */
public class Rational {

    private int p, q;
    private double value;
    
    /**
     * Creates a new Rational number.
     * <p>
     * This constructor creates a Rational 
     * number with the following attributes.
     * @param  p - the numerator
     * @param  q - the denominator
     * @throws ConstructionException if denominator has a zero value
     * @see {@link ConstructionException}
     */
    public Rational(int p, int q) throws ConstructionException {
        if(q == 0)
            throw new ConstructionException("Denominator cannot be zero");
        this.p = p;
        this.q = q;
        this.value = (double)p/q;
        this.reduce();
        this.fixSign();
    }
    
    /**
     * Creates a new Rational number.
     * (More specifically a relative integer)
     * <p>
     * This constructor creates a Rational 
     * number, that has 1 as denominator.
     * Therefore it creates an integer. 
     * @param  n - the value of the number
     * @throws ConstructionException - if denominator has a zero value
     * @see {@link ConstructionException}
     */
	public Rational(int n) throws ConstructionException {
    	this(n,1);
    }
    
    /**
     * Creates a new Zeroed Rational number.
     * <p>
     * This constructor creates a Zero value
     * Rational number. 
     * @throws ConstructionException if denominator has a zero value
     * @see {@link ConstructionException}
     */
    public Rational() throws ConstructionException {
    	this(0,1);
    }
    
    
    /**
     * Fixes the sign for the Rational number.
     */
    private void fixSign() {
    	if(p*q > 0){
    		p=Math.abs(p); q=Math.abs(q);
    	}
    	else{
    		p=-Math.abs(p); q=Math.abs(q);
    	}
    }
    
    /**
     * Returns the sum of two Rational numbers.
     * 
     * @param  a - a Rational number
     * @param  b - a Rational number
     * @return the Rational number 
     * that is the sum of a and b 
     * @throws ConstructionException if denominator has a zero value
     * @see {@link ConstructionException}
     */
    public static Rational add(Rational a, Rational b) throws ConstructionException{
    	return new Rational(a.p*b.q+b.p*a.q, a.q*b.q);
    }

    /**
     * Adds a Rational number to
     * the invoking Rational.
     * 
     * @param  a - a Rational number
     * @throws ConstructionException if denominator has a zero value
     * @see {@link ConstructionException}
     */
    public void add(Rational a) throws ConstructionException{
    	Rational x = add(a, this);
    	this.p = x.p; this.q = x.q;
    	this.value = x.value;
    }
    
    /**
     * Returns the difference between two Rational numbers.
     * <p>
     * @param  a - a Rational number
     * @param  b - a Rational number
     * @return the Rational number 
     * that is the difference between a and b 
     * @throws ConstructionException if denominator has a zero value
     * @see {@link ConstructionException}
     */
    public static Rational subtract(Rational a, Rational b) throws ConstructionException{
    	return new Rational(a.p*b.q-b.p*a.q, a.q*b.q);
    }
    
    /**
     * Subtracts a Rational number from
     * the invoking Rational.
     * 
     * @param  a - a Rational number
     * @throws ConstructionException if denominator has a zero value
     * @see {@link ConstructionException}
     */
    public void subtract(Rational a) throws ConstructionException{
    	Rational x = subtract(this, a);
    	this.p = x.p; this.q = x.q;
    	this.value = x.value;
    }
    
    /**
     * Returns the product of two Rational numbers.
     * <p>
     * @param  a - a Rational number
     * @param  b - a Rational number
     * @return the Rational number 
     * that is the product of a and b 
     * @throws ConstructionException if denominator has a zero value
     * @see {@link ConstructionException}
     */
    public static Rational multiply(Rational a, Rational b) throws ConstructionException{
    	return new Rational(a.p*b.p, a.q*b.q);
    }
    
    /**
     * Multiplies the invoking Rational
     * by a Rational number.
     * 
     * @param  a - a Rational number
     * @throws ConstructionException if denominator has a zero value
     * @see {@link ConstructionException}
     */
    public void multiplyBy(Rational a) throws ConstructionException{
    	Rational x = multiply(a, this);
    	this.p = x.p; this.q = x.q;
    	this.value = x.value;
    }
    
    /**
     * Returns the quotient of the division
     * of two Rational numbers.
     * <p>
     * @param  a - a Rational number
     * @param  b - a Rational number
     * @return the Rational number 
     * that is the quotient of the
     * division of a and b 
     * @throws ConstructionException if denominator has a zero value
     * @throws OperationalException if b is equal to zero
     * @see {@link ConstructionException}
     * @see {@link OperationalException}
     */
    public static Rational divide(Rational a, Rational b)
    		throws ConstructionException, OperationalException{
    	if(b.p == 0) throw new OperationalException("Cannot divide by zero.");
    	else return new Rational(a.p*b.q, a.q*b.p);
    }
    
    /**
     * Divides the invoking Rational
     * by a Rational number.
     * 
     * @param  a - a Rational number
     * @throws ConstructionException if denominator has a zero value
     * @throws OperationalException if the divisor has a zero value
     * @see {@link ConstructionException}
     * @see {@link OperationalException}
     */
    public void divideBy(Rational a) throws ConstructionException, OperationalException{
    	Rational x = divide(this, a);
    	this.p = x.p; this.q = x.q;
    	this.value = x.value;
    }
    
    /**
     * @return the decimal value of a Rational number 
     */
    public double getValue(){ return value; }
    
    /**
     * @return the numerator of a Rational number 
     */
    public int getNumerator(){ return p; }
    
    /**
     * @return the denominator of a Rational number 
     */
    public int getDenominator(){ return q; }
    
    /**
     * Reduces the Rational number.
     */
	public void reduce(){
		if(p == 0) return;
		int gcd = getGCD(Math.abs(p), Math.abs(q));
		p/=gcd;
		q/=gcd;
	}

	 /**
	  * Inverts the Rational number.
	  * <p>
	  * If the Rational number is p/q,
	  * it becomes q/p.
	  * @throws ConstructionException if numerator is zero
	  * @see {@link ConstructionException}
      */
	public void invert() throws ConstructionException{
		if(this.p == 0) 
			throw new ConstructionException
			("Could not invert Rational since numerator is zero.");
		int tmp = this.p;
		this.p = this.q;
		this.q = tmp;
		this.fixSign();
	}
	
	 /**
      * Negates a Rational number.
      * <p>
      * If the Rational number is p/q,
      * it becomes -p/q.
      */
	public void negate(){
		p = -p;
		fixSign();
	}
	
	 /**
	  * Computes the GCD of two integers.
	  * @param  a - an integer
	  * @param  b - an integer
     * @return the GCD of a and b
     */
	private int getGCD(int a, int b) {
		while(a!=b){
			if(a>b) a=a-b;
			else b=b-a;
		}
		return a;
	}
	
	 /**
     * Overrides java.lang.Object.equals(Object).
     * <p>
     * Checks that two Rational numbers are identical.
     * @param o - Object
     * @return true if invoking Rational is identical
     * to o
     */
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Rational)) return false;
		Rational x = (Rational)o;
		return (x.p == p && x.q == q);
	}
	
	 /**
     * Overrides java.lang.Object.toString().
     * <p>
     * @return a fractional representation
     * of a Rational number
     */
	@Override
	public String toString(){
		String S;
		if(q != 1)
			S = p+"/"+q;
		else
			S = String.valueOf(p);
		return S;
	}
}