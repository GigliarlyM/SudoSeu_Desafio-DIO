package br.gigliarly;

import java.util.HashSet;
import java.util.Set;

public class Quadrante {
    Campo[][] value;

    public Quadrante() {
        this.value = new Campo[3][3];
        for (int line = 0; line < 3; line++) {
            for (int column = 0; column < 3; column++) {
                this.value[line][column] = new Campo(0, false);
            }
        }
    }

    public void verificarNumeros() throws Exception {
        Set<Integer> numValidos = new HashSet<>();
        for (Campo[] listNum : this.value) {
            for (Campo num : listNum) {
                if (num.getValor() != 0) {
                    numValidos.add(num.getValor());
                }
            }
        }

        if (numValidos.size() < 9) {
            throw new Exception("Quadrante incorreto ou incompleto!!❌");
        }
    }

    public Campo getCampo(int line, int column) {
        return this.value[line][column];
    }

    public void setCampo(Campo valor, int line, int column) {
        this.value[line][column] = valor;
    }

    public void inserirValor(int valor, int linha, int coluna) throws Exception {
        this.value[linha][coluna].setValor(valor);
    }

    public void limpar() {
        for (Campo[] campos : this.value) {
            for (Campo campo : campos) {
                if (!campo.isFixo()) {
                    try {
                        campo.setValor(0);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
