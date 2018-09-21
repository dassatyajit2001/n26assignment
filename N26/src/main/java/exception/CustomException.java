package exception;

public class CustomException extends BaseException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8615397097548133101L;
	
	public CustomException(ExceptionBean exceptionBean) {
		super(exceptionBean);
		
	}

	public CustomException(ExceptionBean exceptionBean, String message) {
		super(exceptionBean,message);
	}
		

	public CustomException(ExceptionBean exceptionBean, String message, Throwable th) {
		super(exceptionBean,message, th);
	
	}

	public CustomException(ExceptionBean exceptionBean, Throwable th) {
		super(exceptionBean,th);
		
	}

}
