package cn.xuemengzihe.sylu.ces.util;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * <h1>JSON 工具类</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年3月20日 下午3:44:38
 */
public class JSONUtil {

	/**
	 * 将List&lt;Map&lt;String, String&gt;&gt;类型的集合转化成JSON数据
	 * 
	 * @param list
	 *            集合
	 * @return JSON
	 */
	public static String parseListToJSON(List<Map<String, String>> list) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		Gson gson = new Gson();
		Type type = new TypeToken<Map<String, String>>() {
		}.getType();
		for (Map<String, String> var : list) {
			builder.append(gson.toJson(var, type));
			builder.append(",");
		}
		builder.deleteCharAt(builder.length() - 1); // 删除最后一行的“，”号
		return builder.append("]").toString();
	}
}
