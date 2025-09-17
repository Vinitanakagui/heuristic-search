package modelo;

import java.util.List;


public class Cidade 
{
    private String nome;
    private List<CidadeProxima> listaCidadeProxima;
    private Double distanciaBucharest;

    public Cidade() {
    }

    public Cidade(String nome, List<CidadeProxima> listaCidadeProxima) {
        this.nome = nome;
        this.listaCidadeProxima = listaCidadeProxima;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<CidadeProxima> getListaCidadeProxima() {
        return listaCidadeProxima;
    }

    public void setListaCidadeProxima(List<CidadeProxima> listaCidadeProxima) {
        this.listaCidadeProxima = listaCidadeProxima;
    }

    public Double getDistanciaBucharest() {
        return distanciaBucharest;
    }

    public void setDistanciaBucharest(Double distanciaBucharest) {
        this.distanciaBucharest = distanciaBucharest;
    }
    
    
}
