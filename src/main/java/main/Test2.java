package main;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import constants.MediaType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import model.Book;
import service.BookServiceApi;
import spark.Request;
import spark.Response;

@Api()
@Path("")
@Produces("application/json")
public class Test2 {
	
	@GET
	@Path("/books")
	@Produces("application/json")
	@ApiOperation(value = "Get All Books")
	@ApiResponses(value = { //
			@ApiResponse(code = 200, message = "Success", response=Book.class , responseContainer="Array" ),
	})
	public static List<Book> getAllBooks (@ApiParam(hidden = true) Request req,@ApiParam(hidden = true) Response res){
		res.type( MediaType.APPLICATION_JSON ); 
		return BookServiceApi.getAllBooks();
	}

}
