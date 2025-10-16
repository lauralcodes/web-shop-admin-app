package se.jensen.charitha.webshop_g;

import se.jensen.charitha.webshop_g.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductCatalogue {

    List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public void listAllProducts() {
        System.out.println("\n");
        System.out.println("*** Product List ***");
        if (products.isEmpty()) {
            System.out.println(" No products in the product list");
            System.out.println("\n");
        } else {
            for (int i = 0; i < products.size(); i++) {
                Product product = products.get(i);
                System.out.println("Product name:" + product.getTitle() + ", Article Number:" + product.getArticleNumber() + ", Price:" + product.getPrice() + ", Description:" + product.getDescription());
            }
        }
    }


    public Product searchProduct(String givenArticleNumber) {
        Product product = null;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getArticleNumber().equals(givenArticleNumber)) {
                product = products.get(i);
            }
        }
        return product;
    }
}
