package com.lavrovivan;

import java.io.*;
import java.util.Calendar;

class ComicBookRepository {
    static File bookRepo = new File(System.getProperty("user.dir") + File.separator + "ComicBookWarehouse.txt");
    static File bookCopy = new File(System.getProperty("user.dir") + File.separator + "new.txt");

    static void createBook(ComicBook book) {
        try (FileWriter fileWriter = new FileWriter(bookRepo, true)) {
            fileWriter.append(
                    book.getBookName() + " " +
                    book.getAuthorName() + " " +
                    book.getPublisher() + " " +
                    book.getPagesCount() + " " +
                    book.getGenre() + " " +
                    book.getPrintYear() + " " +
                    book.getPrimeCost() + " " +
                    book.getEndCustomerPrice() + " " +
                    book.isSeries() + " " +
                    book.getIsDiscounted() + " "
            );
            fileWriter.append("\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    boolean searchForBookByName(String userInput){
        // search for a row in the file
        String wholeLine = "";
        String[] split;

        try (
        BufferedReader br = new BufferedReader(new FileReader(bookRepo))
        ) {
            do {
                wholeLine = br.readLine();
                if (wholeLine == null) {
                    return false;
                }
                // split by space.
                split = wholeLine.split(" ");
                String aSplit = split[0];
                    aSplit = aSplit.toLowerCase();
                    if (aSplit.contains(userInput.toLowerCase())) { // found book name
                        if (wholeLine != null && (wholeLine.compareTo("") != 0)) {
                            System.out.println(wholeLine);
                        }
                        return true;
                    }
            } while (!wholeLine.equals(null));
        } catch (IOException exc) {
            System.out.println("I/O Error: " + exc);
        }
        return false; // num not found
    }

    boolean searchForBookByAuthor(String userInput){
        // search for a row in the file
        String wholeLine = "";
        String[] split;

        try (BufferedReader br = new BufferedReader(new FileReader(bookRepo))) {
            do {
                wholeLine = br.readLine();
                if (wholeLine == null) {
                    return false;
                }
                // split by space.
                split = wholeLine.split(" ");
                String aSplit = split[1];
                aSplit = aSplit.toLowerCase();
                if (aSplit.contains(userInput.toLowerCase())) { // found book name
                    if (wholeLine != null && (wholeLine.compareTo("") != 0)) {
                        System.out.println(wholeLine);
                    }
                    return true;
                }
            } while (!wholeLine.equals(null));
        } catch (IOException exc) {
            System.out.println("I/O Error: " + exc);
        }
        return false; // num not found
    }
    boolean searchForBookByGenre(String userInput){
        // search for a row in the file
        String wholeLine = "";
        String[] split;

        try (BufferedReader br = new BufferedReader(new FileReader(bookRepo))) {
            do {
                wholeLine = br.readLine();
                if (wholeLine == null) {
                    return false;
                }
                // split by space.
                split = wholeLine.split(" ");
                String aSplit = split[4];
                aSplit = aSplit.toLowerCase();
                if (aSplit.contains(userInput.toLowerCase())) { // found book name
                    if (wholeLine != null && (wholeLine.compareTo("") != 0)) {
                        System.out.println(wholeLine);
                    }
                    return true;
                }
            } while (!wholeLine.equals(null));
        } catch (IOException exc) {
            System.out.println("I/O Error: " + exc);
        }
        return false; // num not found
    }

    void copyFileWithoutRow(String userInput){
        String i;
        FileReader fin = null;
        FileWriter fout = null;

        BufferedReader br = null;
        BufferedWriter bw = null;

        // Copy a File.
        try {
            // Attempt to open the files.
            fin = new FileReader(bookRepo);
            fout = new FileWriter(bookCopy);

            br = new BufferedReader(fin);
            bw = new BufferedWriter(fout);

            do {
                i = br.readLine();

                if(i != null) {
                    String[] split = i.split(" ");
                    split[0] = split[0].toLowerCase();
                    if (split[0].equals(userInput)) {
                        continue;
                    }

                    fout.write(i);
                    fout.write("\r\n");
                }
            } while(i != null);

        } catch(IOException exc) {
            System.out.println("I/O Error: " + exc);
        } finally {
            try {
                if(fin != null) fin.close();
            } catch(IOException exc) {
                System.out.println("Error Closing Input File");
            }
            try {
                if(fout != null) fout.close();
            } catch(IOException exc) {
                System.out.println("Error Closing Output File");
            }
        }
    }

    static void updateInNewFile(ComicBook book) {
        try (FileWriter fileWriter = new FileWriter(bookCopy, true)) {
            fileWriter.append(
                    book.getBookName() + " " +
                    book.getAuthorName() + " " +
                    book.getPublisher() + " " +
                    book.getPagesCount() + " " +
                    book.getGenre() + " " +
                    book.getPrintYear() + " " +
                    book.getPrimeCost() + " " +
                    book.getEndCustomerPrice() + " " +
                    book.isSeries() + " " +
                    book.getIsDiscounted() + " "
            );
            fileWriter.append("\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void copyFileMarkSellDecommissioned(String userInput, boolean isSold, boolean isDecommissioned){
        String i;
        FileReader fin = null;
        FileWriter fout = null;

        BufferedReader br = null;
        BufferedWriter bw = null;

        // Copy a File.
        try {
            // Attempt to open the files.
            fin = new FileReader(bookRepo);
            fout = new FileWriter(bookCopy);

            br = new BufferedReader(fin);
            bw = new BufferedWriter(fout);

            do {
                i = br.readLine();

                if(i != null) {
                    String[] split = i.split(" ");
                    split[0] = split[0].toLowerCase();
                    fout.write(i);
                    if (split[0].equals(userInput) && isSold) {
                        fout.write("Sold ");
                    } else if (split[0].equals(userInput) && isDecommissioned) {
                        fout.write("Decommissioned ");
                    }
                    fout.write("\r\n");
                }
            } while(i != null);

        } catch(IOException exc) {
            System.out.println("I/O Error: " + exc);
        } finally {
            try {
                if(fin != null) fin.close();
            } catch(IOException exc) {
                System.out.println("Error Closing Input File");
            }
            try {
                if(fout != null) fout.close();
            } catch(IOException exc) {
                System.out.println("Error Closing Output File");
            }
        }
    }
    String findRowOfBook(String userInput){
        // search for a row in the file
        String wholeLine = "";
        String[] split;

        try (
                BufferedReader br = new BufferedReader(new FileReader(bookRepo))
        ) {
            do {
                wholeLine = br.readLine();
                if (wholeLine == null) {
                    return "";
                }
                // split by space.
                split = wholeLine.split(" ");
                String aSplit = split[0];
                aSplit = aSplit.toLowerCase();
                if (aSplit.contains(userInput.toLowerCase())) { // found book name
                    if (wholeLine != null && (wholeLine.compareTo("") != 0)) {
//                        System.out.println("row found: " + wholeLine);
                        return wholeLine;
                    }
                }
            } while (!wholeLine.equals(null));
        } catch (IOException exc) {
            System.out.println("I/O Error: " + exc);
        }
        return ""; // row not found
    }

    ComicBook createObjFromFile(String row){
        String[] split;
        split = row.split(" ", 11);
        ComicBook book = new ComicBook();
        book.setBookName(split[0]);
        book.setAuthorName(split[1]);
        book.setPublisher(split[2]);
        book.setPagesCount(split[3]);
        switch (split[4].toLowerCase()){
            case "horror":
                book.setGenre(Genre.horror);
                break;
            case "mystery":
                book.setGenre(Genre.mystery);
                break;
            case "scienceFiction":
                book.setGenre(Genre.scienceFiction);
                break;
            case "fantasy":
                book.setGenre(Genre.fantasy);
                break;
            case "memoir":
                book.setGenre(Genre.memoir);
                break;
            case "history":
                book.setGenre(Genre.history);
                break;
        }
        book.setPrintYear(Integer.valueOf(split[5]));
        book.setSeries(split[8].charAt(0));
        book.setIsDiscounted(split[9].charAt(0));
        if (split[10] != "") {
            book.setDecommissioned(split[10]);
        }

        return book;
    }

    void searchForNewBooks(){
        // search for books published in the last year
        final int YEARSTOSEARCH = 1;
        int year = Calendar.getInstance().get(Calendar.YEAR);
        String wholeLine = "";
        String[] split;

        try (
                BufferedReader br = new BufferedReader(new FileReader(bookRepo))
        ) {
            do {
                wholeLine = br.readLine();
                if (wholeLine == null) {
                    return;
                }
                // split by space.
                split = wholeLine.split(" ");
                int aSplit = Integer.valueOf(split[5]);
                if (aSplit >= (year - YEARSTOSEARCH)) { // found book
                    if (wholeLine != null && (wholeLine.compareTo("") != 0)) {
                        System.out.println(wholeLine);
                    }
                }
            } while (!wholeLine.equals(null));
        } catch (IOException exc) {
            System.out.println("I/O Error: " + exc);
        }
        return; // book not found
    }
}
