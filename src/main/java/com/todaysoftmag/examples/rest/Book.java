package com.todaysoftmag.examples.rest;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.ToStringBuilder;

@XmlRootElement
public class Book {
    @XmlElement(name = "id")
    String id;
    @XmlElement(name = "name")
    String name;
    @XmlElement(name = "author")
    String author;

    public Book() {

    }
    
    public Book(String id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("author", author).toString();
    }

    /**
     * simplified to be less verbose
     */
    @Override
    public boolean equals(Object obj) {
        Book newBook = (Book) obj;

        return newBook.id.equals(id);
    }

    /**
     * simplified to be less verbose
     */
    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
