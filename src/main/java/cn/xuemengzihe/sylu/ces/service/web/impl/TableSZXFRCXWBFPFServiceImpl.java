package cn.xuemengzihe.sylu.ces.service.web.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.xuemengzihe.sylu.ces.dao.com.TableSZXFRCXWBFPFDAO;
import cn.xuemengzihe.sylu.ces.pojo.com.TableSZXFRCXWBFPF;
import cn.xuemengzihe.sylu.ces.service.web.TableSZXFRCXWBFPFService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * <h1>素质学分日常行为部分评分表</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年3月28日 下午6:38:21
 */
@Repository
public class TableSZXFRCXWBFPFServiceImpl implements TableSZXFRCXWBFPFService {

	@Autowired
	private TableSZXFRCXWBFPFDAO tableSZXFRCXWBFPFDAO;

	@Override
	public Integer insertRecord(TableSZXFRCXWBFPF record) {
		return tableSZXFRCXWBFPFDAO.insertRecord(record);
	}

	@Override
	public Integer updateRecord(TableSZXFRCXWBFPF record) {
		return tableSZXFRCXWBFPFDAO.updateRecord(record);
	}

	@Override
	public Integer deleteRecord(Integer id) {
		return tableSZXFRCXWBFPFDAO.deleteRecord(id);
	}

	@Override
	public TableSZXFRCXWBFPF getRecordById(Integer id) {
		return tableSZXFRCXWBFPFDAO.getRecordById(id);
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
		PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
		List<Map<String, String>> list = tableSZXFRCXWBFPFDAO
				.getRecordWithMap(conditions);
		pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

}
