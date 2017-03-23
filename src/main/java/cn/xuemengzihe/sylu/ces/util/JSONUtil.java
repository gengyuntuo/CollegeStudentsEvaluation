package cn.xuemengzihe.sylu.ces.util;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
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
		if (list == null || list.size() == 0) {
			return builder.append("]").toString();
		}
		for (Map<String, String> var : list) {
			builder.append(gson.toJson(var, type));
			builder.append(",");
		}
		builder.deleteCharAt(builder.length() - 1); // 删除最后一行的“，”号
		return builder.append("]").toString();
	}

	/**
	 * 将PageInfo对象转化成带分页信息的JSON数据
	 * 
	 * @param pageInfo
	 *            PageInfo 对象
	 * @return JSON
	 */
	public static String parsePageInfoToJSON(
			PageInfo<Map<String, String>> pageInfo) {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"total\":");
		builder.append(pageInfo.getTotal());
		builder.append(",\"rows\": [");
		if (pageInfo.getList() == null || pageInfo.getList().size() <= 0) {
			return builder.append("]}").toString();
		}
		Gson gson = new Gson();
		Type type = new TypeToken<Map<String, String>>() {
		}.getType();
		for (Map<String, String> var : pageInfo.getList()) {
			builder.append(gson.toJson(var, type));
			builder.append(",");
		}
		builder.deleteCharAt(builder.length() - 1); // 删除最后一行的“，”号
		return builder.append("]}").toString();
	}
}
