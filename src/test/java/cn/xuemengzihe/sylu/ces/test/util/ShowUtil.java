package cn.xuemengzihe.sylu.ces.test.util;

import java.util.List;

/**
 * <h1>单元测试：显示工具</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年3月19日 上午11:18:57
 */
public class ShowUtil {
	/**
	 * 显示List集合
	 * 
	 * @param list
	 */
	@SuppressWarnings("rawtypes")
	public static void showList(List list) {
		System.out.println("*******************Start********************");
		for (int i = 0; i < list.size(); i++) {
			System.out.println("List Item :" + list.get(i));
		}
		System.out.println("*******************Stop*********************");
	}
}
