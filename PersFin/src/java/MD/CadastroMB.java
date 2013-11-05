/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MD;

import entities.Cadastro;
import entities.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;


/**
 *
 * @author luiz
 */
@ViewScoped
@ManagedBean(name = "CadastroMB")
public class CadastroMB {
    private Date dataVencimento;
    private double rendimento;
    private double totalContas;
    private String tipoConta;
    private double valorConta;
    private double contames1;
    private double contames2;
    private double contames3;
    private double disponivelInvestir;
    private double livre;

    public double getLivre() {
        return livre;
    }

    public void setLivre(double livre) {
        this.livre = livre;
    }


    public double getDisponivelInvestir() {
        return disponivelInvestir;
    }

    public void setDisponivelInvestir(double disponivelInvestir) {
        this.disponivelInvestir = disponivelInvestir;
    }

    
    
    public double getContames1() {
        return contames1;
    }

    public void setContames1(double contames1) {
        this.contames1 = contames1;
    }

    public double getContames2() {
        return contames2;
    }

    public void setContames2(double contames2) {
        this.contames2 = contames2;
    }

    public double getContames3() {
        return contames3;
    }

    public void setContames3(double contames3) {
        this.contames3 = contames3;
    }
    
    
    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public double getRendimento() {
        return rendimento;
    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }

    public double getTotalContas() {
        return totalContas;
    }

    public void setTotalContas(double totalContas) {
        this.totalContas = totalContas;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public double getValorConta() {
        return valorConta;
    }

    public void setValorConta(double valorConta) {
        this.valorConta = valorConta;
    }
    public CadastroMB Inserir() {
        boolean error = false;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Cadastro res = null;
        String sql = "insert into cadastro (tipoConta, valorConta, dataVencimento)"
                + "VALUES('" +tipoConta+"', '"+valorConta+"', '"+formato.format(dataVencimento)+"')";
        System.out.println(sql);
        tipoConta = "";
        dataVencimento = null;
        valorConta = 0.0;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Cadastro Realizado", "Cadastro realizado"));

        boolean sw = false;
        Connection con = null;
        try {
            sw = ((con == null) || (con.isClosed()));
            con = (sw) ? ConexaoBD.openDBConnection() : con;
            PreparedStatement ps = con.prepareStatement(sql);
            int x = ps.executeUpdate();

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
        if (error) {
            return null;
        } else {
            return this;
            
        }
    }
    public ArrayList<CadastroMB> valorTotal(){
        ArrayList<CadastroMB> lstres = new ArrayList<CadastroMB>();
        if(contames1 > (contames2 + contames3))
        totalContas = (contames3 + contames2 + contames1)/3;
        else
        totalContas = (contames3 + contames2 + contames1)/2.5;
        livre = rendimento - totalContas;
        disponivelInvestir = livre * 0.30;
    
        return lstres;
        
    }
    public String cadData(){
    
        return "cadastroConta.xhtml";
    }
    public String voltar(){
    return "index";
    }
    public void limpa(){
    rendimento = 0.0;
    contames1 = 0.0;
    contames2 = 0.0;
    contames3 = 0.0;
    }
}
