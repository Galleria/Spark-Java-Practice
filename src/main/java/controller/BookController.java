package controller;

import service.BookServiceApi;
import spark.Request;
import spark.Response;
import spark.Route;


public class BookController {

	public static Route getAllBooks = (Request req,Response res) -> {
		return BookServiceApi.getAllBooks();
	};
	
	public static Route getBookById = (Request req,Response res) -> {
		String id = req.params(":id");
		return BookServiceApi.getBookById( id );
	};
	
	public static Route getBookByStatus = (Request req,Response res) -> {
		Boolean status = Boolean.parseBoolean( req.params(":status") );
		return BookServiceApi.getBookByStatus( status );
	};
	
	public static Route addBook = (Request req,Response res) -> {
		String json = req.body();
		return BookServiceApi.addBook( json );
	};
	
	public static Route updateBookById = (Request req,Response res) -> {
		String id = req.params(":id");
		String json = req.body();
		return BookServiceApi.updateBookById( id , json );
	};
	
	public static Route updateBookStatusById = (Request req,Response res) -> {
		String id = req.params(":id");
		Boolean status = Boolean.parseBoolean( req.params(":status") );
		return BookServiceApi.updateBookStatusById( id , status );
	};
	
	public static Route deleteBookById = (Request req,Response res) -> {
		String id = req.params(":id");
		return BookServiceApi.deleteBookById( id ) ? "success" : "failed";
	};
}
