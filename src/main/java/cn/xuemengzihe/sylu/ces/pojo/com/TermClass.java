package cn.xuemengzihe.sylu.ces.pojo.com;

/**
 * <h1>测评包含的班级</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年4月17日 下午4:48:11
 */
public class TermClass {
	private Integer id;
	private Integer termId;
	private Integer classId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTermId() {
		return termId;
	}

	public void setTermId(Integer termId) {
		this.termId = termId;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	@Override
	public String toString() {
		return "TermClass [id=" + id + ", termId=" + termId + ", classId="
				+ classId + "]";
	}

}
