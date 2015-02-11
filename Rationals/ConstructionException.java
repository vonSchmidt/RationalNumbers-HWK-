package Rationals;


/**
 * An instance of this class is used
 * to represent a Construction error.
 * <p>
 * Thrown when an attempt of constructing
 * a mathematical object has occurred. 
 * For example, trying to create a 
 * {@link Rational} with a zeroed
 * denominator.
 * @author (@zshulu) Bruno Farjallah
 */
public class ConstructionException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a {@link ConstructionException}
	 * with the specified detail message.
	 * @param message
	 */
	public ConstructionException(String message){
		super(message);
	}

	/**
	 * Constructs a {@link ConstructionException}
	 * with the default detail message.
	 * @param message
	 */
	public ConstructionException(){
		super();
	}

	/**
	 * Constructs a new {@link ConstructionException}
	 * with the specified cause and a detail message
	 * of (cause==null ? null : cause.toString())
	 * (which typically contains the class and detail 
	 * message of cause). This constructor is 
	 * useful for exceptions that are little more
	 * than wrappers for other throwables
	 * (for example, PrivilegedActionException).
	 * @param cause - the cause (which is saved for 
	 * later retrieval by the Throwable.getCause() 
	 * method). (A null value is permitted, and 
	 * indicates that the cause is nonexistent
	 * or unknown.)
	 * @see {@link Throwable}
	 */
	public ConstructionException(Throwable cause){
		super(cause);
	}

}
