package Ex8;

public class Board {
	
		
	private int id;
	private String title;
	private String content;
	private String writer;
	
	public Board(int id, String title, String content, String writer) {
		
		this.id = id;
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
	
	public String getContent() {
		
		return content;
	}
	
	public int getId() {
		
		return id;
	}

	public String getTitle() {
		
		return title;
	}

	public String getWriter() {
		
		return writer;
	}

	public void setContent(String newContent) {
		
		content = newContent;
	}
	
	
	
}
