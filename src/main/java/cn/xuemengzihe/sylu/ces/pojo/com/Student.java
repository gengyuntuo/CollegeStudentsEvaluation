package cn.xuemengzihe.sylu.ces.pojo.com;

/**
 * <h1>学生</h1>
 * <p>
 * 学生的POJO，继承自{@link cn.xuemengzihe.sylu.ces.Persion}
 * </p>
 * 
 * @author 李春
 * @创建时间 2016年12月25日 下午3:57:09
 * 
 */
public class Student extends Persion {
	private String sno; // 班级学号
	private Integer clazzId; // 班级ID
	private String dormno; // 寝室楼号
	private String dormInfo; // 寝室号、床位号
	private String politicalStatus; // 政治面貌
	private String bankCard; // 银行卡号
	private String haveLoan; // 是否生源地贷款
	private String havePovertyCertificate; // 是否有贫困证明
	private String fatherName; // 父亲姓名
	private String fatherPhone; // 父亲电话
	private String motherName; // 母亲姓名
	private String motherPhone; // 母亲电话

	private Clazz clazz;

	public Student() {
		super();
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public Integer getClazzId() {
		return clazzId;
	}

	public void setClazzId(Integer clazzId) {
		this.clazzId = clazzId;
	}

	public String getDormno() {
		return dormno;
	}

	public void setDormno(String dormno) {
		this.dormno = dormno;
	}

	public String getDormInfo() {
		return dormInfo;
	}

	public void setDormInfo(String dormInfo) {
		this.dormInfo = dormInfo;
	}

	public String getPoliticalStatus() {
		return politicalStatus;
	}

	public void setPoliticalStatus(String politicalStatus) {
		this.politicalStatus = politicalStatus;
	}

	public String getBankCard() {
		return bankCard;
	}

	public void setBankCard(String bankCard) {
		this.bankCard = bankCard;
	}

	public String getHaveLoan() {
		return haveLoan;
	}

	public void setHaveLoan(String haveLoan) {
		this.haveLoan = haveLoan;
	}

	public String getHavePovertyCertificate() {
		return havePovertyCertificate;
	}

	public void setHavePovertyCertificate(String havePovertyCertificate) {
		this.havePovertyCertificate = havePovertyCertificate;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getFatherPhone() {
		return fatherPhone;
	}

	public void setFatherPhone(String fatherPhone) {
		this.fatherPhone = fatherPhone;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getMotherPhone() {
		return motherPhone;
	}

	public void setMotherPhone(String motherPhone) {
		this.motherPhone = motherPhone;
	}

	public Clazz getClazz() {
		return clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}

	@Override
	public String toString() {
		return "Student [sno=" + sno + ", classId=" + clazzId + ", dormno="
				+ dormno + ", dormInfo=" + dormInfo + ", politicalStatus="
				+ politicalStatus + ", bankCard=" + bankCard + ", haveLoan="
				+ haveLoan + ", havePovertyCertificate="
				+ havePovertyCertificate + ", fatherName=" + fatherName
				+ ", fatherPhone=" + fatherPhone + ", motherName=" + motherName
				+ ", motherPhone=" + motherPhone + ", clazz=" + clazz
				+ super.toString() + "]";
	}
}