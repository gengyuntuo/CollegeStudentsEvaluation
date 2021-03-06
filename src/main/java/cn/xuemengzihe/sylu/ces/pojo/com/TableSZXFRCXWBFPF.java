package cn.xuemengzihe.sylu.ces.pojo.com;

import java.util.Date;

/**
 * <h1>素质学分日常行为部分评分表</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年3月28日 下午6:36:12
 */
public class TableSZXFRCXWBFPF {
	private Integer id;
	private Integer zongHeId; // 综合测评表ID
	private Double sheHuiGongDe; // 社会公德
	private Double wenMingJiaoWang; // 文明交往
	private Double chengXinLiShen; // 诚信立身
	private Double tiYuDuanLian; // 体育锻炼
	private Double aiHuGongWu; // 爱护公物
	private Double xueXiaoGuiDing; // 学校规定
	private Double canJiaHuoDong; // 参加活动
	private Double tingKeJiLu; // 听课记录
	private Double gongYuJianCha; // 公寓检查
	private String isValid;
	private Date cTime;
	private Date uTime;

	public TableSZXFRCXWBFPF() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getZongHeId() {
		return zongHeId;
	}

	public void setZongHeId(Integer zongHeId) {
		this.zongHeId = zongHeId;
	}

	public Double getSheHuiGongDe() {
		return sheHuiGongDe;
	}

	public void setSheHuiGongDe(Double sheHuiGongDe) {
		this.sheHuiGongDe = sheHuiGongDe;
	}

	public Double getWenMingJiaoWang() {
		return wenMingJiaoWang;
	}

	public void setWenMingJiaoWang(Double wenMingJiaoWang) {
		this.wenMingJiaoWang = wenMingJiaoWang;
	}

	public Double getChengXinLiShen() {
		return chengXinLiShen;
	}

	public void setChengXinLiShen(Double chengXinLiShen) {
		this.chengXinLiShen = chengXinLiShen;
	}

	public Double getTiYuDuanLian() {
		return tiYuDuanLian;
	}

	public void setTiYuDuanLian(Double tiYuDuanLian) {
		this.tiYuDuanLian = tiYuDuanLian;
	}

	public Double getAiHuGongWu() {
		return aiHuGongWu;
	}

	public void setAiHuGongWu(Double aiHuGongWu) {
		this.aiHuGongWu = aiHuGongWu;
	}

	public Double getXueXiaoGuiDing() {
		return xueXiaoGuiDing;
	}

	public void setXueXiaoGuiDing(Double xueXiaoGuiDing) {
		this.xueXiaoGuiDing = xueXiaoGuiDing;
	}

	public Double getCanJiaHuoDong() {
		return canJiaHuoDong;
	}

	public void setCanJiaHuoDong(Double canJiaHuoDong) {
		this.canJiaHuoDong = canJiaHuoDong;
	}

	public Double getTingKeJiLu() {
		return tingKeJiLu;
	}

	public void setTingKeJiLu(Double tingKeJiLu) {
		this.tingKeJiLu = tingKeJiLu;
	}

	public Double getGongYuJianCha() {
		return gongYuJianCha;
	}

	public void setGongYuJianCha(Double gongYuJianCha) {
		this.gongYuJianCha = gongYuJianCha;
	}

	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
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

	public Double getScore() {
		Double score = this.sheHuiGongDe + this.wenMingJiaoWang
				+ this.chengXinLiShen + this.tiYuDuanLian + this.aiHuGongWu
				+ this.xueXiaoGuiDing + this.canJiaHuoDong + this.tingKeJiLu
				+ this.gongYuJianCha;
		return score;
	}

	@Override
	public String toString() {
		return "TableSZXFRCXWBFPF [id=" + id + ", zongHeId=" + zongHeId
				+ ", sheHuiGongDe=" + sheHuiGongDe + ", wenMingJiaoWang="
				+ wenMingJiaoWang + ", chengXinLiShen=" + chengXinLiShen
				+ ", tiYuDuanLian=" + tiYuDuanLian + ", aiHuGongWu="
				+ aiHuGongWu + ", xueXiaoGuiDing=" + xueXiaoGuiDing
				+ ", canJiaHuoDong=" + canJiaHuoDong + ", tingKeJiLu="
				+ tingKeJiLu + ", gongYuJianCha=" + gongYuJianCha
				+ ", isValid=" + isValid + ", cTime=" + cTime + ", uTime="
				+ uTime + "]";
	}

}
