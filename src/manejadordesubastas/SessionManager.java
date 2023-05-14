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

public class SessionManager {
    private List<Session> sessions;

    public SessionManager() {
        this.sessions = new ArrayList<>();
    }

    public void createSession() {
        sessions.add(new Session());
    }

    public void startSession(Session session) {
        session.startSession();
    }

    public void closeSession(Session session) {
        session.endSession();
    }
    public List<Session> getSessions() {
        return sessions;
    }
}
