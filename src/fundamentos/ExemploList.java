package fundamentos;

import java.util.ArrayList;
import java.util.List;

public class ExemploList {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();
        nomes.add("Ana");
        nomes.add("Carlos");
        nomes.add("João");

        for (String nome : nomes) {
            System.out.println(nome);
        }
    }
}
