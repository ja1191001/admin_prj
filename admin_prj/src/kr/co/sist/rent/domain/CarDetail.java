package kr.co.sist.rent.domain;

public class CarDetail {
	private String car_num,car_name,car_year,type,fuel,car_option,images,start_date,end_date,assign_num;
	private int rental_fee,cc,duration;
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
	public String getCar_option() {
		return car_option;
	}
	public void setCar_option(String car_option) {
		this.car_option = car_option;
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
	public String getAssign_num() {
		return assign_num;
	}
	public void setAssign_num(String assign_num) {
		this.assign_num = assign_num;
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
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
}
