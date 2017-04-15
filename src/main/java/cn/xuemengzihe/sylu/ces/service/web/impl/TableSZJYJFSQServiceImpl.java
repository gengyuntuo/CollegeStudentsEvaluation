package cn.xuemengzihe.sylu.ces.service.web.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xuemengzihe.sylu.ces.dao.com.TableSZJYJFSQDAO;
import cn.xuemengzihe.sylu.ces.pojo.com.TableSZJYJFSQ;
import cn.xuemengzihe.sylu.ces.service.web.TableSZJYJFSQService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * <h1>素质教育加分申请表</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年3月28日 下午6:03:46
 */
@Service
public class TableSZJYJFSQServiceImpl implements TableSZJYJFSQService {

	@Autowired
	private TableSZJYJFSQDAO tableSZJYJFSQDAO;

	@Override
	public Integer insertRecord(TableSZJYJFSQ record) {
		record.setcTime(new Date());
		record.setIsValid("Y");
		record.setuTime(new Date());
		return tableSZJYJFSQDAO.insertRecord(record);
	}

	@Override
	public Integer updateRecord(TableSZJYJFSQ record) {
		return tableSZJYJFSQDAO.updateRecord(record);
	}

	@Override
	public Integer deleteRecord(Integer id) {
		return tableSZJYJFSQDAO.deleteRecord(id);
	}

	@Override
	public TableSZJYJFSQ getRecordById(Integer id) {
		return tableSZJYJFSQDAO.getRecordById(id);
	}

	@Override
	public PageInfo<Map<String, String>> getRecordWithMap(
			PageInfo<Map<String, String>> pageInfo, String termId, String sno) {
		Map<String, String> conditions = new HashMap<>();
		conditions.put("sno", sno);
		conditions.put("id", termId);
		// 分页查询
		PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
		List<Map<String, String>> list = tableSZJYJFSQDAO
				.getRecordWithMap(conditions);
		pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

}
