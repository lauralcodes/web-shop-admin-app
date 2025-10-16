package se.jensen.charitha.webshop_g.model;

public class Vegan extends Product {

    @Override
    public String category() {
        return " Category: Vegan";
    }

    public Vegan(String articleNumber, String title, double price, String description) {
        super(articleNumber, title, price, description);
    }
}
