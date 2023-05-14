/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejadordesubastas;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author jamesleon
 */

public class Auction {
    private Product product;
    private List<Client> clients;
    private boolean isActive;
    private List<Bid> bids;

    public Auction(Product product) {
        this.product = product;
        this.clients = new ArrayList<>();
        this.isActive = false;
        this.bids = new ArrayList<>();
    }
    
    public void placeBid(Bid bid) {
        if (isActive && bid.getAmount() > product.getCurrentPrice()) {
            product.setCurrentPrice(bid.getAmount());
            bids.add(bid);
            notifyClients();
        }
    }

    public List<Bid> getBids() {
        return bids;
    }

    // New method to notify clients when a new bid is placed
    private void notifyClients() {
        for (Client client : clients) {
            if (client.getSubscribedProducts().contains(product)) {
                System.out.println("Hello " + client.getName() + ", a new bid has been placed on " + product.getName());
            }
        }
    }

    public Bid getHighestBid() {
        Bid highestBid = null;

        for (Bid bid : bids) {
            if (highestBid == null || bid.getAmount() > highestBid.getAmount()) {
                highestBid = bid;
            }
        }

        return highestBid;
    }

    public void addClient(Client client) {
        clients.add(client);
        client.subscribe(product);
    }

    public void removeClient(Client client) {
        clients.remove(client);
        client.unsubscribe(product);
    }

    public void startAuction() {
        isActive = true;
    }

    public void endAuction() {
        isActive = false;
    }

    public boolean isActive() {
        return isActive;
    }

    public Product getProduct() {
        return product;
    }
    
    public List<Client> getClients() {
        return clients;
    }
    
}
