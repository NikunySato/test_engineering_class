package unit;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AvaliadorTest {

    private Avaliador leiloeiro;
    private Usuario joao;
    private Usuario maria;
    private Usuario jose;

    @Before
    public void criaAvaliador() {
        this.leiloeiro = new Avaliador();
        this.joao = new Usuario("João");
        this.jose = new Usuario("José");
        this.maria = new Usuario("Maria");
    }

    @Test
    public void deveEncontrarOsTresMaioresLances() {
        Leilao leilao = new Leilao("Playstation 3 Novo");
        leilao.propoe(new Lance(joao, 100.0));
        leilao.propoe(new Lance(maria, 200.0));
        leilao.propoe(new Lance(joao, 300.0));
        leilao.propoe(new Lance(maria, 400.0));
        leiloeiro.avalia(leilao);
        List<Lance> maiores = leiloeiro.getTresMaiores();
        assertEquals(3, maiores.size());
        assertEquals(400, maiores.get(0).getValor(), 0.00001);
        assertEquals(300, maiores.get(1).getValor(), 0.00001);
        assertEquals(200, maiores.get(2).getValor(), 0.00001);
    }

    @Test
    public void lancesEmOrdemCrescenteTest() {
        Leilao leilao = new Leilao("Playstation 3 Novo");
        leilao.propoe(new Lance(maria, 250.0));
        leilao.propoe(new Lance(joao, 300.0));
        leilao.propoe(new Lance(jose, 400.0));
        leiloeiro.avalia(leilao);
        // Checando os valores esperados
        assertEquals(400.0, leiloeiro.getMaiorLance(), 0.001);
        assertEquals(250.0, leiloeiro.getMenorLance(), 0.001);
    }

    @Test
    public void lancesEmOrdemDecrescenteTest() {
        Leilao leilao = new Leilao("Playstation 3 Novo");
        leilao.propoe(new Lance(jose, 400.0));
        leilao.propoe(new Lance(joao, 300.0));
        leilao.propoe(new Lance(maria, 250.0));
        leiloeiro.avalia(leilao);
        assertEquals(400.0, leiloeiro.getMaiorLance(), 0.001);
        assertEquals(250.0, leiloeiro.getMenorLance(), 0.001);
    }

    @Test
    public void lancesSemOrdemEspecificaTest() {
        Leilao leilao = new Leilao("Playstation 3 Novo");
        leilao.propoe(new Lance(joao, 300.0));
        leilao.propoe(new Lance(jose, 400.0));
        leilao.propoe(new Lance(maria, 250.0));
        leiloeiro.avalia(leilao);
        assertEquals(400.0, leiloeiro.getMaiorLance(), 0.001);
        assertEquals(250.0, leiloeiro.getMenorLance(), 0.001);
    }

    @Test
    public void lancesUnicoTest() {
        Leilao leilao = new Leilao("Playstation 3 Novo");
        leilao.propoe(new Lance(joao, 300.0));
        leiloeiro.avalia(leilao);
        assertEquals(300.0, leiloeiro.getMaiorLance(), 0.0001);
        assertEquals(300.0, leiloeiro.getMenorLance(), 0.0001);
    }
}
