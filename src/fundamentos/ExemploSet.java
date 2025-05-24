package fundamentos;

import java.util.HashSet;
import java.util.Set;

public class ExemploSet {
    public static void main(String[] args) {
        Set<String> cores = new HashSet<>();
        cores.add("Azul");
        cores.add("Vermelho");
        cores.add("Verde");
        cores.add("Azul"); // duplicado, não será adicionado

        for (String cor : cores) {
            System.out.println(cor);
        }
    }
}
