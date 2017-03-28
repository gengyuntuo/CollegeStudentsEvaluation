package cn.xuemengzihe.sylu.ces.service.web.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xuemengzihe.sylu.ces.dao.com.TableSZJYJFSQDAO;
import cn.xuemengzihe.sylu.ces.pojo.com.TableSZJYJFSQ;
import cn.xuemengzihe.sylu.ces.service.web.TableSZJYJFSQService;

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
			PageInfo<Map<String, String>> pageInfo, String conditions) {
		// TODO 分页查询
		return null;
	}

}
