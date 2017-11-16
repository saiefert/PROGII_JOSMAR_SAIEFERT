package bancoGUI;

import java.util.Scanner;

public class Usuario {
    private String nome;
    private String sobrenome;

    Scanner sc = new Scanner(System.in);

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;

    }
}
