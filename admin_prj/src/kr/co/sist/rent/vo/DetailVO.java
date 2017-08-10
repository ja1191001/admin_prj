package kr.co.sist.rent.vo;

public class DetailVO {
	private String car_num,start_date, end_date;

	public DetailVO() {
	
	}

	public DetailVO(String car_num, String start_date, String end_date) {
		this.car_num = car_num;
		this.start_date = start_date;
		this.end_date = end_date;
	}

	public String getCar_num() {
		return car_num;
	}

	public void setCar_num(String car_num) {
		this.car_num = car_num;
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
	
}
