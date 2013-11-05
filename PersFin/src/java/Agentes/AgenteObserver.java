/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Agentes;

import MD.ObserverMB;
import jade.core.Agent;

/**
 *
 * @author luiz
 */
public class AgenteObserver extends Agent{
    @Override
    protected void setup(){
    addBehaviour(new ObserverMB(this, 20000));
    
    }
    
    
}
