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

public class AuctionManager {
    private List<Auction> auctions;

    public AuctionManager() {
        this.auctions = new ArrayList<>();
    }

    public void createAuction(Product product) {
        auctions.add(new Auction(product));
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
