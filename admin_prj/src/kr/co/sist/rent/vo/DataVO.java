package kr.co.sist.rent.vo;

public class DataVO {
	private String start_date, end_date, type, fuel;

	public DataVO() {

	}

	public DataVO(String start_date, String end_date, String type, String fuel) {
		this.start_date = start_date;
		this.end_date = end_date;
		this.type = type;
		this.fuel = fuel;
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

	@Override
	public String toString() {
		return "DataVO [start_date=" + start_date + ", end_date=" + end_date + ", type=" + type + ", fuel=" + fuel
				+ "]";
	}
	
}
