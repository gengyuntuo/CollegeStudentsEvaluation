package cn.xuemengzihe.sylu.ces.service.web.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.xuemengzihe.sylu.ces.dao.com.TableZHCPCJTJDAO;
import cn.xuemengzihe.sylu.ces.pojo.com.TableZHCPCJTJ;
import cn.xuemengzihe.sylu.ces.service.web.TableZHCPCJTJService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * <h1>综合成绩统计表</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年3月28日 下午6:38:56
 */
@Repository
public class TableZHCPCJTJServiceImpl implements TableZHCPCJTJService {

	@Autowired
	private TableZHCPCJTJDAO tableZHCPCJTJDAO;

	@Override
	public Integer insertRecord(TableZHCPCJTJ record) {
		return tableZHCPCJTJDAO.insertRecord(record);
	}

	@Override
	public Integer updateRecord(TableZHCPCJTJ record) {
		return tableZHCPCJTJDAO.updateRecord(record);
	}

	@Override
	public Integer deleteRecord(Integer id) {
		return tableZHCPCJTJDAO.deleteRecord(id);
	}

	@Override
	public TableZHCPCJTJ getRecordById(Integer id) {
		return tableZHCPCJTJDAO.getRecordById(id);
	}

	@Override
	public PageInfo<Map<String, String>> getRecordWithMap(
			PageInfo<Map<String, String>> pageInfo, String termId,
			String classId, String sno, String order) {
		Map<String, String> conditions = new HashMap<>();
		conditions.put("termId", termId);
		conditions.put("classId", classId);
		conditions.put("sno", sno);
		conditions.put("order", order);
		if (pageInfo != null)
			PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
		List<Map<String, String>> list = tableZHCPCJTJDAO
				.getRecordWithMap(conditions);
		pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

}
