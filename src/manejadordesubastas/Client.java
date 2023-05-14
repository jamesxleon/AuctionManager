/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejadordesubastas;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jamesleon
 */

public class Client {
    private String name;
    private List<Product> subscribedProducts;

    public Client(String name) {
        this.name = name;
        this.subscribedProducts = new ArrayList<>();
    }

    public void subscribe(Product product) {
        subscribedProducts.add(product);
    }

    public void unsubscribe(Product product) {
        subscribedProducts.remove(product);
    }

    public List<Product> getSubscribedProducts() {
        return subscribedProducts;
    }

    public String getName() {
        return name;
    }
}
