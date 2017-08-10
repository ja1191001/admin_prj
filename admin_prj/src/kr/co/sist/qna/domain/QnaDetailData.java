package kr.co.sist.qna.domain;

public class QnaDetailData {
	private String id,title,content,qnum,answer_flag,ad_id,answer;

	public String getId() {
		return id;
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

	public void setId(String id) {
		this.id = id;
	}

	public String getAnswer_flag() {
		return answer_flag;
	}

	public void setAnswer_flag(String answer_flag) {
		this.answer_flag = answer_flag;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getQnum() {
		return qnum;
	}

	public void setQnum(String qnum) {
		this.qnum = qnum;
	}

}
