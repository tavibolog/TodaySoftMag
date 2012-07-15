package com.todaysoftmag.examples.rest;

import static org.junit.Assert.assertTrue;

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
    private static WebResource service;

    @BeforeClass
    public static void init() {
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        service = client.resource(UriBuilder.fromUri(BASE_URI).build());
    }

    @Before
    public void setUp() {
        String response = service.path("/books").path("/reset").post(String.class);
        
        assertTrue("added".equals(response));
    }

    @Test
    public void testGetBook() {
        // accept XML
        Book book = service.path("/books").path("/get/1").accept(MediaType.TEXT_XML).get(Book.class);
        assertTrue(book.id.equals("1"));
        // accept JSON
        book = service.path("/books").path("/get/2").accept(MediaType.APPLICATION_JSON).get(Book.class);
        assertTrue(book.id.equals("2"));
    }

    @Test
    public void testGetList() {
        Book[] books = service.path("/books").path("/list").accept(MediaType.TEXT_XML).get(Book[].class);

        assertTrue(books.length == 2);
    }
    
    @Test
    public void testGetListSearch() {
        Book[] books = service.path("/books").path("/list").queryParam("s", "Code").accept(MediaType.TEXT_XML).get(Book[].class);
        
        assertTrue(books.length == 1);
    }

    @Test
    public void testAddBook() {
        Book book = new Book("3", "Bruce Eckel", "Thinking in Java");

        Book returnedBook = service.path("/books").path("/add").type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).put(Book.class, book);

        assertTrue(returnedBook.id.equals(book.id));

        Book[] books = service.path("/books").path("/list").accept(MediaType.TEXT_XML).get(Book[].class);

        assertTrue(books.length == 3);
    }
    
    @Test
    public void testDeleteBook() {
        Book book = service.path("/books").path("/delete/1").delete(Book.class);
        
        assertTrue(book != null);
        
        Book[] books = service.path("/books").path("/list").accept(MediaType.TEXT_XML).get(Book[].class);

        assertTrue(books.length == 1);

    }
}
