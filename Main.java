package com.lavrovivan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ComicBookManager manager = new ComicBookManager(
                System.out, scanner, null, null
        );
        String bookName = "";
        ComicBookRepository cBookR = null;
        boolean finish = false;
        do {
            System.out.println("Welcome to comic book store console App\n" +
                    "type create/ update/ finish (to quit)/ delete/ search / sell / decomm (to decommission) / " +
                    "new (to find new comic books)");
            String command = scanner.nextLine();
            switch (command) {
                case "create":
                    ComicBookRepository.createBook(manager.createComicBook());
                    break;
                case "update":
                    ComicBook book;
                    System.out.println("type name of the comic book to update: ");
                    bookName = scanner.nextLine();
                    String row = "";
                    // find row
                    cBookR = new ComicBookRepository();
                    if (cBookR.searchForBookByName(bookName)) {
                        cBookR.copyFileWithoutRow(bookName);

                        // take row from file and create a book object
                        row = cBookR.findRowOfBook(bookName);
                        System.out.println("new file was filled");
                    } else {
                        System.out.println("comic book name not found.\n");
                    }
                    // create new book object from existing row in file
                    book = cBookR.createObjFromFile(row);
                    book = manager.update(book);
                    // add object into file
                    ComicBookRepository.updateInNewFile(book);
                    break;
                case "finish":
                    finish = true;
                    break;
                case "delete":
                    System.out.println("type the comic book name to delete: ");
                    bookName = scanner.nextLine().toLowerCase();
                    cBookR = new ComicBookRepository();
                    if (cBookR.searchForBookByName(bookName)) {
                        cBookR.copyFileWithoutRow(bookName);
                        System.out.println("new file was filled");
                    } else {
                        System.out.println("comic book name not found.\n");
                    }
                    break;
                case "search":
                    System.out.println("type item to search: 'name' or 'author' or 'genre'");
                    String item = scanner.nextLine();
                    switch (item) {
                        case "name":
                            System.out.println("type comic book name to search by name: ");
                            bookName = scanner.nextLine().toLowerCase();
                            cBookR = new ComicBookRepository();
                            if (!cBookR.searchForBookByName(bookName)) {
                                System.out.println("comic book name not found.\n");
                            }
                            break;
                        case "author":
                            System.out.println("type comic book author to search by author: ");
                            String bookAuthor = scanner.nextLine().toLowerCase();
                            cBookR = new ComicBookRepository();
                            if (!cBookR.searchForBookByAuthor(bookAuthor)) {
                                System.out.println("comic book name not found.\n");
                            }
                            break;
                        case "genre":
                            System.out.println("type comic book genre to search by genre: ");
                            String genre = scanner.nextLine().toLowerCase();
                            cBookR = new ComicBookRepository();
                            if (!cBookR.searchForBookByGenre(genre)) {
                                System.out.println("comic book name not found.\n");
                            }
                            break;
                        default:
                            System.out.println("Error. Possible items to search: 'name', 'author' or 'genre'");
                            break;
                    }
                    break;
                case "sell":
                    System.out.println("type name of the comic book to sell: ");
                    bookName = scanner.nextLine();

                    // find row
                    cBookR = new ComicBookRepository();
                    if (cBookR.searchForBookByName(bookName)) {
                        cBookR.copyFileMarkSellDecommissioned(bookName, true, false);
                        System.out.println("new file was filled");
                    } else {
                        System.out.println("comic book name not found.\n");
                    }
                    break;
                case "decomm":
                    System.out.println("type name of the comic book to decommission: ");
                    bookName = scanner.nextLine();

                    // find row
                    cBookR = new ComicBookRepository();
                    if (cBookR.searchForBookByName(bookName)) {
                        cBookR.copyFileMarkSellDecommissioned(bookName, false, true);
                        System.out.println("new file was filled");
                    } else {
                        System.out.println("comic book name not found.\n");
                    }
                    break;
                case "new":
                    cBookR = new ComicBookRepository();
                    cBookR.searchForNewBooks();
                    break;
                default:
                    System.out.println("Error. unknown command. Please type create/update/finish ");
            }
        } while (!finish);
    }
}
