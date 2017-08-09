package kr.co.sist.notice.vo;

public class NoticeWriteVO {

	private String id, title, content;
	
	public NoticeWriteVO() {
		// TODO Auto-generated constructor stub
	}

	public NoticeWriteVO(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	
	
}
