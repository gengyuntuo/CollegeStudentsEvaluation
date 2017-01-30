package cn.xuemengzihe.sylu.ces.pojo.com;

import java.util.Date;
import java.util.List;

/**
 * 素质教育加分评分表
 * 
 * @author 李春
 * @time 2016年10月23日time上午10:35:34
 */
public class TableSZJYJFPF {
	private Integer id;
	private Integer zongHe; // 该表所依赖的综合测评表
	private Double sheHuiFuWu; // 社会服务
	private Double sheHuiShiJian; // 社会实践
	private Double biSaiHuoJiang; // 比赛获奖
	private Double xueShengGanBu; // 学生干部
	private Integer isValid; // 标志该表是否有效
	private Date cTime;
	private Date uTime;

	/**
	 * @see TableSZJYJFSQ
	 */
	private List<TableSZJYJFSQ> tableSZJYJFSQ;// 素质教育加分申请表

	public TableSZJYJFPF() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getZongHe() {
		return zongHe;
	}

	public void setZongHe(Integer zongHe) {
		this.zongHe = zongHe;
	}

	public Double getSheHuiFuWu() {
		return sheHuiFuWu;
	}

	public void setSheHuiFuWu(Double sheHuiFuWu) {
		this.sheHuiFuWu = sheHuiFuWu;
	}

	public Double getSheHuiShiJian() {
		return sheHuiShiJian;
	}

	public void setSheHuiShiJian(Double sheHuiShiJian) {
		this.sheHuiShiJian = sheHuiShiJian;
	}

	public Double getBiSaiHuoJiang() {
		return biSaiHuoJiang;
	}

	public void setBiSaiHuoJiang(Double biSaiHuoJiang) {
		this.biSaiHuoJiang = biSaiHuoJiang;
	}

	public Double getXueShengGanBu() {
		return xueShengGanBu;
	}

	public void setXueShengGanBu(Double xueShengGanBu) {
		this.xueShengGanBu = xueShengGanBu;
	}

	public Integer getIsValid() {
		return isValid;
	}

	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}

	public Date getcTime() {
		return cTime;
	}

	public void setcTime(Date cTime) {
		this.cTime = cTime;
	}

	public Date getuTime() {
		return uTime;
	}

	public void setuTime(Date uTime) {
		this.uTime = uTime;
	}

	public List<TableSZJYJFSQ> getTableSZJYJFSQ() {
		return tableSZJYJFSQ;
	}

	public void setTableSZJYJFSQ(List<TableSZJYJFSQ> tableSZJYJFSQ) {
		this.tableSZJYJFSQ = tableSZJYJFSQ;
	}

	@Override
	public String toString() {
		return "TableSZJYJFPF [id=" + id + ", zongHe=" + zongHe
				+ ", sheHuiFuWu=" + sheHuiFuWu + ", sheHuiShiJian="
				+ sheHuiShiJian + ", biSaiHuoJiang=" + biSaiHuoJiang
				+ ", xueShengGanBu=" + xueShengGanBu + ", isValid=" + isValid
				+ ", cTime=" + cTime + ", uTime=" + uTime + ", tableSZJYJFSQ="
				+ tableSZJYJFSQ + "]";
	}

}
