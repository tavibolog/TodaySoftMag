package com.todaysoftmag.examples.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/books")
public class BookService {
    private static final List<Book> books = new ArrayList<Book>();
        
    
    @POST
    @Path("/reset")
    public Response reset() {
        books.clear();
        books.add(new Book("1", "Clean Code", "Robert C. Martin"));
        books.add(new Book("2", "Real World Java EE Patterns", "Adam Bien"));
        
        return Response.ok("added").build();
    }
    
    @GET
    @Path("/get/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
    public Book get(@PathParam("id") String id) {
        for (Book book: books) {
            if (book.id.equals(id)){
                return book;
            }
        }
        return null;
    }
    
    @GET
    @Path("/list")
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
    public Book[] list(@QueryParam("s") @DefaultValue("") String search) {
        if ("".equals(search)) {
            return books.toArray(new Book[]{});
        } else {
            List<Book> results = new ArrayList<Book>();
            for (Book book : books) {
                if (book.name.contains(search)) {
                    results.add(book);
                }
            }
            return results.toArray(new Book[]{});
        }
    }
    
    @PUT
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Book add(Book book) {
        books.add(book);
        return book;
    }
    
    @DELETE
    @Path("/delete/{id}")
    public Book delete(@PathParam("id") String id) {        
        for (Book book: books) {
            if (book.id.equals(id)) {
                books.remove(book);
                return book;
            }
        }
        return null;
    }
    
    
}
