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

public class AuctionManager {
    private List<Auction> auctions;
    private static AuctionManager instance = null;

    public static AuctionManager getInstance() {
        if (instance == null) {
            instance = new AuctionManager();
        }
        return instance;
    }

    private AuctionManager() {
        this.auctions = new ArrayList<>();
    }

    public void createAuction(Product product, Calendar startDate) throws Exception {
        Auction auction = new Auction(product);
        auction.setStartDate(startDate);
        auctions.add(auction);
    }

    public void startAuction(Auction auction) {
        auction.startAuction();
    }

    public void closeAuction(Auction auction) {
        auction.endAuction();
    }

    public List<Auction> getAuctions() {
        return auctions;
    }
}
