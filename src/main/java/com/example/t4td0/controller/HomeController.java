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
@RequestMapping("/tarefas") // Mapeia URL que começam com "/tarefas" para este controlador
public class HomeController {

    @Autowired
    private TarefaRepository tarefaRepository; // Injeta uma instancia de TarefaRepository

    @Autowired
    private TarefaValidator tarefaValidator; // Injeta uma instancia de TarefaValidator
   
    
    @InitBinder // Método para inicializar o WebDataBinder
    protected void initBinder(WebDataBinder binder) { // WebDataBinder permite a conexão de dados da web
        binder.setValidator(tarefaValidator); // Define o validador para Tarefa
    }

    @GetMapping // Realiza requisições de busca
    public String listarTarefas(Model model) {  // O objeto Model é usado para passar dados para a visualização (Web/Pagina lista)
        List<Tarefa> tarefas = tarefaRepository.findAll(); // Encontra todas as tarefas do banco de dados
        model.addAttribute("tarefas", tarefas); // Adiciona/Atribui todas as tarefas na lista
        return "home/projeto-tarefas/index"; // Retorna ao HTML de tarefas
    }

    @GetMapping("/new") // Mapeia requisições de busca
    public String cadastrarTarefaPage(Model model) { // Model É um objeto para passar dados para a visualização (da pagina de cadastro)
        model.addAttribute("tarefa", new Tarefa()); // Adiciona uma nova tarefa ao Model (Web/Pagina New)
        return "home/projeto-tarefas/cadastrar-tarefa"; // Retorna ao HTML de cadastrar
    }

    @PostMapping("/new") // Realiza requisições de adicionar
    public String cadastrarTarefa(@Validated @ModelAttribute Tarefa tarefa, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) { // Verifica se tem erro de validação
            return "home/projeto-tarefas/cadastrar-tarefa"; // Se tiver erros ele retorna ao HTML de cadastrar
        }
        tarefaRepository.save(tarefa); // Salva  nova tarefa no banco de dados
        redirectAttributes.addFlashAttribute("cadastroSucesso", true); // Adiciona FLASH para mostrar que a tarefa foi cadastrada com sucesso
        return "redirect:/tarefas/new"; // Redireciona a pagina a pagina de cadastro
    }

    @GetMapping("/{id}/edit") // Realiza requisições de busca
    public String preencherFormularioEdicao(@PathVariable("id") Long id, Model model) { // O objeto Model é usado para passar dados (+id) para a visualização (Web/Pagina Edit)
        Optional<Tarefa> optionalTarefa = tarefaRepository.findById(id); // Chama a tarefa pelo id
        if (optionalTarefa.isPresent()) { // Se a tarefa opicional/selecionada estiver presente 
            model.addAttribute("tarefa", optionalTarefa.get()); // Recupera/seleciona a tarefa ao Model (Web/Pagina Edit)
            return "home/projeto-tarefas/editar-tarefa"; // Retorna ao HTML de editar
        } else {
            return "redirect:/tarefas"; // Se não, redireciona a pagina de tarefas
        }
    }

    @PutMapping("/edit") // Realiza requisições de atualizar
    public String editarTarefa(@Validated @ModelAttribute Tarefa tarefa, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) { // Verifica se tem erro de validação
            return "home/projeto-tarefas/editar-tarefa"; // Retorna ao HTML de editar
        }
        tarefaRepository.save(tarefa); // Salva tarefa no banco de dados
        redirectAttributes.addFlashAttribute("edicaoSucesso", true); // Adiciona FLASH para mostrar que a tarefa foi editada com sucesso
        return "redirect:/tarefas/" + tarefa.getId() + "/edit"; // Redireciona a pagina edição
    }

    @GetMapping("/{id}/destroy") // Realiza requisições de busca
    public String preencherFormularioExclusao(@PathVariable("id") Long id, Model model) { // O objeto Model é usado para passar dados (+ id) para a visualização (Web/Pagina Destroy)
        Optional<Tarefa> optionalTarefa = tarefaRepository.findById(id); // Chama a tarefa pelo id
        if (optionalTarefa.isPresent()) { // Se a tarefa opicional/selecionada estiver presente
            model.addAttribute("tarefa", optionalTarefa.get()); // Recupera/seleciona a tarefa ao Model (Web/Pagina Destroy)
            return "home/projeto-tarefas/excluir-tarefa"; // Retorna ao HTML de excluir
        } else {
            return "redirect:/tarefas"; // Redireciona a pagina tarefas
        }
    }

    @DeleteMapping("/{id}/destroy") // Realiza requisições de excluir
    public String excluirTarefa(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) { 
        tarefaRepository.deleteById(id); // Exclui a tarefa pelo id
        redirectAttributes.addFlashAttribute("exclusaoSucesso", true); // Adiciona FLASH para mostrar que a tarefa foi excluida com sucesso
        return "redirect:/tarefas"; // Redireciona a pagina tarefas
    }

    @GetMapping("/{id}") // Realiza requisições de busca/visualização
    public String preencherFormularioVisualizacao(@PathVariable("id") Long id, Model model) { // O objeto Model é usado para passar dados (+ id) para a visualização (Web/Pagina View)
        Optional<Tarefa> optionalTarefa = tarefaRepository.findById(id); // Chama a tarefa pelo id
        if (optionalTarefa.isPresent()) { // Se a tarefa opicional/selecionada estiver presente
            model.addAttribute("tarefa", optionalTarefa.get()); // Recupera/seleciona a tarefa ao Model (Web/Pagina View)
            return "home/projeto-tarefas/visualizar-tarefa"; // Retorna ao HTML de visualizar
        } else {
            return "redirect:/tarefas"; // Se não redireciona a pagina tarefas
        }
    }
}
