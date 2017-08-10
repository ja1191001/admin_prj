package kr.co.sist.rent.domain;

public class RentAble {
	private String car_num,car_name,car_year,type,fuel,images,start_date,end_date;
	private int rental_fee;
	
	public int getRental_fee() {
		return rental_fee;
	}

	public void setRental_fee(int rental_fee) {
		this.rental_fee = rental_fee;
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

	public String getCar_year() {
		return car_year;
	}

	public void setCar_year(String car_year) {
		this.car_year = car_year;
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

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
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

	@Override
	public String toString() {
		return "RentAble [car_num=" + car_num + ", car_name=" + car_name + ", car_year=" + car_year + ", type=" + type
				+ ", fuel=" + fuel + ", images=" + images + ", start_date=" + start_date + ", end_date=" + end_date
				+ ", rental_fee=" + rental_fee + "]";
	}
	
}
