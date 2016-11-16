package constants;

public enum BookApi {
	GET_ALL_BOOKS("/books"),
	GET_BOOK_BY_ID("/books/:id"),
	GET_BOOK_BY_STATUS("books/stock/:status"),
	ADD_BOOK("/books"),
	UPDATE_BOOK_BY_ID("/books/:id"),
	UPDATE_BOOK_STATUS_BY_ID("/books/:id/stock/:status"),
	DETELE_BOOK_BY_ID("/books/:id/delete");
	
	private String path;

	public String getPath() {
		return path;
	}

	private BookApi(String path) {
		this.path = path;
	}
	
}
