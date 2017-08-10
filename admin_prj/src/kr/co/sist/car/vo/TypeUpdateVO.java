package kr.co.sist.car.vo;

public class TypeUpdateVO {


	private String car_name1,type,type1,fuel,fuel1,car_option; 
	private int rental_fee,rental_fee1,cc,cc1;
	public TypeUpdateVO() {
		super();
	}
	public TypeUpdateVO(String car_name1, String type, String type1, String fuel, String fuel1, String car_option,
			int rental_fee, int rental_fee1, int cc, int cc1) {
		super();
		this.car_name1 = car_name1;
		this.type = type;
		this.type1 = type1;
		this.fuel = fuel;
		this.fuel1 = fuel1;
		this.car_option = car_option;
		this.rental_fee = rental_fee;
		this.rental_fee1 = rental_fee1;
		this.cc = cc;
		this.cc1 = cc1;
	}
	public String getCar_name1() {
		return car_name1;
	}
	public void setCar_name1(String car_name1) {
		this.car_name1 = car_name1;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType1() {
		return type1;
	}
	public void setType1(String type1) {
		this.type1 = type1;
	}
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	public String getFuel1() {
		return fuel1;
	}
	public void setFuel1(String fuel1) {
		this.fuel1 = fuel1;
	}
	public String getCar_option() {
		return car_option;
	}
	public void setCar_option(String car_option) {
		this.car_option = car_option;
	}
	public int getRental_fee() {
		return rental_fee;
	}
	public void setRental_fee(int rental_fee) {
		this.rental_fee = rental_fee;
	}
	public int getRental_fee1() {
		return rental_fee1;
	}
	public void setRental_fee1(int rental_fee1) {
		this.rental_fee1 = rental_fee1;
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	public int getCc1() {
		return cc1;
	}
	public void setCc1(int cc1) {
		this.cc1 = cc1;
	}
	@Override
	public String toString() {
		return "TypeUpdateVO [car_name1=" + car_name1 + ", type=" + type + ", type1=" + type1 + ", fuel=" + fuel
				+ ", fuel1=" + fuel1 + ", car_option=" + car_option + ", rental_fee=" + rental_fee + ", rental_fee1="
				+ rental_fee1 + ", cc=" + cc + ", cc1=" + cc1 + "]";
	}
	
	
	
}
