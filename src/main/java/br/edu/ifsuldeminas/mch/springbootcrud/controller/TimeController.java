package br.edu.ifsuldeminas.mch.springbootcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifsuldeminas.mch.springbootcrud.model.entity.Time;
import br.edu.ifsuldeminas.mch.springbootcrud.model.repository.CampeonatoRepository;
import br.edu.ifsuldeminas.mch.springbootcrud.model.repository.TimeRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/times")
public class TimeController {

    @Autowired
    private TimeRepository timeRepository;

    @Autowired
    private CampeonatoRepository campeonatoRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("times", timeRepository.findAll());
        return "times/lista";
    }

    @GetMapping("/novo")
    public String mostrarFormulario(Time time, Model model) {
        model.addAttribute("campeonatos", campeonatoRepository.findAll());
        return "times/formulario";
    }

    @PostMapping
    public String salvar(@Valid Time time, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("campeonatos", campeonatoRepository.findAll());
            return "times/formulario";
        }
        timeRepository.save(time);
        return "redirect:/times";
    }
}

