package gerenciador;

public class Main {
    public static void main(String[] args) {
        GerenciadorAlunos gerenciador = new GerenciadorAlunos();

        gerenciador.adicionarAluno(new Aluno(1, "Ana", 8.5));
        gerenciador.adicionarAluno(new Aluno(2, "Bruno", 6.0));
        gerenciador.adicionarAluno(new Aluno(3, "Carlos", 9.7));
        gerenciador.adicionarAluno(new Aluno(4, "Diana", 7.0));
        gerenciador.adicionarAluno(new Aluno(5, "Eva", 5.5));

        System.out.println("Aluno com maior nota:");
        System.out.println(gerenciador.alunoComMaiorNota());

        gerenciador.gerarRelatorioHTML("relatorio.html");
    }
}
