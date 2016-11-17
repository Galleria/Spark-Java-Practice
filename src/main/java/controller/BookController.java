package controller;

import java.util.List;

import com.google.gson.Gson;

import model.Book;
import service.BookApiService;
import spark.Request;
import spark.Response;
import spark.Route;


public class BookController {
	
	private BookApiService bookApiService;
	private Gson gson = new Gson();
	
	public BookController(){
		bookApiService = new BookApiService();
	}
	
	public BookController(BookApiService bookApiService){
		this.bookApiService = bookApiService;
	}

	public Route getAllBooks = (Request req,Response res) -> {
		return bookApiService.getAllBooks();
	};
	
	public Route getBookById = (Request req,Response res) -> {
		String id = req.params(":id");
		return bookApiService.getBookById( id );
	};
	
	public Route getBookByStatus = (Request req,Response res) -> {
		Boolean status = Boolean.parseBoolean( req.params(":status") );
		System.out.println( req.params(":status") );
		return bookApiService.getBookByStatus( status );
	};
	
	public Route addBook = (Request req,Response res) -> {
		String json = req.body();
		Book book = gson.fromJson(json, Book.class);
		return bookApiService.addBook( book );
	};
	
	public Route updateBookById = (Request req,Response res) -> {
		String id = req.params(":id");
		String json = req.body();
		Book book = gson.fromJson(json, Book.class);
		return bookApiService.updateBookById( id , book );
	};
	
	public Route updateBookStatusById = (Request req,Response res) -> {
		String id = req.params(":id");
		Boolean status = Boolean.parseBoolean( req.params(":status") );
		return bookApiService.updateBookStatusById( id , status );
	};
	
	public Route deleteBookById = (Request req,Response res) -> {
		String id = req.params(":id");
		boolean success = bookApiService.deleteBookById( id );
		if( !success ){
			res.header("404", "Book not found");
		}else{
			res.header("200", "Success");
		}
		return success ? "success" : "failed";
	};
}
