package service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import com.google.gson.Gson;

import model.Book;

public class BookApiService {
	
	private List<Book> Books;
	private Gson gson = new Gson();
	
	public BookApiService(){
		
	}
	
	public BookApiService(List<Book> Books){
		this.Books = Books;
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
	
	public List<Book> getAllBooks(){
		return Books;
	}
	
	public Book getBookById(String id){
		try{
			return Books.stream().filter( b -> b.getId().equals(id) ).findFirst().get();
		}
		catch(NoSuchElementException ex){
			return null;
		}
	}
	
	public List<Book> getBookByStatus(Boolean status){
		try{
			return Books.stream().filter( b -> b.getStatus().equals(status) ).collect( Collectors.toList() );
		}
		catch(NoSuchElementException ex){
			return null;
		}
	}
	
	public Book addBook(Book book){
		try{
			book.setId( Integer.toString( Books.size()+1 ) );
			Books.add(book);
			return book;
		}
		catch(NoSuchElementException ex){
			return null;
		}
	}
	
	public Book updateBookById(String id,Book bookDetail){
		try{
			Book upBook = Books.stream().filter( b -> b.getId().equals(id) ).findFirst().get() ;
			upBook.setTopic( bookDetail.getTopic() );
			upBook.setCategory( bookDetail.getCategory() );
			upBook.setStatus( bookDetail.getStatus() );
			return upBook;
		}
		catch(NoSuchElementException ex){
			return null;
		}
	}
	
	public Book updateBookStatusById(String id,Boolean status){
		try{
			Book upBook = Books.stream().filter( b -> b.getId().equals(id) ).findFirst().get() ;
			upBook.setStatus( status );
			return upBook;
		}
		catch(NoSuchElementException ex){
			return null;
		}
	}
	
	public Boolean deleteBookById(String id){
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
