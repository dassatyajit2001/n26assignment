package exception;

public class ExceptionBean {

	public ExceptionBean()
	{
		super();
	}
	
	private String exceptionCode;
	private String exceptionMessage;
	
	public ExceptionBean(String exceptionCode, String exceptionMessage) {
		super();
		this.exceptionCode = exceptionCode;
		this.exceptionMessage = exceptionMessage;
	}
	public ExceptionBean(String exceptionMessage) {
		super();
		this.exceptionMessage = exceptionMessage;
	}
	/**
	 * @return the exceptionCode
	 */
	public String getExceptionCode() {
		return exceptionCode;
	}
	/**
	 * @param exceptionCode the exceptionCode to set
	 */
	public ExceptionBean setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
		return this;
	}
	/**
	 * @return the exceptionMessage
	 */
	public String getExceptionMessage() {
		return exceptionMessage;
	}
	/**
	 * @param exceptionMessage the exceptionMessage to set
	 */
	public ExceptionBean setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
		return this;
	}
}
