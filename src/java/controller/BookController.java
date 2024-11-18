/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.*;
import javax.ejb.EJB;
import model.BookFacade;
import entities.*;
/**
 *
 * @author NSP
 */
@Named(value = "bookController")
@SessionScoped
public class BookController implements Serializable {

    @EJB
    private BookFacade bookFacade;
    private Book b = new Book();

    public Book getB() {
        return b;
    }

    public void setB(Book b) {
        this.b = b;
    }
   
    
    
    public BookController() {
    }
    
    public List<Book> findAll(){
        return this.bookFacade.findAll();
    }
    
    public String add(){
        this.bookFacade.create(this.b);
        this.b=new Book();
        return "index";
    }
    
    public void delete(Book b){
        this.bookFacade.remove(b);
    }
    public String edit(Book b){
        this.b = b;
        return "edit";
    }
    
    public String edit(){
        this.bookFacade.edit(this.b);
        return "index"; 
    }
}
