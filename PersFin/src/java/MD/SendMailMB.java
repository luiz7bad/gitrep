/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MD;

import entities.SendMail;
import jade.core.Agent;
import javax.media.j3d.Behavior;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.WakerBehaviour;

/**
 *
 * @author luiz
 */
public class SendMailMB extends Agent{
    
    protected void setup(){
    addBehaviour (new WakerBehaviour(this, 100000){
    protected void onWake(){
    SendMail.mail();
    }
    });
    }
}
