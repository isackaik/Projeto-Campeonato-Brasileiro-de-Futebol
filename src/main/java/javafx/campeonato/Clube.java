package javafx.campeonato;

// TODO: Auto-generated Javadoc
/**
 * The Class Clube.
 */
public class Clube {

    /** The nome. */
    private String nome;



    /** The derrotas. */
    private int posicao, pontos, jogos, vitorias, empates, derrotas;

    /**
     * Instantiates a new clube.
     *
     * @param posicao the posicao
     * @param nome the nome
     * @param pontos the pontos
     * @param jogos the jogos
     * @param vitorias the vitorias
     * @param empates the empates
     * @param derrotas the derrotas
     */
    public Clube(int posicao, String nome, int pontos, int jogos, int vitorias, int empates, int derrotas) {
        this.posicao = posicao;
        this.nome = nome;
        this.pontos = pontos;
        this.jogos = jogos;
        this.vitorias = vitorias;
        this.empates = empates;
        this.derrotas = derrotas;
    }

    /**
     * Gets the posicao.
     *
     * @return the posicao
     */
    public int getPosicao() {
        return posicao;
    }

    /**
     * Gets the nome.
     *
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Gets the pontos.
     *
     * @return the pontos
     */
    public int getPontos() {
        return pontos;
    }

    /**
     * Gets the jogos.
     *
     * @return the jogos
     */
    public int getJogos() {
        return jogos;
    }

    /**
     * Gets the vitorias.
     *
     * @return the vitorias
     */
    public int getVitorias() {
        return vitorias;
    }

    /**
     * Gets the empates.
     *
     * @return the empates
     */
    public int getEmpates() {
        return empates;
    }

    /**
     * Gets the derrotas.
     *
     * @return the derrotas
     */
    public int getDerrotas() {
        return derrotas;
    }
}
