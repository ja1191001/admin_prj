package kr.co.sist.log.vo;

public class FindPassVO {
	private String name, empno, ad_id;

	public FindPassVO() {

	}

	public FindPassVO(String name, String empno, String ad_id) {
		this.name = name;
		this.empno = empno;
		this.ad_id = ad_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public String getAd_id() {
		return ad_id;
	}

	public void setAd_id(String ad_id) {
		this.ad_id = ad_id;
	}
	
}
