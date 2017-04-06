package cn.xuemengzihe.sylu.ces.exception;

/**
 * <h1>异常：缺少参数</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年4月6日 下午5:45:22
 */
public class MissingParameterException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3672416334376777912L;

	@Override
	public void printStackTrace() {
		System.err.println("缺少参数！");
		super.printStackTrace();
	}

}
