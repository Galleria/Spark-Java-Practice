package service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import com.google.gson.Gson;

import model.Book;

public class BookServiceApi {
	
	private static List<Book> Books;
	private static Gson gson = new Gson();
	
	public BookServiceApi(){
		
	}
	
	public BookServiceApi(List<Book> Books){
		BookServiceApi.Books = Books;
	}
	
	static{
		/*
		Boolean inStock = true;
		Boolean notInStock = false;
		
		Books = new ArrayList<>();
		Books.add( new Book( "1" , "Happy New Year" , "For Fun" , inStock ) ) ;
		Books.add( new Book( "2" , "Zombie" , "Terror" , notInStock ) );
		Books.add( new Book( "3" , "Harry Potter" , "Fantacy" , inStock ) );
		*/
	}
	
	public static List<Book> getAllBooks(){
		return Books;
	}
	
	public static Book getBookById(String id){
		try{
			return Books.stream().filter( b -> b.getId().equals(id) ).findFirst().get();
		}
		catch(NoSuchElementException ex){
			return null;
		}
	}
	
	public static List<Book> getBookByStatus(Boolean status){
		try{
			return Books.stream().filter( b -> b.getStatus().equals(status) ).collect( Collectors.toList() );
		}
		catch(NoSuchElementException ex){
			return null;
		}
	}
	
	public static Book addBook(String bookDetail){
		try{
			Book book = gson.fromJson(bookDetail, Book.class);
			book.setId( Integer.toString( Books.size()+1 ) );
			Books.add(book);
			return book;
		}
		catch(NoSuchElementException ex){
			return null;
		}
	}
	
	public static Book updateBookById(String id,String bookDetail){
		try{
			Book book = gson.fromJson(bookDetail, Book.class);
			Book upBook = Books.stream().filter( b -> b.getId().equals(id) ).findFirst().get() ;
			upBook.setTopic( book.getTopic() );
			upBook.setCategory( book.getCategory() );
			upBook.setStatus( book.getStatus() );
			return upBook;
		}
		catch(NoSuchElementException ex){
			return null;
		}
	}
	
	public static Book updateBookStatusById(String id,Boolean status){
		try{
			Book upBook = Books.stream().filter( b -> b.getId().equals(id) ).findFirst().get() ;
			upBook.setStatus( status );
			return upBook;
		}
		catch(NoSuchElementException ex){
			return null;
		}
	}
	
	public static Boolean deleteBookById(String id){
		try{
			Book upBook = Books.stream().filter( b -> b.getId().equals(id) ).findFirst().get() ;
			Books.remove( upBook ) ;
			return true;
		}
		catch(NoSuchElementException ex){
			return false;
		}
	}
}
