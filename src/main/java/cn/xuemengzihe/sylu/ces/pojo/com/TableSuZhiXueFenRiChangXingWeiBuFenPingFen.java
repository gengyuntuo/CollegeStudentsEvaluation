package cn.xuemengzihe.sylu.ces.pojo.com;

/**
 * 素质学分日常行为部分评分表
 * 
 * @author 李春
 * @time 2016年10月23日time上午10:41:55
 */
public class TableSuZhiXueFenRiChangXingWeiBuFenPingFen {
	private Integer id;
	private Integer zonghe; // 综合测评表的ID
	private Double shehuigongde; // 社会公德
	private Double wenmingjiaowang; // 文明交往
	private Double chengxinlishen; // 诚信立身
	private Double tiyuduanlian; // 体育锻炼
	private Double aihugongwu; // 爱护公物
	private Double xuexiaoguiding; // 学校规定
	private Double canjiahuodong; // 参加活动
	private Double tingkejilu; // 听课记录
	private Double gongyujiancha; // 公寓检查
	private Integer isvalid;

	// 关联关系
	private Student student; // 相关联的学生

	public TableSuZhiXueFenRiChangXingWeiBuFenPingFen() {
	}

	public TableSuZhiXueFenRiChangXingWeiBuFenPingFen(Integer id,
			Integer zonghe, Double shehuigongde, Double wenmingjiaowang,
			Double chengxinlishen, Double tiyuduanlian, Double aihugongwu,
			Double xuexiaoguiding, Double canjiahuodong, Double tingkejilu,
			Double gongyujiancha, Student student) {
		super();
		this.id = id;
		this.zonghe = zonghe;
		this.shehuigongde = shehuigongde;
		this.wenmingjiaowang = wenmingjiaowang;
		this.chengxinlishen = chengxinlishen;
		this.tiyuduanlian = tiyuduanlian;
		this.aihugongwu = aihugongwu;
		this.xuexiaoguiding = xuexiaoguiding;
		this.canjiahuodong = canjiahuodong;
		this.tingkejilu = tingkejilu;
		this.gongyujiancha = gongyujiancha;
		this.student = student;
	}

	/**
	 * 返回该表所对应的总成绩
	 * 
	 * @return
	 */
	public Double getTotal() {
		// 计算该表对应的总成绩
		double total = shehuigongde + wenmingjiaowang + chengxinlishen
				+ tiyuduanlian + aihugongwu + xuexiaoguiding + canjiahuodong
				+ tingkejilu + gongyujiancha;
		return total;
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

	public Double getShehuigongde() {
		return shehuigongde;
	}

	public void setShehuigongde(Double shehuigongde) {
		this.shehuigongde = shehuigongde;
	}

	public Double getWenmingjiaowang() {
		return wenmingjiaowang;
	}

	public void setWenmingjiaowang(Double wenmingjiaowang) {
		this.wenmingjiaowang = wenmingjiaowang;
	}

	public Double getChengxinlishen() {
		return chengxinlishen;
	}

	public void setChengxinlishen(Double chengxinlishen) {
		this.chengxinlishen = chengxinlishen;
	}

	public Double getTiyuduanlian() {
		return tiyuduanlian;
	}

	public void setTiyuduanlian(Double tiyuduanlian) {
		this.tiyuduanlian = tiyuduanlian;
	}

	public Double getAihugongwu() {
		return aihugongwu;
	}

	public void setAihugongwu(Double aihugongwu) {
		this.aihugongwu = aihugongwu;
	}

	public Double getXuexiaoguiding() {
		return xuexiaoguiding;
	}

	public void setXuexiaoguiding(Double xuexiaoguiding) {
		this.xuexiaoguiding = xuexiaoguiding;
	}

	public Double getCanjiahuodong() {
		return canjiahuodong;
	}

	public void setCanjiahuodong(Double canjiahuodong) {
		this.canjiahuodong = canjiahuodong;
	}

	public Double getTingkejilu() {
		return tingkejilu;
	}

	public void setTingkejilu(Double tingkejilu) {
		this.tingkejilu = tingkejilu;
	}

	public Double getGongyujiancha() {
		return gongyujiancha;
	}

	public void setGongyujiancha(Double gongyujiancha) {
		this.gongyujiancha = gongyujiancha;
	}

	public Integer getIsvalid() {
		return isvalid;
	}

	public void setIsvalid(Integer isvalid) {
		this.isvalid = isvalid;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "TableSuZhiXueFenRiChangXingWeiBuFenPingFen [id=" + id
				+ ", zonghe=" + zonghe + ", shehuigongde=" + shehuigongde
				+ ", wenmingjiaowang=" + wenmingjiaowang + ", chengxinlishen="
				+ chengxinlishen + ", tiyuduanlian=" + tiyuduanlian
				+ ", aihugongwu=" + aihugongwu + ", xuexiaoguiding="
				+ xuexiaoguiding + ", canjiahuodong=" + canjiahuodong
				+ ", tingkejilu=" + tingkejilu + ", gongyujiancha="
				+ gongyujiancha + ", student=" + student + "]";
	}

}
