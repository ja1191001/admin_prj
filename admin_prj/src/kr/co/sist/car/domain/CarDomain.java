package kr.co.sist.car.domain;

public class CarDomain {
	private String car_num,car_name,assign_num,car_year,able_flag;

	public CarDomain() {
		super();
	}

	public CarDomain(String car_num, String car_name, String assign_num, String car_year, String able_flag) {
		super();
		this.car_num = car_num;
		this.car_name = car_name;
		this.assign_num = assign_num;
		this.car_year = car_year;
		this.able_flag = able_flag;
	}

	public String getCar_num() {
		return car_num;
	}

	public void setCar_num(String car_num) {
		this.car_num = car_num;
	}

	public String getCar_name() {
		return car_name;
	}

	public void setCar_name(String car_name) {
		this.car_name = car_name;
	}

	public String getAssign_num() {
		return assign_num;
	}

	public void setAssign_num(String assign_num) {
		this.assign_num = assign_num;
	}

	public String getCar_year() {
		return car_year;
	}

	public void setCar_year(String car_year) {
		this.car_year = car_year;
	}

	public String getAble_flag() {
		return able_flag;
	}

	public void setAble_flag(String able_flag) {
		this.able_flag = able_flag;
	}

	
	
}
