package br.gigliarly;

import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {
    Quadrante[][] value;
    private Estado status;

    public Tabuleiro(List<CampoFixo> listCampos) {
        this.value = new Quadrante[3][3];
        for (int line = 0; line < 3; line++) {
            for (int column = 0; column < 3; column++) {
                this.value[line][column] = new Quadrante();
            }
        }

        this.status = Estado.NaoIniciado;
        this.iniciarJogo(listCampos);
    }

    private void iniciarJogo(List<CampoFixo> list) {
        for (CampoFixo campoFixo : list) {
            int linhaGlobal = campoFixo.line();
            int colunaGlobal = campoFixo.column();
            int valor = campoFixo.value();

            int quadranteLinha = linhaGlobal / 3;
            int quadranteColuna = colunaGlobal / 3;

            int linhaInterna = linhaGlobal % 3;
            int colunaInterna = colunaGlobal % 3;

            Quadrante quadrante = this.value[quadranteLinha][quadranteColuna];
            Campo campo = new Campo(valor, true);
            quadrante.setCampo(campo, linhaInterna, colunaInterna);
        }
    }

    public List<Integer> resgatarValorLinhas(int linha) {
        int quadrante = linha / 3;
        int linhaInterna = linha % 3;
        List<Integer> result = new ArrayList<>();

        Quadrante[] listValues = this.value[quadrante];
        for (Quadrante quadranteInterno : listValues) {
            for (int c = 0; c < 3; c++) {
                result.add(quadranteInterno.getCampo(linhaInterna, c).getValor());
            }
        }

        return result;
    }

    public void inserirCampo(int valor, int linha, int coluna) throws Exception {
        int quadranteLinha = linha / 3;
        int quadranteColuna = coluna / 3;
        int linhaInterna = linha % 3;
        int colunaInterna = coluna % 3;
        this.value[quadranteLinha][quadranteColuna].inserirValor(valor, linhaInterna, colunaInterna);
        this.status = Estado.Incompleto;
    }

    public void removerCampo(int linha, int coluna) throws Exception {
        this.inserirCampo(0, linha, coluna);
        this.status = Estado.Incompleto;
    }

    public void validar() throws Exception {
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                this.value[linha][coluna].verificarNumeros();
            }
        }
        this.status = Estado.Completo;
    }

    public void limpar() {
        for (Quadrante[] quadrantes : this.value) {
            for (Quadrante quadrante : quadrantes) {
                quadrante.limpar();
            }
        }
    }

    public Estado getStatus() {
        return status;
    }
}
