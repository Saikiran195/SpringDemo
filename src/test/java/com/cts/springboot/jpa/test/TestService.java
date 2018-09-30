package com.cts.springboot.jpa.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.hamcrest.Matcher;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cts.springboot.jpa.entity.Book;
import com.cts.springboot.jpa.repository.BookRepository;
import com.cts.springboot.jpa.service.BookService;

public class TestService {

	@Mock
	private BookRepository daoMock;

	private List<Book> books;

	// injecting mock object into employee service
	@InjectMocks
	private BookService service1;

	@Before(value = "")
	public void setUp() throws Exception {
		System.out.println("testGetAllBooks()");
		MockitoAnnotations.initMocks(this);
		books = getTestData();
	}

	@Ignore
	@Test
	public void testGetAllBooks() throws SQLException{
		System.out.println("testGetAllBooks()");
		System.out.println(daoMock.findAll());
		when(daoMock.findAll()).thenReturn(books);
		System.out.println(daoMock.findAll());
	//assertThat(service1.getAllBooks(),hashSize(2));
	assert (service1.getAllBooks().size() > 0);
	}
	
	/* @Ignore
     @Test
	public void testSave() {
    		when(daoMock.save(entity)((Book.class)))
    					.thenReturn(true);
    		//assertTrue(service1.insertEmployee(new Employee()));
    		assertThat(service1.saveBook(new Book()),is(true));
	}*/
	
	

	

	private List<Book> getTestData() {
		Book book = new Book();
		book.setBookid(1005);
		book.setTitle("AngularJs");
		book.setPrice(300);
		book.setVolume(3);
		book.setPublishdate(new Date());

		Book book1 = new Book();
		book1.setBookid(1006);
		book1.setTitle("UI");
		book1.setPrice(350);
		book1.setVolume(2);
		book1.setPublishdate(new Date());
		List<Book> books = new ArrayList<Book>();
		books.add(book);
		books.add(book1);
		return books;
	}

}
