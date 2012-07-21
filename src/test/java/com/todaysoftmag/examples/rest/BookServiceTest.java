package com.todaysoftmag.examples.rest;

import static org.junit.Assert.assertTrue;

import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class BookServiceTest {
    private static final String BASE_URI = "http://localhost:7000/TodaySoftMag";
    private static WebResource resource;

    @BeforeClass
    public static void init() {
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        resource = client.resource(UriBuilder.fromUri(BASE_URI).build());
    }

    @Before
    public void setUp() {
        String response = resource.path("/books").path("/reset").post(String.class);
        
        assertTrue("reset".equals(response));
    }
    
    @Test
    public void testHeadersAndCookieOnReset() {
        Cookie cookie = new Cookie("credentials", "test");
        String response = resource.path("/books").path("/reset").header("clearOnly", "true").cookie(cookie).post(String.class);
        
        assertTrue("test".equals(response));

        Book[] books = resource.path("/books").path("/list").accept(MediaType.TEXT_XML).get(Book[].class);

        assertTrue(books.length == 0);
    }

    @Test
    public void testGetBook() {
        // accept XML
        Book book = resource.path("/books").path("/get/1").accept(MediaType.TEXT_XML).get(Book.class);
        assertTrue(book.id.equals("1"));
        // accept JSON
        book = resource.path("/books").path("/get/2").accept(MediaType.APPLICATION_JSON).get(Book.class);
        assertTrue(book.id.equals("2"));
    }

    @Test
    public void testGetList() {
        Book[] books = resource.path("/books").path("/list").accept(MediaType.TEXT_XML).get(Book[].class);

        assertTrue(books.length == 2);
    }
    
    @Test
    public void testGetListSearch() {
        Book[] books = resource.path("/books").path("/list").queryParam("s", "Code").accept(MediaType.TEXT_XML).get(Book[].class);
        
        assertTrue(books.length == 1);
    }

    @Test
    public void testAddBook() {
        Book book = new Book("3", "Bruce Eckel", "Thinking in Java");

        Book returnedBook = resource.path("/books").path("/add").type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).put(Book.class, book);

        assertTrue(returnedBook.id.equals(book.id));

        Book[] books = resource.path("/books").path("/list").accept(MediaType.TEXT_XML).get(Book[].class);

        assertTrue(books.length == 3);
    }
    
    @Test
    public void testDeleteBook() {
        Book book = resource.path("/books").path("/delete/1").delete(Book.class);
        
        assertTrue(book != null);
        
        Book[] books = resource.path("/books").path("/list").accept(MediaType.TEXT_XML).get(Book[].class);

        assertTrue(books.length == 1);

    }
}
