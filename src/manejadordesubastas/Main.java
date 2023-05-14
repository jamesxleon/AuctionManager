/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package manejadordesubastas;

/**
 *
 * @author jamesleon
 */

public class Main {
    public static void main(String[] args) {
        
        // Crear productos
        Product vanGogh = new Product("La Noche Estrellada", 70000000);
        Product ferrari = new Product("Ferrari Clásico", 1000000);
        Product newtonManuscript = new Product("Principios matemáticos de la filosofía natural", 40000000);

        
        // Crear clientes
        Client client = new Client("John Unoe");
        Client client1 = new Client("John Does");
        Client client2 = new Client("John Tres");
        Client client3 = new Client("John Cuatrou");

        
        // Crear manejador de subastas y sesiones
        AuctionManager auctionManager = new AuctionManager();
        SessionManager sessionManager = new SessionManager();

        
        // Crear subastas y añadir productos
        auctionManager.createAuction(vanGogh);
        auctionManager.createAuction(ferrari);
        auctionManager.createAuction(newtonManuscript);

        
        // Crear sesión y añadir clientes. Aquí empieza la subasta.
        sessionManager.createSession();
        Session currentSession = sessionManager.getSessions().get(0);
        currentSession.addClient(client); // Aquí añado los clientes
        currentSession.addClient(client1);
        currentSession.addClient(client2);
        currentSession.addClient(client3);
        

        // Suscribir al cliente a los productos
        client.subscribe(vanGogh); client1.subscribe(vanGogh); client2.subscribe(vanGogh); client3.subscribe(vanGogh);
        client.subscribe(ferrari); client1.subscribe(ferrari); client2.subscribe(ferrari); client3.subscribe(ferrari); 
        client.subscribe(newtonManuscript); client1.subscribe(newtonManuscript); client2.subscribe(newtonManuscript); client3.subscribe(newtonManuscript);
        //Este proceso es demasiado manual, revisar cómo automatizar
        
        
        // Comenzar las subastas y la sesión
        for (Auction auction : auctionManager.getAuctions()) {
            auction.startAuction();
        }
        sessionManager.startSession(currentSession);
        
        // Start the auctions and the session
        for (Auction auction : auctionManager.getAuctions()) {
            auction.startAuction();
        }
        sessionManager.startSession(currentSession);

        
        // Place some bids
        //Auction Manager for 'VanGogh' Product
        Auction vanGoghAuction = auctionManager.getAuctions().get(0);
        
        //Auction Manager for 'Ferrari' Product
        Auction ferrariAuction = auctionManager.getAuctions().get(1);
        
        //Auction Manager for 'Newton' Product
        Auction newtonAuction = auctionManager.getAuctions().get(2);
        

        //Bids for VanGogh
        vanGoghAuction.placeBid(new Bid(client1, 80000000));
        vanGoghAuction.placeBid(new Bid(client, 20000000));
        vanGoghAuction.placeBid(new Bid(client2, 90000000)); //Highest Bid, Winner!!!
        
        //Bids for Ferrari
        ferrariAuction.placeBid(new Bid(client2, 2000000));
        ferrariAuction.placeBid(new Bid(client, 1000000));
        ferrariAuction.placeBid(new Bid(client3, 3000000)); //Highest Bid, Winner!!!

        //Bids for Newton 
        newtonAuction.placeBid(new Bid(client3, 50000000));
        newtonAuction.placeBid(new Bid(client1, 70000000));
        newtonAuction.placeBid(new Bid(client2, 50005000));
        
        
        // Print the highest bids
        for (Auction auction : auctionManager.getAuctions()) {
            Bid highestBid = auction.getHighestBid();

            if (highestBid != null) {
                System.out.println("The highest bid for " + auction.getProduct().getName() + " is " + highestBid.getAmount() +
                        " by " + auction.getHighestBid().getBidder().getName());
            }
        }
        
    }
}
