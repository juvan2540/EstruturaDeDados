package fundamentos;

import gerenciador.Aluno;
import java.io.*;
import java.awt.Desktop;
import java.util.Map;

public class Sistema {
    private Map<Integer, Aluno> alunos;

    public Sistema(Map<Integer, Aluno> alunos) {
        this.alunos = alunos;
    }

    public void gerarRelatorioHTMLComEstilo(String caminhoHTML, String caminhoCSS) {
        try {
            File htmlFile = new File(caminhoHTML);
            File cssFile = new File(caminhoCSS);
            if (htmlFile.getParentFile() != null) htmlFile.getParentFile().mkdirs();
            if (cssFile.getParentFile() != null) cssFile.getParentFile().mkdirs();

            // Gerar CSS
            try (PrintWriter cssWriter = new PrintWriter(cssFile)) {
                cssWriter.println("body { font-family: Arial, sans-serif; background: #f9f9f9; padding: 20px; }");
                cssWriter.println("h1 { color: #2c3e50; }");
                cssWriter.println("table { border-collapse: collapse; width: 100%; max-width: 600px; margin: 20px 0; }");
                cssWriter.println("th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }");
                cssWriter.println("th { background-color: #3498db; color: white; }");
                cssWriter.println("tr:nth-child(even) { background-color: #f2f2f2; }");
                cssWriter.println("tr:hover { background-color: #d1e7fd; }");
            }

            // Gerar HTML
            try (PrintWriter writer = new PrintWriter(htmlFile)) {
                writer.println("<!DOCTYPE html>");
                writer.println("<html lang=\"pt-BR\">");
                writer.println("<head>");
                writer.printf("<meta charset=\"UTF-8\">\n<title>Relatório de Alunos</title>\n");
                writer.printf("<link rel=\"stylesheet\" href=\"%s\">\n", cssFile.getName());
                writer.println("</head>");
                writer.println("<body>");
                writer.println("<h1>Relatório de Alunos</h1>");
                writer.println("<table>");
                writer.println("<thead><tr><th>ID</th><th>Nome</th><th>Nota</th></tr></thead>");
                writer.println("<tbody>");
                for (Aluno aluno : alunos.values()) {
                    writer.printf("<tr><td>%d</td><td>%s</td><td>%.1f</td></tr>\n",
                                  aluno.getId(), aluno.getNome(), aluno.getNota());
                }
                writer.println("</tbody>");
                writer.println("</table>");
                writer.println("</body>");
                writer.println("</html>");
            }

            System.out.println("✅ Arquivos HTML e CSS gerados com sucesso!");

            // Abre no navegador
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(htmlFile.toURI());
                System.out.println("🧭 Abrindo relatório no navegador...");
            } else {
                System.out.println("⚠️ Desktop não suportado. Caminho: " + htmlFile.getAbsolutePath());
            }

        } catch (IOException e) {
            System.out.println("❌ Erro ao gerar relatório: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Exemplo: criar e popular o mapa de alunos
        Map<Integer, Aluno> alunos = new java.util.HashMap<>();
        alunos.put(1, new Aluno(1, "Ana", 8.5));
        alunos.put(2, new Aluno(2, "Carlos", 7.3));
        alunos.put(3, new Aluno(3, "João", 9.1));

        Sistema sistema = new Sistema(alunos);
        sistema.gerarRelatorioHTMLComEstilo("relatorios/relatorio.html", "relatorios/estilo.css");

        System.out.println("Relatório gerado com sucesso!");
    }
}
