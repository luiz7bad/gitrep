/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author luiz
 */
public class Cadastro {
    private Date dataVencimento;
    private double rendimento;
    private double totalContas;
    private String tipoConta;
    private double valorConta;
    private Cadastro cadastroSelect;
    private double contames1;
    private double contames2;
    private double contames3;

    public Cadastro() {
        
        
    }

    public Cadastro getCadastroSelect() {
        return cadastroSelect;
    }

    public void setCadastroSelect(Cadastro cadastroSelect) {
        this.cadastroSelect = cadastroSelect;
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
    
}
