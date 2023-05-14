/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejadordesubastas;

/**
 *
 * @author jamesleon
 */
public class Bid {
    private Client bidder;
    private double amount;

    public Bid(Client bidder, double amount) {
        this.bidder = bidder;
        this.amount = amount;
    }

    public Client getBidder() {
        return bidder;
    }

    public double getAmount() {
        return amount;
    }
}
