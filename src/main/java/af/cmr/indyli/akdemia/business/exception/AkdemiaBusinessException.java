package af.cmr.indyli.akdemia.business.exception;
/**
 * This exception class represents a custom business exception specific to the
 * Akdemia application. It extends the standard Exception class and provides
 * constructors to create exceptions with a message and an optional cause.
 */
public class AkdemiaBusinessException extends Exception {

	/**
	 * Constructs a new AkdemiaBusinessException with the specified detail message
	 * and cause.
	 *
	 * @param message The detail message (which is saved for later retrieval by the
	 *                getMessage() method)
	 * @param cause   The cause (which is saved for later retrieval by the
	 *                getCause() method)
	 */
	public AkdemiaBusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructs a new AkdemiaBusinessException with the specified detail message.
	 *
	 * @param message The detail message (which is saved for later retrieval by the
	 *                getMessage() method)
	 */
	public AkdemiaBusinessException(String message) {

		super(message);
	}
}
