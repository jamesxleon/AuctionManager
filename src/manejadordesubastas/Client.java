/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejadordesubastas;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author jamesleon
 */

public class Client {
    private String name;
    private List<Product> subscribedProducts;
    private UUID uuid;
    private static String path = "registro_auctions\\clients\\";

    public Client(String name) {
        this.name = name;
        this.subscribedProducts = new ArrayList<>();
        this.uuid = UUID.randomUUID();
        // Create File
        try {
            Files.createDirectories(Paths.get(path));
            File file = new File(path + this.uuid.toString() + ".txt");

            if (file.createNewFile()) {
                System.out.println(String.format("Archivo Creado: %s", file.getAbsolutePath()));
            }
            saveRegistre("Client created");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void subscribe(Product product) {
        subscribedProducts.add(product);
        saveRegistre("Registrado a " + product.getName());
    }

    public void unsubscribe(Product product) {
        subscribedProducts.remove(product);
        saveRegistre("Desregistrado de " + product.getName());
    }

    public List<Product> getSubscribedProducts() {
        return subscribedProducts;
    }

    public String getName() {
        return name;
    }

    public void saveRegistre(String registre) {
        try {
            File file = new File(path + this.uuid.toString() + ".txt");
            try (FileWriter fileWriter = new FileWriter(file, true);
                    PrintWriter out = new PrintWriter(fileWriter);) {
                out.println(registre + " | " + Calendar.getInstance().getTime());
                System.out.println(registre);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
