package com.example.t4td0.controller;

import com.example.t4td0.model.Tarefa;
import com.example.t4td0.repository.TarefaRepository;
import com.example.t4td0.validator.TarefaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller // Anotação que define que esta classe é um controlador
@RequestMapping("/tarefas") // Mapeia URLs que começam com "/tarefas" para este controlador.
public class HomeController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private TarefaValidator tarefaValidator;
    // Anotação que indica ao Spring para injetar instâncias de TarefaRepository e TarefaValidator automaticamente.
    
    @InitBinder // @InitBinder = Método que é chamado para inicializar o binder que realiza a vinculação de dados da web.
    protected void initBinder(WebDataBinder binder) {  // WebDataBinder = Interface que permite a personalização da vinculação de dados da web.
        binder.setValidator(tarefaValidator);
    }

    @GetMapping
    public String listarTarefas(Model model) {  //model É um Objeto do tipo Model usado para passar dados para a visualização.
        List<Tarefa> tarefas = tarefaRepository.findAll(); // tarefas É uma lista de objetos do tipo Tarefa que contém todas as tarefas recuperadas do banco de dados.
        model.addAttribute("tarefas", tarefas);
        return "home/projeto-tarefas/index";
    }

    @GetMapping("/new")
    public String cadastrarTarefaPage(Model model) { //model É um Objeto do tipo Model usado para passar dados para a visualização.
        model.addAttribute("tarefa", new Tarefa());
        return "home/projeto-tarefas/cadastrar-tarefa";
    }

    @PostMapping("/new")
    public String cadastrarTarefa(@Validated @ModelAttribute Tarefa tarefa, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "home/projeto-tarefas/cadastrar-tarefa";
        }
        tarefaRepository.save(tarefa);
        redirectAttributes.addFlashAttribute("cadastroSucesso", true);
        return "redirect:/tarefas/new";
    }

    @GetMapping("/{id}/edit")
    public String preencherFormularioEdicao(@PathVariable("id") Long id, Model model) {
        Optional<Tarefa> optionalTarefa = tarefaRepository.findById(id);
        if (optionalTarefa.isPresent()) {
            model.addAttribute("tarefa", optionalTarefa.get());
            return "home/projeto-tarefas/editar-tarefa";
        } else {
            return "redirect:/tarefas";
        }
    }

    @PostMapping("/edit")
    public String editarTarefa(@Validated @ModelAttribute Tarefa tarefa, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "home/projeto-tarefas/editar-tarefa";
        }
        tarefaRepository.save(tarefa);
        redirectAttributes.addFlashAttribute("edicaoSucesso", true);
        return "redirect:/tarefas/" + tarefa.getId() + "/edit";
    }

    @GetMapping("/{id}/destroy")
    public String preencherFormularioExclusao(@PathVariable("id") Long id, Model model) {
        Optional<Tarefa> optionalTarefa = tarefaRepository.findById(id);
        if (optionalTarefa.isPresent()) {
            model.addAttribute("tarefa", optionalTarefa.get());
            return "home/projeto-tarefas/excluir-tarefa";
        } else {
            return "redirect:/tarefas";
        }
    }

    @PostMapping("/{id}/destroy")
    public String excluirTarefa(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        tarefaRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("exclusaoSucesso", true);
        return "redirect:/tarefas";
    }

    @GetMapping("/{id}")
    public String preencherFormularioVisualizacao(@PathVariable("id") Long id, Model model) {
        Optional<Tarefa> optionalTarefa = tarefaRepository.findById(id);
        if (optionalTarefa.isPresent()) {
            model.addAttribute("tarefa", optionalTarefa.get());
            return "home/projeto-tarefas/visualizar-tarefa";
        } else {
            return "redirect:/tarefas";
        }
    }
}
