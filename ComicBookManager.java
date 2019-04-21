package com.lavrovivan;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ComicBookManager {
    private PrintStream out;
    private Scanner in;
    private ObjectInputStream fileIn; // read from file
    private ObjectOutputStream fileOut;

    public ComicBookManager(PrintStream out, Scanner in,
                            ObjectInputStream fileIn, ObjectOutputStream fileOut) {
        this.out = out;
        this.in = in;
        this.fileIn = fileIn;
        this.fileOut = fileOut;
    }

    public ComicBook createComicBook() {
        ComicBook myComicBook = new ComicBook();
        out.println("Type comic book name then push enter. 20 char max: ");
        String bookName = in.nextLine();
        myComicBook.setBookName(/*truncateOrAddSpacesTo20Ch*/(bookName));

        out.println("type authorName. 20 char max: ");
        String authorName = in.nextLine();
        myComicBook.setAuthorName(/*truncateOrAddSpacesTo20Ch*/(authorName));

        out.println("type publisher: 20 char max");
        String publisher = in.nextLine();
        myComicBook.setPublisher(/*truncateOrAddSpacesTo20Ch*/(publisher));

        out.println("type pagesCount: 4 char max");
        Integer pagesCount = in.nextInt();
        myComicBook.setPagesCount(/*truncateOrAddSpacesTo4Ch*/(pagesCount).toString());
        in.nextLine();

        myComicBook.setGenre(getGenre());

        out.println("type printYear 4 characters: ");
        Integer printYear = in.nextInt();
        myComicBook.setPrintYear(printYear);
        in.nextLine();

        out.println("type isSeries (T/F): ");
        String isSeries = in.nextLine();
        isSeries = isSeries.toUpperCase();
        switch (isSeries) {
            case "T":
            case "F":
                char isSeriesChar = isSeries.charAt(0);
                myComicBook.setSeries(isSeriesChar);
                break;
            default:
                System.out.println("type is the book part of the series or not, type TRUE or FALSE");
                break;
        }

        out.println("type is Discounted (T/F): ");
        String isDiscounted = in.nextLine().toUpperCase();
        switch (isDiscounted) {
            case "T":
            case "F":
                char isDiscountedChar = isDiscounted.charAt(0);
                myComicBook.setIsDiscounted(isDiscountedChar);
                break;
            default:
                System.out.println("type is the book is Discounted or not, type TRUE or FALSE");
                break;
        }

        return myComicBook;
    }

    /*public void read(ComicBook comicBook) {
        out.println("comic Book name " + comicBook.getBookName() + " " + comicBook.getPagesCount() + " pages");
        out.println("comic Book author Name " + comicBook.getAuthorName());
        out.println("comic Book publisher " + comicBook.getPublisher());
        out.println("is comic Book Series? " + comicBook.isSeries());
        out.println("comic Book genre " + comicBook.getGenre());
        out.println("comic Book printYear " + comicBook.getPrintYear());
    }*/

    public ComicBook update(ComicBook comicBook) {
        ComicBook newBook = new ComicBook();
        // set new parameter
        System.out.println("type new value or press Enter to leave the old value: ");
        Scanner sc = new Scanner(System.in);

        out.println("Type comic book name then push enter. 20 char max. ");
        String bookName = in.nextLine();
        if (bookName.length() == 0){
            newBook.setBookName(comicBook.getBookName());
        } else {
            newBook.setBookName(bookName);
        }

        out.println("type authorName. 20 char max: ");
        String authorName = in.nextLine();
        if (authorName.length() == 0){
            newBook.setAuthorName(comicBook.getAuthorName());
        } else {
            newBook.setBookName(authorName);
        }

        out.println("type publisher. 20 char max: ");
        String publisher = in.nextLine();
        if (publisher.length() == 0){
            newBook.setPublisher(comicBook.getPublisher());
        } else {
            newBook.setBookName(publisher);
        }

        out.println("type pagesCount. 4 char max: ");
        String pagesCount = in.nextLine();
        if (pagesCount.length() == 0){
            newBook.setPagesCount(comicBook.getPagesCount());
        } else {
            newBook.setPagesCount(pagesCount);
        }

        out.println("choose genre (horror H, mystery M, scienceFiction S, fantasy F, memoir E, history I): ");
        String genre = (in.nextLine()).toUpperCase();
        if (genre.length() == 0) {
            newBook.setGenre(comicBook.getGenre());
        } else {
            char genreChar = genre.charAt(0);
            switch (genreChar) {
                case 'H':
                    newBook.setGenre(Genre.horror);
                    break;
                case 'M':
                    newBook.setGenre(Genre.mystery);
                    break;
                case 'S':
                    newBook.setGenre(Genre.scienceFiction);
                    break;
                case 'F':
                    newBook.setGenre(Genre.fantasy);
                    break;
                case 'E':
                    newBook.setGenre(Genre.memoir);
                    break;
                case 'I':
                    newBook.setGenre(Genre.history);
                    break;
                default:
                    newBook.setGenre(Genre.UNKNOWN);
                    break;
            }
        }

        out.println("type printYear. 4 char max: ");
        String printYear = in.nextLine();
        if (printYear.length() == 0){
            newBook.setPrintYear(comicBook.getPrintYear());
        } else {
            newBook.setPrintYear(Integer.valueOf(printYear));
        }

        out.println("type isSeries (T/F): ");
        String isSeries = in.nextLine();
        isSeries = isSeries.toUpperCase();
        switch (isSeries) {
            case "T":
            case "F":
                char isSeriesChar = isSeries.charAt(0);
                newBook.setSeries(isSeriesChar);
                break;
            default:
                newBook.setSeries(comicBook.isSeries());
                break;
        }
        out.println("type isDiscounted (T/F): ");
        String isDiscounted = in.nextLine().toUpperCase();
        switch (isDiscounted) {
            case "T":
            case "F":
                char isDiscountedChar = isDiscounted.charAt(0);
                newBook.setIsDiscounted(isDiscountedChar);
                break;
            default:
                newBook.setIsDiscounted(comicBook.getIsDiscounted());
                break;
        }

        return newBook;
        }

    /*String truncateOrAddSpacesTo20Ch(String userInput) {
        if (userInput.length() == 20) {
            return userInput;
        } else if (userInput.length() > 20) {
            return userInput.substring(0, 19);
        } else {
            return String.format("%-20s", userInput);
        }
    }
    String truncateOrAddSpacesTo4Ch(int userInput) {
        Integer integer = userInput;
        String string = integer.toString();
        if (string.length() == 4) {
            return string;
        } else if (string.length() > 4) {
            return string.substring(0, 3);
        } else {
            return String.format("%-4s", string);
        }
    }*/

    Genre getGenre(){
        out.println("choose genre (horror H, mystery M, scienceFiction S, fantasy F, memoir E, history I): ");

        String genre = (in.nextLine()).toUpperCase();
        char genreChar = genre.charAt(0);
        switch (genreChar) {
            case 'H':
                return Genre.horror;
            case 'M':
                return Genre.mystery;
            case 'S':
                return Genre.scienceFiction;
            case 'F':
                return Genre.fantasy;
            case 'E':
                return Genre.memoir;
            case 'I':
                return Genre.history;
            default:
                return Genre.UNKNOWN;
        }
    }
}
