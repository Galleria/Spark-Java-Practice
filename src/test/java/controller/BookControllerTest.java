package controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import model.Book;
import service.BookApiService;
import spark.Request;
import spark.Response;

public class BookControllerTest {
	
	@InjectMocks
	BookController bookController;
	
	BookApiService bookApiService;
	
	List<Book> Books = new ArrayList<>();
	
	@Mock 
	Request request;
	
	@Mock
	Response response;
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks( this );
		
		Boolean inStock = true;
		Boolean notInStock = false;
		
		Books.add( new Book( "1" , "Happy New Year" , "For Fun" , inStock ) ) ;
		Books.add( new Book( "2" , "Zombie" , "Terror" , notInStock ) );
		Books.add( new Book( "3" , "Harry Potter" , "Fantacy" , inStock ) );
		
		bookApiService = new BookApiService( Books );
		bookController = new BookController(bookApiService);
	}
	
	@Test
	public void getAllBooks_ShouldBe_Return_3_Items() throws Exception{
		Mockito.doReturn( "1" ).when( request ).params( Mockito.anyString() );  
		@SuppressWarnings("unchecked")
		List<Book> list = (List<Book>) bookController.getAllBooks.handle(request, response);
		Assert.assertEquals( 3 , list.size() );
	}
	
	@Test
	public void getBookById_ShouldBe_Return_1_Items() throws Exception{
		Mockito.doReturn( "1" ).when( request ).params( Mockito.anyString() );  
		Book book = (Book) bookController.getBookById.handle(request, response);
		Assert.assertEquals( Books.get(0) , book );
	}
	
}
