package kr.co.sist.rent.domain;

public class Schedual {
	private String resev_num, car_num, id, start_date, end_date, licence_num, right_flag;
	private int num;
	
	public int getNum() {
		return num;
	}

	public void setNum(int rnum) {
		this.num = rnum;
	}

	public String getResev_num() {
		return resev_num;
	}

	public void setResev_num(String resev_num) {
		this.resev_num = resev_num;
	}

	public String getCar_num() {
		return car_num;
	}

	public void setCar_num(String car_num) {
		this.car_num = car_num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getLicence_num() {
		return licence_num;
	}

	public void setLicence_num(String licence_num) {
		this.licence_num = licence_num;
	}

	public String getRight_flag() {
		return right_flag;
	}

	public void setRight_flag(String right_flag) {
		this.right_flag = right_flag;
	}
	
}
