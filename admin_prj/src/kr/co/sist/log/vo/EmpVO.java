package kr.co.sist.log.vo;

public class EmpVO {
	private String ad_id, pass, name, empno;

	public EmpVO() {

	}

	public EmpVO(String ad_id, String pass, String name, String empno) {
		this.ad_id = ad_id;
		this.pass = pass;
		this.name = name;
		this.empno = empno;
	}

	public String getAd_id() {
		return ad_id;
	}

	public void setAd_id(String ad_id) {
		this.ad_id = ad_id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
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
	
}
