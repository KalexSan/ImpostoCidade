import java.math.BigDecimal;

public class Product {
 
    private String nome;
    private BigDecimal peso;
    private BigDecimal volume;

    public Product(String nome, BigDecimal peso, BigDecimal volume) {
        this.nome = nome;
        this.peso = peso;
        this.volume = volume;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

}
