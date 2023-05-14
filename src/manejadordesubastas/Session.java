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

public class Session {
    private List<Client> clients;
    private boolean isActive;

    public Session() {
        this.clients = new ArrayList<>();
        this.isActive = false;
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public void removeClient(Client client) {
        clients.remove(client);
    }

    public void startSession() {
        isActive = true;
    }

    public void endSession() {
        isActive = false;
    }

    public boolean isActive() {
        return isActive;
    }
    
    public List<Client> getClients() {
        return clients;
    }
}
