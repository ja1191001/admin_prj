package kr.co.sist.notice.domain;

public class NoticeData {
	private int num ;
	private String title, hiredate, content, notice_num;

	
	
	public String getNotice_num() {
		return notice_num;
	}
	public void setNotice_num(String notice_num) {
		this.notice_num = notice_num;
	}
	public String getTitle() {
		return title;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "NoticeData [num=" + num + ", title=" + title + ", hiredate=" + hiredate + ", content=" + content + "]";
	}
	
	
	
	
}
