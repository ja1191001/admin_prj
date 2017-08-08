package kr.co.sist.notice.vo;

public class NoticeModifyVO {

	private String notice_num, title, id, content;

	public NoticeModifyVO() {
		// TODO Auto-generated constructor stub
	}
	
	public NoticeModifyVO(String notice_num, String title, String id, String content) {
		super();
		this.notice_num = notice_num;
		this.title = title;
		this.id = id;
		this.content = content;
	}

	public String getNotice_num() {
		return notice_num;
	}

	public void setNotice_num(String notice_num) {
		this.notice_num = notice_num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
