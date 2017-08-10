package kr.co.sist.rent.vo;

public class ScheVO {
	private String start_date, end_date, id;
	private int start_num, end_num;

	public ScheVO() {

	}
	
	public ScheVO(String start_date, String end_date, String id, int start_num, int end_num) {
		this.start_date = start_date;
		this.end_date = end_date;
		this.id = id;
		this.start_num = start_num;
		this.end_num = end_num;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getStart_num() {
		return start_num;
	}

	public void setStart_num(int start_num) {
		this.start_num = start_num;
	}

	public int getEnd_num() {
		return end_num;
	}

	public void setEnd_num(int end_num) {
		this.end_num = end_num;
	}
	
}
