package com.maria.library;

import com.maria.library.model.*;
import com.maria.library.repository.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class LibraryApplication {
    private static IRoleRepository roleRepository;
    private static IUserDataRepository userDataRepository;
    private static ICategoryRepository categoryRepository;
    private static IBookRepository bookRepository;
    private static IAuthorRepository authorRepository;
    private static IBookAuthorRepository bookAuthorRepository;

    public LibraryApplication(IRoleRepository roleRepository, IUserDataRepository userDataRepository, ICategoryRepository categoryRepository, IBookRepository bookRepository, IBookAuthorRepository bookAuthorRepository, IAuthorRepository authorRepository) {
        LibraryApplication.roleRepository = roleRepository;
        LibraryApplication.userDataRepository = userDataRepository;
        LibraryApplication.categoryRepository = categoryRepository;
        LibraryApplication.bookRepository = bookRepository;
        LibraryApplication.bookAuthorRepository = bookAuthorRepository;
        LibraryApplication.authorRepository = authorRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);

        List<Role> roles = roleRepository.read();
        for (Role role : roles) {
            System.out.println(role);
        }
        System.out.println("\n");

        List<UserData> usersData = userDataRepository.read();
        for (UserData userData : usersData) {
            System.out.println(userData);
        }
        System.out.println("\n");
        List<Category> categories = categoryRepository.read();
        for (Category category : categories) {
            System.out.println(category);
        }
        System.out.println("\n");

        List<Book> books = bookRepository.read();
        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println("\n");
        List<Author> authors = authorRepository.read();
        for (Author author : authors) {
            System.out.println(author);
        }
        System.out.println("\n");

        List<BookAuthor> booksAuthors = bookAuthorRepository.read();
        for (BookAuthor bookAuthor : booksAuthors) {
            System.out.println(bookAuthor);
        }
//        UserData user1 = new UserData("sorinacampean","12345", "Sorina", "Campean", 2L);
//        userDataRepository.create(user1);
//        Book book1 = new Book("Persuasion", 1817L, 9L, 2L);
//        bookRepository.create(book1);
/*        Author author1 = new Author("Jane", "Austen", 13L);
        authorRepository.create(author1);*/
//        BookAuthor bookAuthor1 = new BookAuthor(22L, 20L);
//        bookAuthorRepository.create(bookAuthor1);
    }
}
