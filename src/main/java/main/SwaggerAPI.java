package main;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import model.Book;

@Api( value="Book api" )
@Path("/")
public class SwaggerAPI {

	@GET
	@Path("books")
	@Produces("application/json")
	@ApiOperation(value = "get all books")
	@ApiResponses(value = { //
			@ApiResponse(code = 200, message = "Success", response=Book.class , responseContainer="Array" ),
	})
	public void getAllBooks (){

	}
	
	@GET
	@Path("books/{id}")
	@Produces("application/json")
	@ApiOperation(value = "get book by id")
	@ApiResponses(value = { //
			@ApiResponse(code = 200, message = "Success", response=Book.class ),
	})
	public void getBookById (@ApiParam(value = "book id", required = true) @PathParam("id")String id){

	}
	
	@GET
	@Path("books/stock/{status}")
	@Produces("application/json")
	@ApiOperation(value = "get book by stock")
	@ApiResponses(value = { //
			@ApiResponse(code = 200, message = "Success", response=Book.class , responseContainer="Array" ),
	})
	public void getBookByStatus (@ApiParam(value = "book status", required = true) @PathParam("status")Boolean status){

	}
	
	@POST
	@Path("books")
	@Produces("application/json")
	@ApiOperation(value = "add book to list")
	@ApiResponses(value = { //
			@ApiResponse(code = 200, message = "Success", response=Book.class ),
	})
	public void addBook (@ApiParam(value = "book detail", required = true) Book book){

	}
		
	@PUT
	@Path("books/{id}")
	@Produces("application/json")
	@ApiOperation(value = "update existing book by id")
	@ApiResponses(value = { //
			@ApiResponse(code = 200, message = "Success", response=Book.class ),
	})
	public void updateBookById (@ApiParam(value = "id", required = true) @PathParam("id")String id , 
								@ApiParam(value = "book detail", required = true) Book book ){

	}
	
	@PUT
	@Path("books/{id}/stock/{status}")
	@Produces("application/json")
	@ApiOperation(value = "update book status by id")
	@ApiResponses(value = { //
			@ApiResponse(code = 200, message = "Success", response=Book.class ),
	})
	public void updateBookStatusById (@ApiParam(value = "id", required = true) @PathParam("id") String id , 
										@ApiParam(value = "book status", required = true) @PathParam("status") Boolean status ){

	}
	
	@DELETE
	@Path("books/{id}/delete")
	//@Produces("text/plain")
	@ApiOperation(value = "delete book from list by id" , notes= "can't test on swagger because bug on it")
	@ApiResponses(value = { //
			@ApiResponse(code = 200, message = "Success"  ),
			@ApiResponse(code = 404, message = "Book not found" ),
	})
	public void deleteBookById (@ApiParam(value = "id", required = true) @PathParam("id") String id ){
										

	}
}
