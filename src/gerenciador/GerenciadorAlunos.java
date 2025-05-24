package gerenciador;

import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;



public class GerenciadorAlunos {
    private Map<Integer, Aluno> alunos = new HashMap<>();

    public boolean adicionarAluno(Aluno aluno) {
        if (alunos.containsKey(aluno.getId())) {
            return false;
        }
        alunos.put(aluno.getId(), aluno);
        return true;
    }

    public Collection<Aluno> listarAlunos() {
        return alunos.values();
    }

    public Aluno alunoComMaiorNota() {
        if (alunos.isEmpty()) {
            return null;
        }

        Aluno melhorAluno = null;
        for (Aluno aluno : alunos.values()) {
            if (melhorAluno == null || aluno.getNota() > melhorAluno.getNota()) {
                melhorAluno = aluno;
            }
        }
        return melhorAluno;
    }

    public void gerarRelatorioHTML(String caminhoArquivo) {
        try (PrintWriter writer = new PrintWriter(caminhoArquivo)) {
            writer.println("<html>");
            writer.println("<head><title>Relatório de Alunos</title>");
            writer.println("<style>");
            writer.println("body { font-family: Arial, sans-serif; background: #f0f0f0; padding: 20px; }");
            writer.println("h1 { color: #333; }");
            writer.println("table { width: 100%; border-collapse: collapse; margin-top: 20px; }");
            writer.println("th, td { border: 1px solid #ccc; padding: 8px; text-align: left; }");
            writer.println("th { background-color: #4CAF50; color: white; }");
            writer.println("tr:nth-child(even) { background-color: #e9f5e9; }");
            writer.println("</style>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<h1>Relatório de Alunos</h1>");
            writer.println("<table>");
            writer.println("<tr><th>ID</th><th>Nome</th><th>Nota</th></tr>");
            for (Aluno aluno : alunos.values()) {
                writer.printf("<tr><td>%d</td><td>%s</td><td>%.1f</td></tr>%n",
                    aluno.getId(), aluno.getNome(), aluno.getNota());
            }
            writer.println("</table>");
            writer.println("</body>");
            writer.println("</html>");
            System.out.println("Arquivo HTML gerado com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
