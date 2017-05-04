package cn.xuemengzihe.sylu.ces.controller.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import cn.xuemengzihe.sylu.ces.dao.com.ComplexFunction;
import cn.xuemengzihe.sylu.ces.dao.com.TermClassDAO;
import cn.xuemengzihe.sylu.ces.exception.PermissionDenyException;
import cn.xuemengzihe.sylu.ces.pojo.com.Persion;
import cn.xuemengzihe.sylu.ces.service.web.ClassService;
import cn.xuemengzihe.sylu.ces.service.web.StudentService;
import cn.xuemengzihe.sylu.ces.service.web.TableSZJYJFPFService;
import cn.xuemengzihe.sylu.ces.service.web.TableSZJYJFSQService;
import cn.xuemengzihe.sylu.ces.service.web.TableSZXFRCXWBFPFService;
import cn.xuemengzihe.sylu.ces.service.web.TableZHCPCJTJService;
import cn.xuemengzihe.sylu.ces.service.web.TermService;

/**
 * <h1>班委可以执行的操作</h1>
 * <p>
 * 包含有班委特有的操作，有成绩管理等 <br/>
 * <b>注意：</b>成绩测评相关参见{@link ScoreStatisticController}
 * </p>
 * 
 * @author 李春
 * @time 2017年5月4日 下午4:20:26
 */
@Controller
public class MonitorController {

	@Autowired
	private TermService termService;
	@Autowired
	private ClassService classService;
	@Autowired
	private StudentService studentServcice;
	@Autowired
	private TableSZJYJFSQService tableSZJYJFSQServcie;
	@Autowired
	private TableSZJYJFPFService tableSZJYJFPFService;
	@Autowired
	private TableZHCPCJTJService tableZHCPCJTJServcie;
	@Autowired
	private TableSZXFRCXWBFPFService tableSZXFRCXWBFPFService;
	@Autowired
	private ComplexFunction compexFunction;
	@Autowired
	private TermClassDAO termClassDAO;

	/**
	 * 该方法检验请求本Controller的用户是否为班委，如果不是班委则抛出异常
	 * 
	 * @param request
	 */
	@ModelAttribute
	public void verifyUserRole(HttpServletRequest request) {
		Persion persion = (Persion) request.getSession().getAttribute("user");
		if (persion.getRole() == null) {
			throw new PermissionDenyException();
		}
	}

}
