package kr.co.sist.car.vo;

public class TypeInsertVO {

	private String car_name,type,fuel,car_option; 
	private int rental_fee,cc;
	
	public TypeInsertVO() {
		super();
	}

	public TypeInsertVO(String car_name, String type, String fuel, String car_option, int rental_fee, int cc) {
		super();
		this.car_name = car_name;
		this.type = type;
		this.fuel = fuel;
		this.car_option = car_option;
		this.rental_fee = rental_fee;
		this.cc = cc;
	}

	public String getCar_name() {
		return car_name;
	}

	public void setCar_name(String car_name) {
		this.car_name = car_name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
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

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	@Override
	public String toString() {
		return "TypeInsertVO [car_name=" + car_name + ", type=" + type + ", fuel=" + fuel + ", car_option=" + car_option
				+ ", rental_fee=" + rental_fee + ", cc=" + cc + "]";
	}
	
	
	
}
