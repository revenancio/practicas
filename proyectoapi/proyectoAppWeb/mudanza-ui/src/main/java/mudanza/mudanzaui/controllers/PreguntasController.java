package mudanza.mudanzaui.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import mudanza.mudanzaui.Clientes.BibliografiasCliente;
import mudanza.mudanzaui.Clientes.PreguntasCliente;
import mudanza.mudanzaui.entidad.preguntas.Preguntas;





@Controller
public class PreguntasController {
    //#region1
    @GetMapping("/preguntas")
    public String getPreguntas(Model model){
        PreguntasCliente pc = new PreguntasCliente();
        model.addAttribute("preguntas",pc.getList());
        return "cuestionario";
    }

    //mostrar el formulario para agregar 
    @GetMapping("/showAddPreguntas")
    public String showAddPreguntas(Preguntas Preguntas) {
        return "Preguntas-add";
    }
    //agregar preguntas
    @PostMapping(value="/addPreguntas")
    public String addPreguntas(@ModelAttribute("preguntas") Preguntas preguntas){
        PreguntasCliente pc = new PreguntasCliente();
        pc.add(preguntas);
        return "redirect:/preguntas";
    }
    //modificar preguntas
    @GetMapping("/showUpdatepreguntas/{id}")
    public String showUpdatepreguntas(@PathVariable(value = "id") long id, Model model) {
        PreguntasCliente pc = new PreguntasCliente();
        Preguntas preguntas = pc.getPreguntasByID(id);
        model.addAttribute("preguntas",preguntas);
        return "preguntas-update";  
    }
    @PostMapping(value="/updatepreguntas/{id}")
    public String updatepreguntas(@PathVariable(value = "id") long id,@ModelAttribute("preguntas") Preguntas preguntas) {
        PreguntasCliente pc = new PreguntasCliente();
        pc.update(id,preguntas);
        return "redirect:/preguntas";
    }


    //#endregion1

     @GetMapping("/")
     public String Menu(){
        return "menu.html";
    }
    @GetMapping("/menu")
    public String Menu1(){
       return "menu.html";
   }
   //#region
    @GetMapping("/bibliografia")
    public String getBibliografia(Model model1){
        BibliografiasCliente pc = new BibliografiasCliente();
        model1.addAttribute("bibliografias",pc.getList());
        return "bibliografia";
    }

    //#endregion
}
