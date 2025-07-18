package br.edu.ifsuldeminas.mch.springbootcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @GetMapping("/novo")
    public String mostrarFormulario(Time time, Model model) {
        model.addAttribute("campeonatos", campeonatoRepository.findAll());
        return "time_form";
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("times", timeRepository.findAll());
        return "time_list";
    }

    @PostMapping
    public String salvar(@Valid Time time, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("campeonatos", campeonatoRepository.findAll());
            return "time_form";
        }

        boolean isUpdate = time.getId() != null && timeRepository.existsById(time.getId());

        timeRepository.save(time);

        model.addAttribute("successMessage",
            isUpdate ? "✅ Time atualizado com sucesso!" : "✅ Time cadastrado com sucesso!");

        model.addAttribute("time", new Time()); // limpa os campos
        model.addAttribute("campeonatos", campeonatoRepository.findAll());

        return "time_form";
    }


    
    @GetMapping("/update/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Time time = timeRepository.findById(id).orElseThrow();
        model.addAttribute("time", time);
        model.addAttribute("campeonatos", campeonatoRepository.findAll());
        return "time_form";
    }

    @GetMapping("/delete/{id}")
    public String excluir(@PathVariable Long id) {
        timeRepository.deleteById(id);
        return "redirect:/times";
    }


}

