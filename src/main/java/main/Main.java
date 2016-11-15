package main;

import static spark.Spark.before;
import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.put;
import static spark.debug.DebugScreen.enableDebugScreen;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;

import constants.BookApi;
import constants.CommonApi;
import constants.MediaType;
import constants.Wording;
import controller.CommonController;
import io.swagger.annotations.Contact;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import model.Message;
import utilies.SwaggerParser;

@SwaggerDefinition(
	host = "localhost:8083",
	info = @Info(
			description = "Books API", 
			title = "Books Api for testing", 
			version = "V0.1",
			contact = @Contact(name = "Supachai", url = "github.io")
	),
	schemes = { SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS },
	consumes = { "application/json" },
	produces = { "application/json" },
	tags = { @Tag(name = "swagger") }
)
public class Main {

	public static void main(String[] args) throws JsonProcessingException {
		port(8083);
		enableDebugScreen();
		
		//new BeforeFilter();
		//new AfterFilter();
		before( new CorsFilter() );
		
		BookApi();
		JsonApi();
		CommonApi();
		
		final String swaggerJson = SwaggerParser.getSwaggerJson("main");
		get("/swagger", (req, res) -> {
			return swaggerJson;
		});
		
		FinalApi();
	}
	
	private static void BookApi(){
		get( BookApi.GET_ALL_BOOKS.getPath() , ( req, res ) -> Test2.getAllBooks ( req, res ) , new Gson()::toJson );
		/*
		get( BookApi.GET_ALL_BOOKS.getPath() , BookController.getAllBooks , new Gson()::toJson );
		get( BookApi.GET_BOOK_BY_ID.getPath() , BookController.getBookById , new Gson()::toJson );
		get( BookApi.GET_BOOK_BY_STATUS.getPath() , BookController.getBookByStatus , new Gson()::toJson );
		put( BookApi.UPDATE_BOOK_BY_ID.getPath() , BookController.updateBookById , new Gson()::toJson );
		put( BookApi.UPDATE_BOOK_STATUS_BY_ID.getPath() , BookController.updateBookStatusById , new Gson()::toJson );
		post( BookApi.ADD_BOOK.getPath() , BookController.addBook , new Gson()::toJson );
		delete( BookApi.DETELE_BOOK_BY_ID.getPath() , BookController.deleteBookById );
		*/
	}
	
	private static void CommonApi(){
		get( CommonApi.GET_FAVICON.getPath() ,  CommonController.getFavicon );
		post( CommonApi.STOP_SERVICE.getPath() , CommonController.stopService );
	}
	
	private static void JsonApi(){
		get( "/hello/json" , MediaType.APPLICATION_JSON , (req, res) -> {
			return new Message("Hello Json Format");
		}, new Gson()::toJson);
	}
	
	private static void FinalApi(){
		get("*",(req, res) -> {
			return Wording.BAD_REQUEST_SERVICE;
		});
		post("*",(req, res) -> {
			return Wording.BAD_REQUEST_SERVICE;
		});
		put("*",(req, res) -> {
			return Wording.BAD_REQUEST_SERVICE;
		});
		delete("*",(req, res) -> {
			return Wording.BAD_REQUEST_SERVICE;
		});
	}

}
