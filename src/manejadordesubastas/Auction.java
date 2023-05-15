/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejadordesubastas;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author jamesleon
 */

public class Auction {
    private Product product;
    private List<Client> clients;
    private boolean isActive;
    private List<Bid> bids;
    private Calendar startdate;
    private int auctionDurationWindow = 5 * 50;

    public Auction(Product product) {
        this.product = product;
        this.clients = new ArrayList<>();
        this.isActive = false;
        this.bids = new ArrayList<>();
    }

    public void placeBid(Bid bid) {
        if (isActive() && bid.getAmount() > product.getCurrentPrice()) {
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
        Calendar now = Calendar.getInstance();
        Calendar finishdate = Calendar.getInstance();
        finishdate.add(Calendar.SECOND, this.auctionDurationWindow);
        return (isActive && now.compareTo(startdate) > 0 && finishdate.compareTo(now) > 0);
    }

    public Product getProduct() {
        return product;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setStartDate(Calendar startdate) throws Exception {
        Calendar now = Calendar.getInstance();
        if (now.compareTo(startdate) > 0) {
            throw new Exception("Start date must be after than current date");
        }

        this.startdate = startdate;
    }

    public Calendar getStartDate() {
        return startdate;
    }

    public void setDurationWindow(int timeInSeconds) throws Exception {
        if (timeInSeconds < 0) {
            throw new Exception("Duration window must be greater than zero");
        }
        this.auctionDurationWindow = timeInSeconds;
    }

    public int getDurationWindows() {
        return this.auctionDurationWindow;
    }

    public Calendar getFinishDate() {
        Calendar retorno = (Calendar) startdate.clone();
        retorno.add(Calendar.SECOND, this.auctionDurationWindow);
        return retorno;
    }

    @Override
    public String toString() {
        Double precio = (this.getHighestBid() != null) ? this.getHighestBid().getAmount() : 0f;
        return String.format("Producto: %1s\n\rPrecio: $%2.2f\n\rFecha inicio:  %3s",
                this.product.getName(), precio, this.startdate.getTime());
    }

}
