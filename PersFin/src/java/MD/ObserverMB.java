/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MD;

import Agentes.AgenteObserver;
import Agentes.AgenteSendMail;
import entities.Cadastro;
import entities.ConexaoBD;
import entities.Observer;
import jade.core.behaviours.CyclicBehaviour;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author luiz
 */
public class ObserverMB extends CyclicBehaviour{
    public ObserverMB(AgenteObserver aThis, int i) {
    }
    public void action(){ 
        boolean error = false;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Cadastro res = null;
        String sql = "select *from cadastro ";
        System.out.println(sql);

        boolean sw = false;
        Connection con = null;
        try {
            sw = ((con == null) || (con.isClosed()));
            con = (sw) ? ConexaoBD.openDBConnection() : con;
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet r = ps.executeQuery();
            if (r.next()) {
                res = new Cadastro();
                res.setDataVencimento((Date) r.getObject(1));
                res.setTipoConta((String) r.getObject(2));
                res.setValorConta((Double) r.getObject(3));
            }
            Date d = new Date();
            if (r.getObject(1) == d)
                AgenteSendMail.action();
            r.close();
            ps.close();
        } catch (Exception ex) {
            error = true;
            System.out.println("Erro ao executar consulta com o Banco. \n Error: " + ex);
        } finally {
            try {
                if (sw && con != null && !con.isClosed()) {
                    con.close();
                }
            } catch (Exception ex) {
                error = true;
                System.out.println("Erro ao executar consulta com o banco. \n Error: " + ex);
            }
        }
        
 }
    
}
    

