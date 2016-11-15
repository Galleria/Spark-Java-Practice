package service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import model.Book;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceApiTest {
	
	BookServiceApi bookServiceApi;
	
	List<Book> Books = new ArrayList<>();
	
	Boolean inStock = true;
	Boolean notInStock = false;
	
	@Before
	public void init(){
		Books.add( new Book( "1" , "Happy New Year" , "For Fun" , inStock ) ) ;
		Books.add( new Book( "2" , "Zombie" , "Terror" , notInStock ) );
		Books.add( new Book( "3" , "Harry Potter" , "Fantacy" , inStock ) );
		bookServiceApi = new BookServiceApi( Books );
	}
	
	@Test
	public void getAllBooks_It_Should_Be_Return_3_Books(){
		Assert.assertEquals( 3 , BookServiceApi.getAllBooks().size() );
	}
	
	@Test
	public void getBookById_It_Should_Be_Return_1_Book(){
		Assert.assertEquals( Books.get(0) , BookServiceApi.getBookById("1") );
	}
	
	@Test
	public void getBookById_It_Should_Be_Return_0_Book(){
		Assert.assertNotEquals( Books.get(0) , BookServiceApi.getBookById("2") );
	}
	
	@Test
	public void getBookById_It_Should_Be_Return_Empty(){
		Assert.assertNull( BookServiceApi.getBookById("99") );
	}
	
	@Test
	public void getBookByStatus_It_Should_Be_Return_1_Books_OutStock(){
		Assert.assertEquals( 1 , BookServiceApi.getBookByStatus( notInStock ).size() );
	}
	
	@Test
	public void getBookByStatus_It_Should_Be_Return_2_Books_InStock(){
		Assert.assertEquals( 2 , BookServiceApi.getBookByStatus( inStock ).size() );
	}
	
	
}
