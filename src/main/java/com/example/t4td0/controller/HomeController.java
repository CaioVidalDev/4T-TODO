package com.example.t4td0.controller;

import com.example.t4td0.model.Tarefa;
import com.example.t4td0.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tarefas")
public class HomeController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @GetMapping
    public String index(Model model) {
        List<Tarefa> tarefas = tarefaRepository.findAll();
        model.addAttribute("tarefas", tarefas);
        return "home/projeto-tarefas/index";
    }

    @GetMapping("/new")
    public String cadastrarTarefaPage(Model model) {
        model.addAttribute("tarefa", new Tarefa());
        return "home/projeto-tarefas/cadastrar-tarefa";
    }

    @PostMapping("/new")
    public String cadastrarTarefa(@ModelAttribute Tarefa tarefa) {
        if (tarefa != null && tarefa.getTitulo() != null && !tarefa.getTitulo().isEmpty()) {
            tarefaRepository.save(tarefa);
        }
        return "redirect:/tarefas";
    }

    @GetMapping("/{id}/edit")
    public String preencherFormularioEdicao(@PathVariable("id") Long id, Model model) {
        Tarefa tarefa = tarefaRepository.findById(id).orElse(null);
        if (tarefa != null) {
            model.addAttribute("tarefa", tarefa);
            return "home/projeto-tarefas/editar-tarefa";
        } else {
            return "redirect:/tarefas";
        }
    }

    @PostMapping("/edit")
    public String editarTarefa(@ModelAttribute Tarefa tarefa) {
        if (tarefa != null) {
            tarefaRepository.save(tarefa);
        }
        return "redirect:/tarefas";
    }

    @GetMapping("/{id}/destroy")
    public String preencherFormularioExclusao(@PathVariable("id") Long id, Model model) {
        Tarefa tarefa = tarefaRepository.findById(id).orElse(null);
        if (tarefa != null) {
            model.addAttribute("tarefa", tarefa);
            return "home/projeto-tarefas/excluir-tarefa";
        } else {
            return "redirect:/tarefas";
        }
    }

    @PostMapping("/destroy")
    public String excluirTarefa(@RequestParam("id") Long id) {
        tarefaRepository.deleteById(id);
        return "redirect:/tarefas";
    }

    @GetMapping("/{id}")
    public String preencherFormularioVisualizacao(@PathVariable("id") Long id, Model model) {
        Tarefa tarefa = tarefaRepository.findById(id).orElse(null);
        if (tarefa != null) {
            model.addAttribute("tarefa", tarefa);
            return "home/projeto-tarefas/visualizar-tarefa";
        } else {
            return "redirect:/tarefas";
        }
    }
}


