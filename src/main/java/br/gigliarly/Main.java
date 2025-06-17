package br.gigliarly;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- 🫡 Bem-vindo ao SudoSeu 🫡 ---");

        IniciadorJogo iniciador = new IniciadorJogo();
        List<CampoFixo> valoresFixos = iniciador.iniciarJogo();
        Tabuleiro tabuleiro = new Tabuleiro(valoresFixos);
        boolean closedGame = false;

        do {
            showTab(tabuleiro);
            String opcoa = iniciador.mostrarOpcoes();
            try {
                switch (opcoa) {
                    case "1.1": {
                        String inserirValor = iniciador.input("Numero (valor,linha,coluna): ", 5);
                        int valor = Integer.parseInt(inserirValor.substring(0, 1));
                        int linha = Integer.parseInt(inserirValor.substring(2, 3));
                        int coluna = Integer.parseInt(inserirValor.substring(4));
                        System.out.println(inserirValor);
                        tabuleiro.inserirCampo(valor, linha, coluna);
                        break;
                    }
                    case "1.2": {
                        String remover = iniciador.input("Numero (linha,coluna): ", 3);
                        int linha = Integer.parseInt(remover.substring(0, 1));
                        int coluna = Integer.parseInt(remover.substring(2));
                        System.out.println(remover);
                        tabuleiro.removerCampo(linha, coluna);
                        break;
                    }
                    case "2": {
                        tabuleiro.validar();
                        closedGame = true;
                        break;
                    }
                    case "3": {
                        tabuleiro.limpar();
                        break;
                    }
                    default: {
                        System.out.println("Opcao nao corespondida!");
                        closedGame = true;
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!closedGame);
    }

    public static void showTab(Tabuleiro tabuleiro) {
        System.out.println("Visualizando tabuleiro 👻!!");
        System.out.println("------ ------ ------");
        for (int i = 0; i < 9; i++) {
            List<Integer> linha = tabuleiro.resgatarValorLinhas(i);
            StringBuilder linhaStr = new StringBuilder();
            int numerosColocados = 1;
            for (int num : linha) {
                linhaStr.append(num);
                linhaStr.append(" ");
                if (numerosColocados % 3 == 0 && numerosColocados != 9) {
                    linhaStr.append("|");
                }
                numerosColocados++;
            }

            System.out.println(linhaStr);
            if (i % 3 == 2) {
                System.out.println("------ ------ ------");
            }
        }

        if (tabuleiro.getStatus() == Estado.Completo){
            System.out.println("✅✅ TABULEIRO COMPLETO ✅✅");
        }
    }
}