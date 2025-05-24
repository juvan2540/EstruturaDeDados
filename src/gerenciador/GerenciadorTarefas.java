package gerenciador;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GerenciadorTarefas {
    private List<Tarefa> listaTarefas = new ArrayList<>();
    private Set<Tarefa> setTarefas = new HashSet<>();

    public boolean adicionarTarefa(Tarefa tarefa) {
        if(setTarefas.add(tarefa)) {   // só adiciona se não existir
            listaTarefas.add(tarefa);
            return true;
        }
        return false;
    }

    public boolean removerTarefa(Tarefa tarefa) {
        if(setTarefas.remove(tarefa)) {
            listaTarefas.remove(tarefa);
            return true;
        }
        return false;
    }

    public List<Tarefa> listarTarefas() {
        return listaTarefas;
    }
}
