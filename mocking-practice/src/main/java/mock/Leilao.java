package mock;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Leilao {

    private Long id;

    private String nomeProduto;

    private boolean encerrado;

    private Calendar data;

    public Leilao(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public void encerra() {
        encerrado = true;
    }

    public void setEncerrado(boolean encerrado) {
        this.encerrado = encerrado;
    }

    public boolean isEncerrado() {
        return encerrado;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Calendar getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Leilao{" +
                "id=" + id +
                ", nomeProduto='" + nomeProduto + '\'' +
                ", encerrado=" + encerrado +
                ", data=" + new SimpleDateFormat("dd/MM/yyyy").format(data.getTime()) +
                '}';
    }
}
