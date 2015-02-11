package Rationals;

/**
 * An instance of this class is used
 * to represent a Operational error.
 * <p>
 * Thrown when an attempt of erroneous
 * mathematical operation has occurred. 
 * For example, trying to divide by a 
 * zeroed {@link Rational}.
 * @author (@zshulu) Bruno Farjallah
 */
public class OperationalException extends Exception {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructs a {@link OperationalException}
	 * with the default detail message.
	 * @param message
	 */
	public OperationalException(){ super(); }
	
	/**
	 * Constructs a {@link OperationalException}
	 * with the specified detail message.
	 * @param message
	 */
	public OperationalException(String message) {
		super(message);
	}
	
	/**
	 * Constructs a new {@link OperationalException}
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
	public OperationalException(Throwable cause){
		super(cause);
	}
}
