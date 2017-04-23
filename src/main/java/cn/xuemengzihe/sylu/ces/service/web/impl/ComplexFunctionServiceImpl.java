package cn.xuemengzihe.sylu.ces.service.web.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xuemengzihe.sylu.ces.dao.com.ComplexFunction;
import cn.xuemengzihe.sylu.ces.service.web.ComplexFunctionService;

import com.github.pagehelper.PageInfo;

/**
 * <h1></h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年4月23日 上午11:57:28
 */
@Service
public class ComplexFunctionServiceImpl implements ComplexFunctionService {

	@Autowired
	private ComplexFunction complexFunction;

	@Override
	public PageInfo<Map<String, String>> getReceiver(
			PageInfo<Map<String, String>> pageInfo, String search,
			String classId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer createZHCPTJ(String termId, String stuId) {
		Map<String, String> params = new HashMap<>();
		params.put("termId", termId);
		params.put("stuId", stuId);
		return complexFunction.createZHCPTJ(params);
	}

}
