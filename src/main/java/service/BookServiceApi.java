package service;
import static spark.Spark.get;

public class BookServiceApi {
	public void BookController(){
		get("/books", (req, res) -> "all books");
		get("/book/:search", (req, res) -> req.params(":search"));
	}
}
