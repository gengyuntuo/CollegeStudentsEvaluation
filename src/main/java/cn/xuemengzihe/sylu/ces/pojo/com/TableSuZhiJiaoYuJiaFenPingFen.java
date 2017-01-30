package cn.xuemengzihe.sylu.ces.pojo.com;

import java.util.List;

/**
 * 素质教育加分评分表
 * 
 * @author 李春
 * @time 2016年10月23日time上午10:35:34
 */
public class TableSuZhiJiaoYuJiaFenPingFen {
	private Integer id;
	private Integer zonghe; // 该表所依赖的综合测评表
	private Double shehuifuwu; // 社会服务
	private Double shehuishijian; // 社会实践
	private Double bisaihuojiang; // 比赛获奖
	private Double xueshengganbu; // 学生干部
	private Integer isvalid; // 标志该表是否有效

	private List<TableSuZhiJiaoYuJiaFenShenQing> tableSZJYJFSQ;// 素质教育加分申请表

	public TableSuZhiJiaoYuJiaFenPingFen() {
	}

	public TableSuZhiJiaoYuJiaFenPingFen(Integer id, Integer zonghe,
			Double shehuifuwu, Double shehuishijian, Double bisaihuojiang,
			Double xueshengganbu, Integer isvalid) {
		this.id = id;
		this.zonghe = zonghe;
		this.shehuifuwu = shehuifuwu;
		this.shehuishijian = shehuishijian;
		this.bisaihuojiang = bisaihuojiang;
		this.xueshengganbu = xueshengganbu;
		this.isvalid = isvalid;
	}

	/**
	 * 返回当前表所对应的总成绩
	 * 
	 * @return
	 */
	public Double getTotal() {
		// 计算表中的总成绩
		// 将所有项加满，总分超过30分将按30分计算
		double total = shehuifuwu + shehuishijian + bisaihuojiang
				+ xueshengganbu;
		return total >= 30 ? 30 : total;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getZonghe() {
		return zonghe;
	}

	public void setZonghe(Integer zonghe) {
		this.zonghe = zonghe;
	}

	public Double getShehuifuwu() {
		return shehuifuwu;
	}

	public void setShehuifuwu(Double shehuifuwu) {
		this.shehuifuwu = shehuifuwu;
	}

	public Double getShehuishijian() {
		return shehuishijian;
	}

	public void setShehuishijian(Double shehuishijian) {
		this.shehuishijian = shehuishijian;
	}

	public Double getBisaihuojiang() {
		return bisaihuojiang;
	}

	public void setBisaihuojiang(Double bisaihuojiang) {
		this.bisaihuojiang = bisaihuojiang;
	}

	public Double getXueshengganbu() {
		return xueshengganbu;
	}

	public void setXueshengganbu(Double xueshengganbu) {
		this.xueshengganbu = xueshengganbu;
	}

	public Integer getIsvalid() {
		return isvalid;
	}

	public void setIsvalid(Integer isvalid) {
		this.isvalid = isvalid;
	}

	public List<TableSuZhiJiaoYuJiaFenShenQing> getTableSZJYJFSQ() {
		return tableSZJYJFSQ;
	}

	public void setTableSZJYJFSQ(
			List<TableSuZhiJiaoYuJiaFenShenQing> tableSZJYJFSQ) {
		this.tableSZJYJFSQ = tableSZJYJFSQ;
	}

	@Override
	public String toString() {
		return "TableSuZhiJiaoYuJiaFenPingFen [id=" + id + ", zonghe=" + zonghe
				+ ", shehuifuwu=" + shehuifuwu + ", shehuishijian="
				+ shehuishijian + ", bisaihuojiang=" + bisaihuojiang
				+ ", xueshengganbu=" + xueshengganbu + ", isvalid=" + isvalid
				+ ", tableSZJYJFSQ=" + tableSZJYJFSQ + "]";
	}

}
