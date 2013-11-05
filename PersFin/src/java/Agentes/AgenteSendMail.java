/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Agentes;

import entities.SendMail;
import jade.core.Agent;

/**
 *
 * @author luiz
 */
public class AgenteSendMail extends Agent{

        public static void action() {
        SendMail.mail();
    }

        public boolean done() {
        return true;
    }
    
}
