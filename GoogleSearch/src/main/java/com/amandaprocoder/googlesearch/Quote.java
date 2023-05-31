package com.amandaprocoder.googlesearch;

public class Quote {

    private String quote;
    private String author;

    public Quote(){
        this.quote = null;
        this.author = null;
    }

    public Quote(String quote, String author) {
        this.quote = quote;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
