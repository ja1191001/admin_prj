package kr.co.sist.qna.vo;

public class UpdateQnaVO {
	private String ad_id,answer,qnum;

	public UpdateQnaVO() {
		super();
	}

	public UpdateQnaVO(String ad_id, String answer, String qnum) {
		super();
		this.ad_id = ad_id;
		this.answer = answer;
		this.qnum = qnum;
	}

	public String getAd_id() {
		return ad_id;
	}

	public void setAd_id(String ad_id) {
		this.ad_id = ad_id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getQnum() {
		return qnum;
	}

	public void setQnum(String qnum) {
		this.qnum = qnum;
	}
	
	
}
