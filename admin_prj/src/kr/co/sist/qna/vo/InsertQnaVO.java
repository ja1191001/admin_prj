package kr.co.sist.qna.vo;

public class InsertQnaVO {
	
	private String id,title,content;

	/**
	 * 
	 */
	public InsertQnaVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param title
	 * @param content
	 */
	public InsertQnaVO(String id, String title, String content) {
		super();
		this.id = id;
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
