package br.edu.ifsuldeminas.mch.springbootcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        return "campeonatos/lista";
    }

    @GetMapping("/novo")
    public String mostrarFormulario(Campeonato campeonato) {
        return "campeonatos/formulario";
    }

    @PostMapping
    public String salvar(@Valid Campeonato campeonato, BindingResult result) {
        if (result.hasErrors()) {
            return "campeonatos/formulario";
        }
        campeonatoRepository.save(campeonato);
        return "redirect:/campeonatos";
    }
}

