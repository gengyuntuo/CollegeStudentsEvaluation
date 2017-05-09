package cn.xuemengzihe.sylu.ces.exception;

/**
 * <h1>异常：无效参数</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年4月6日 下午5:45:08
 */
public class InvalidParameterException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 183483976585779443L;

	public InvalidParameterException() {
		super();
	}

	public InvalidParameterException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidParameterException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidParameterException(String message) {
		super(message);
	}

	public InvalidParameterException(Throwable cause) {
		super(cause);
	}

	@Override
	public void printStackTrace() {
		System.err.println("无效参数！");
		super.printStackTrace();
	}

}
