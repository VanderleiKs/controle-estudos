package com.vsystem.controle_estudos;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import io.github.wimdeblauwe.htmx.spring.boot.mvc.HtmxResponse;

@Controller
public class controller {

    @Autowired
    private MaterialService materialService;

    @GetMapping(path = "/")
	String user(Model model) {
		model.addAttribute("message", "Bem-vindo ao Controle de Estudos!");
		model.addAttribute("time", new Date());
        model.addAttribute("materiais", materialService.getMaterials());
		return "index";
	}

    @PostMapping(path = "/newMateria")
    public String newMateria(@RequestParam String nome, Model model){
            Materia material = new Materia();
            /* material.setNome(nome.split("=")[1]); */
            material.setNome(nome);
            material.setHorasEstudo(0);
            material.setNumeroQuestoesResolvidas(0);
            material.setNumeroQuestoesAcertadas(0);
            materialService.saveMaterial(material);

            model.addAttribute("materiais", materialService.getMaterials());
        return "redirect:/";
    }

    @GetMapping(path = "/addMateria")
    public String addMateria(Model model){
        model.addAttribute("title", "Adicionar Matéria");
        return "cadastroMateria";
    }

    @GetMapping(path = "/deleteMateria")
    public String deleteMateria(@RequestParam Integer id, Model model){
        materialService.deleteMaterial(id);
        return "redirect:/";
    }

    @GetMapping(path = "/editMateria")
    public String editMateria(@RequestParam Integer id, Model model){
        Materia material = materialService.getMaterialById(id);
        model.addAttribute("material", material);
        return "cadastroMateria";
    }

    @PostMapping(path = "/updateMateria")
    public String updateMateria(@RequestParam Integer id, @RequestParam String nome, Model model){
        Materia material = materialService.getMaterialById(id);
        material.setNome(nome);
        materialService.saveMaterial(material);
        return "redirect:/";
    }

    @GetMapping("/about")
    public String about()  {
        return "about";
    }

    @GetMapping("/modal")
    public String modal(@RequestParam(required = false) String title, Model model) {
        model.addAttribute("title", title);
        return "modal";
    }

    @GetMapping(path = "/greet")
    String nameHtmx(Map<String, Object> model) {
	    greet(model, "World");
        return "greet";
    }

    @PostMapping(path = "/greet")
    String nameHtmx(Map<String, Object> model, @RequestParam String name) {
	    greet(model, name);
        return "greet";
    }
    
        @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    private void greet(Map<String, Object> model, String name) {
        String greeting = "Hello, " + name + "!";
        model.put("greeting", greeting);
        model.put("time", java.time.LocalTime.now().toString());
    }
}

