package br.gigliarly;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IniciadorJogo {
    private String opcoes = "Opções:\n1 Editar\n2 Finalizar\n3 Recomeçar";
    private String opcoes2 = "Editar:\n1.1 Inserir\n1.2 Remover";
    private Scanner sc = new Scanner(System.in);

    public List<CampoFixo> iniciarJogo() {
        List<CampoFixo> valoresFixos = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            CampoFixo campoFixo = new CampoFixo(i+1, i, i);
            valoresFixos.add(campoFixo);
        }

        return valoresFixos;
    }

    public String mostrarOpcoes() {
        System.out.println(opcoes);
        System.out.println(opcoes2);

        return sc.next();
    }

    public String input(String msg, int limit) throws Exception {
        System.out.print(msg);
        String result = sc.next();
        if (result.length() != limit) {
            throw new Exception("Formato invalido!");
        }
        return result;
    }

    public void disableScanner() {
        sc.close();
    }
}
