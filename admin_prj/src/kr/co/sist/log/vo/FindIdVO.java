package kr.co.sist.log.vo;

public class FindIdVO {
	private String name, empno;

	public FindIdVO() {

	}

	public FindIdVO(String name, String empno) {
		this.name = name;
		this.empno = empno;
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
