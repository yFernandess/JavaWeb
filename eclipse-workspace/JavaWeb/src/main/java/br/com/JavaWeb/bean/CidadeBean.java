package br.com.JavaWeb.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.JavaWeb.DAO.CidadeDAO;
import br.com.JavaWeb.DAO.EstadoDAO;
import br.com.JavaWeb.domain.Cidade;

public class CidadeBean implements Serializable {

    private Cidade cidade;
    private ArrayList<Cidade> cidades;

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public ArrayList<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(ArrayList<Cidade> cidades) {
        this.cidades = cidades;
    }

    @PostConstruct
    public void Listar() {
        try {
            CidadeDAO cidadeDAO = new CidadeDAO();
            cidades = cidadeDAO.listar();
        } catch (RuntimeException e) {
            Messages.addGlobalError("Ocorreu um erro ao tentar listar as cidades!");
            e.printStackTrace();
        }
    }

    public void novo() {
        cidade = new Cidade();
    }

    public void excluir(ActionEvent evento) {
        try {
            cidade = (Cidade)evento.getComponent().getAttributes().get("cidadeSelecionada");
            CidadeDAO cidadeDAO = new CidadeDAO();
            cidadeDAO.excluir(cidade);

            cidades = cidadeDAO.listar();
            Messages.addGlobalInfo("Removida com sucesso");
        } catch (Exception e) {
            Messages.addGlobalError("Ocorreu um erro ao tentar excluir as cidades!");
			e.printStackTrace();
        }  
    }

    public void salvar() {
        try {
            CidadeDAO cidadeDAO = new CidadeDAO();
            cidadeDAO.salvar(cidade);

            cidade = new Cidade();
            cidades = cidadeDAO.listar();
            Messages.addGlobalInfo("Salva com sucesso!");
        } catch (RuntimeException e) {
            Messages.addGlobalError("Ocorreu um erro ao tentar salvar as cidades!");
			e.printStackTrace();
        }
    }

    public void editar(ActionEvent evento) {
        try {
            cidade = (Cidade)evento.getComponent().getAttributes().get("cidadeSelecionada");
            Messages.addGlobalInfo("Editado com sucesso!");
        } catch (RuntimeException e) {
            Messages.addGlobalError("Ocorreu um erro ao tentar editar as cidades!");
            e.printStackTrace();
        }
        
    }
}
