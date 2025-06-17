package br.gigliarly;

public class Campo {
    private int valor;
    private boolean fixo;

    public Campo(int valor, boolean fixo) {
        this.valor = valor;
        this.fixo = fixo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) throws Exception {
        if (this.fixo) {
            throw new Exception("Esse campo nao pode ser alterado");
        }
        this.valor = valor;
    }

    public boolean isFixo() {
        return fixo;
    }

    @Override
    public String toString() {
        return "Campo{" +
                "valor=" + valor +
                ", fixo=" + fixo +
                '}';
    }
}
