package se.jensen.charitha.webshop_g.model;

public class Dairy extends Product {
    @Override
    public String category() {
        return "Category: Diary";
    }

    public Dairy(String articleNumber, String title, double price, String description) {
        super(articleNumber, title, price, description);
    }
}
