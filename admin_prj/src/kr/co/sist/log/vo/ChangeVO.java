package kr.co.sist.log.vo;

public class ChangeVO {
	private String ad_id, pass;

	public ChangeVO() {

	}

	public ChangeVO(String ad_id, String pass) {
		this.ad_id = ad_id;
		this.pass = pass;
	}

	public String getAd_id() {
		return ad_id;
	}

	public void setAd_id(String ad_id) {
		this.ad_id = ad_id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
