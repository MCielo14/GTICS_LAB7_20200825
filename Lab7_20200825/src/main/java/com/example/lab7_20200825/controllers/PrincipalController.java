package com.example.lab7_20200825.controllers;

import com.example.lab7_20200825.entity.Technician;
import com.example.lab7_20200825.repository.TecnicoRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class PrincipalController {
    final TecnicoRepository tecnicoRepository;
    public PrincipalController(TecnicoRepository tecnicoRepository ){
        this.tecnicoRepository = tecnicoRepository;

    }

    @GetMapping("/index")
    String index(){
        return "index";
    }
    @GetMapping("/tecnicos")
    String tecnicos(Model model){
        model.addAttribute("listatecnicos",tecnicoRepository.findAll());
        return "tecnicos";
    }
    @GetMapping("/estadisiticas")
    String est(Model model){
        model.addAttribute("listatecnicos",tecnicoRepository.findAll());
        return "tecnicos";
    }
    @GetMapping("/nuevotecnico")
    public String nuevotecnico(@ModelAttribute("technician") Technician technician, Model model) {
        return "nuevoTecnico";
    }
    @GetMapping("/edits")
    public String editarTecnico(@ModelAttribute("technician") Technician technician,
                                      Model model, @RequestParam("id") int id) {

        Optional<Technician> optional = tecnicoRepository.findById(id);

        if (optional.isPresent()) {
            technician = optional.get();
            model.addAttribute("technician", technician);
            return "nuevoTecnico";
        } else {
            return "redirect:/tecnicos";
        }
    }
    @PostMapping("/save")
    public String guardarProducto(RedirectAttributes attr, Model model,
                                  @ModelAttribute("technician") @Valid Technician technician, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) { //si no hay errores, se realiza el flujo normal


                if (technician.getId() == 0) {
                    String name =technician.getFirstName();
                    String apellido = technician.getLastName();

                    attr.addFlashAttribute("msg", "Técnico" +name +apellido + " creado exitosamente");
                } else {
                    String name =technician.getFirstName();
                    String apellido = technician.getLastName();
                    attr.addFlashAttribute("msg", "Técnico" +name +apellido + " actualizado exitosamente");
                }
                tecnicoRepository.save(technician);
                return "redirect:/tecnicos";


        } else { //hay al menos 1 error
            return "nuevoTecnico";
        }
    }

}
