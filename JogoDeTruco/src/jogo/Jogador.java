package jogo;

import comunicacao.ControladorConexao;
import comunicacao.Mensagem;
import comunicacao.transporte.JogadorInfo;
import enums.Carta;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @class Jogador
 * @author Alencar Rodrigo Hentges <alencarhentges@gmail.com>
 * @date 30/03/2017
 */
public class Jogador implements Serializable {

    private final Long idJogador;
    private final ControladorConexao<Mensagem> conexao;
    private String nomeJogador;
    private int tentos;
    private List<Carta> cartas;

    public Jogador(Long idPlayer, String nome, ControladorConexao conexao) {
        this.idJogador = idPlayer;
        this.nomeJogador = nome;
        this.conexao = conexao;
        this.tentos = 0;
    }

    public Long getIdJogador() {
        return idJogador;
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }

    public int getTentos() {
        return tentos;
    }

    public void setTentos(int tentos) {
        this.tentos = tentos;
    }

    public ControladorConexao<Mensagem> getConexao() {
        return conexao;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public JogadorInfo getInfoJogador() {
        return new JogadorInfo(this);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jogador other = (Jogador) obj;
        return Objects.equals(this.conexao, other.conexao);
    }

    @Override
    public String toString() {
        return "Jogador{" + "idJogador=" + idJogador + ", nomeJogador=" + nomeJogador + ", tentos=" + tentos + '}';
    }

    public void addTentos(int tentos) {
        this.tentos += tentos;
    }

}
