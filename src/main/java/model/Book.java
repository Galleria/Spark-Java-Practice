package model;

public class Book {
	
	private String id;
	private String topic;
	private String category;
	private Boolean status;
	
	public Book() {
		super();
	}

	public Book(String id, String topic, String category, Boolean status) {
		super();
		this.id = id;
		this.topic = topic;
		this.category = category;
		this.status = status;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
}
