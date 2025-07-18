package br.edu.ifsuldeminas.mch.springbootcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifsuldeminas.mch.springbootcrud.model.entity.Campeonato;
import br.edu.ifsuldeminas.mch.springbootcrud.model.repository.CampeonatoRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/campeonatos")
public class CampeonatoController {

    @Autowired
    private CampeonatoRepository campeonatoRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("campeonatos", campeonatoRepository.findAll());
        return "campeonato_list"; 
    }


    @GetMapping("/novo")
    public String mostrarFormulario(Campeonato campeonato) {
        return "campeonato_form"; 
    }

    @PostMapping
    public String salvar(@Valid Campeonato campeonato, BindingResult result, Model model, RedirectAttributes redirectAttrs) {
        if (result.hasErrors()) {
            return "campeonato_form";
        }

        campeonatoRepository.save(campeonato);
        model.addAttribute("campeonato", new Campeonato()); 
        model.addAttribute("successMessage", "Campeonato salvo com sucesso!");
        return "campeonato_form";
    }
    
    @GetMapping("/{id}")
    public String detalhes(@PathVariable Long id, Model model) {
        Campeonato campeonato = campeonatoRepository.findById(id).orElseThrow();
        model.addAttribute("campeonato", campeonato);
        model.addAttribute("times", campeonato.getTimes());
        return "campeonato_detalhes";
    }


}

