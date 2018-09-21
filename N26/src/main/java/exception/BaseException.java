package exception;

public abstract class BaseException extends RuntimeException {

	private static final long serialVersionUID = -1615786387433147253L;
	private ExceptionBean exceptionBean;

	/**
	 * @return the exceptionBean
	 */
	public ExceptionBean getExceptionBean() {
		return exceptionBean;
	}

	/**
	 * @param exceptionBean
	 *            the exceptionBean to set
	 */
	public void setExceptionBean(ExceptionBean exceptionBean) {
		this.exceptionBean = exceptionBean;
	}

	public BaseException(ExceptionBean exceptionBean) {
		super();
		this.exceptionBean = exceptionBean;
	}

	public BaseException(ExceptionBean exceptionBean, String message) {
		super(message);
		this.exceptionBean = exceptionBean;
	}

	public BaseException(ExceptionBean exceptionBean, String message, Throwable th) {
		super(message, th);
		this.exceptionBean = exceptionBean;
	}

	public BaseException(ExceptionBean exceptionBean, Throwable th) {
		super(th);
		this.exceptionBean = exceptionBean;
	}

}
