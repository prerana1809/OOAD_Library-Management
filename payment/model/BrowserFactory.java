package com.example.Payment.payment.model;

import java.util.ArrayList;
import java.util.Collections;
// import java.util.Collections;
import java.util.List;

/**
 * Interface for searching books.
 */
interface BookSearch {
    boolean searchBook(String book);
}

/**
 * Interface for searching journals.
 */
interface JournalSearch {
    boolean searchJournal(String journal);
}

/**
 * Interface for searching research papers.
 */
interface PaperSearch {
    boolean searchPaper(String paper);
}

/**
 * Factory class to manage and search through books, journals, and research papers.
 */
public class BrowserFactory {
    private List<String> books;
    private List<String> journals;
    private List<String> papers;

    /**
     * Constructor for the BrowserFactory which initializes lists for books, journals, and papers.
     */
    public BrowserFactory() {
        books = new ArrayList<>();
        journals = new ArrayList<>();
        papers = new ArrayList<>();
    }

    /**
     * Adds a book to the list of books if it is not already present.
     * @param book The book to add
     */
    public void addBook(String book) {
        if (!books.contains(book) && book != null) {
            books.add(book);
        }
    }

    /**
     * Adds a journal to the list of journals if it is not already present.
     * @param journal The journal to add
     */
    public void addJournal(String journal) {
        if (!journals.contains(journal) && journal != null) {
            journals.add(journal);
        }
    }

    /**
     * Adds a research paper to the list of papers if it is not already present.
     * @param paper The paper to add
     */
    public void addPaper(String paper) {
        if (!papers.contains(paper) && paper != null) {
            papers.add(paper);
        }
    }
    public void sort(List<String> items) {
        Collections.sort(items);
    }

    // Function to filter items based on a keyword
    public List<String> filter(List<String> items, String keyword) {
        List<String> filteredItems = new ArrayList<>();
        for (String item : items) {
            if (item.contains(keyword)) {
                filteredItems.add(item);
            }
        }
        return filteredItems;
    }

    public boolean searchBook(String item) {
        return books.contains(item);
    }
    public boolean searchJournal(String item) {
        return journals.contains(item);
    }

    public boolean searchPaper(String item) {
        return papers.contains(item);
    }
    public List<String> listBooks() {
        return books;
    }

    public List<String> listJournals() {
        return journals;
    }
    public List<String> listPapers() {
        return papers;
    }
}
