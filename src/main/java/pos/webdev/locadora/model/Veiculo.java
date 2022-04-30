package pos.webdev.locadora.model;

import javax.persistence.*;

@Entity
public class Veiculo {
    
    @Id
    @GeneratedValue
    private Long id;
    private String modelo;
    private String fabricante;
    private String ano;
    private String cor;

    public Veiculo() { super(); }
    public Veiculo(String modelo, String fabricante, String ano, String cor) {
        this.setModelo(modelo);
        this.setFabricante(fabricante);
        this.setAno(ano);
        this.setCor(cor);
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getFabricante() { return fabricante; }
    public void setFabricante(String fabricante) { this.fabricante = fabricante; }

    public String getAno() { return ano; }
    public void setAno(String ano) { this.ano = ano; }

    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }
}
