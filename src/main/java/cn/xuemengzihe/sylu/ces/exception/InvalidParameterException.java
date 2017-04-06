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

	@Override
	public void printStackTrace() {
		System.err.println("无效参数！");
		super.printStackTrace();
	}

}
