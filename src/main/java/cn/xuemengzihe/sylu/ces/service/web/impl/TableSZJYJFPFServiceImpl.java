package cn.xuemengzihe.sylu.ces.service.web.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.xuemengzihe.sylu.ces.dao.com.TableSZJYJFPFDAO;
import cn.xuemengzihe.sylu.ces.pojo.com.TableSZJYJFPF;
import cn.xuemengzihe.sylu.ces.service.web.TableSZJYJFPFService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * <h1>素质教育加分评分表</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年3月28日 下午6:39:02
 */
@Repository
public class TableSZJYJFPFServiceImpl implements TableSZJYJFPFService {
	@Autowired
	private TableSZJYJFPFDAO tableSZJYJFPFDAO;

	@Override
	public Integer insertRecord(TableSZJYJFPF record) {
		return tableSZJYJFPFDAO.insertRecord(record);
	}

	@Override
	public Integer updateRecord(TableSZJYJFPF record) {
		return tableSZJYJFPFDAO.updateRecord(record);
	}

	@Override
	public Integer deleteRecord(Integer id) {
		return tableSZJYJFPFDAO.deleteRecord(id);
	}

	@Override
	public TableSZJYJFPF getRecordById(Integer id) {
		return tableSZJYJFPFDAO.getRecordById(id);
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
		// 分页查询
		if (pageInfo != null)
			PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
		List<Map<String, String>> list = tableSZJYJFPFDAO
				.getRecordWithMap(conditions);
		pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

}
