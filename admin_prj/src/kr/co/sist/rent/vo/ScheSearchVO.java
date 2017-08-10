package kr.co.sist.rent.vo;

public class ScheSearchVO {
	private String start_date, end_date, id;

	public ScheSearchVO() {
		super();
	}

	public ScheSearchVO(String start_date, String end_date, String id) {
		this.start_date = start_date;
		this.end_date = end_date;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	

}
