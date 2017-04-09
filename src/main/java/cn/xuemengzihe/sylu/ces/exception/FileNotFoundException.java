package cn.xuemengzihe.sylu.ces.exception;

/**
 * <h1>用户文件下载时发生的异常：文件未找到或者是请求的文件非法</h1>
 * <p>
 * 触发该异常的原因： <br/>
 * &nbsp; &nbsp; 1.&nbsp;服务器中未包含该文件<br/>
 * &nbsp; &nbsp; 2.&nbsp;该文件路径中包含(..)等可能会造成突破服务器文件安全访问限制的路径
 * </p>
 * 
 * @author 李春
 * @time 2017年4月8日 下午7:12:13
 */
public class FileNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6433373099004729788L;

}
