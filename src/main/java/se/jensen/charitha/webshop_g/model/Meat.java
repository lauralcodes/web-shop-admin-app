package se.jensen.charitha.webshop_g.model;

public class Meat extends Product {

    @Override
    public String category() {
        return " Category: Meat";
    }

    public Meat(String articleNumber, String title, double price, String description) {
        super(articleNumber, title, price, description);
    }
}
