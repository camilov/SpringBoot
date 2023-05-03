package mx.com.gm.web;


import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.dao.IClientesDao;
import mx.com.gm.domain.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import mx.com.gm.servicio.ClientesService;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *
 * @author Janus
 */
@Controller
@Slf4j
public class ControladorInicio {
    
    @Autowired
    private ClientesService clientesService;
    
     @GetMapping("/")
     public String inicio(Model model){
         
         var clientes = clientesService.listarClientes();
         model.addAttribute("clientes",clientes);
         log.info("Ejecutando el controlador Spring 2");
         return "index";
     }
     
     @GetMapping("/agregar")
     public String agregar(Clientes clientes){
         return "modificar";
     }
     
     //@RequestMapping(value= "/guardar", method={RequestMethod.GET,RequestMethod.POST})
     @PostMapping("/guardar")
     public String guardar(@RequestBody @Valid  Clientes clientes, Errors errors){
         
         log.info("antes de rretornar modificar: ");
        if(errors.hasErrors()){
        
            return "modificar";
        }
        log.info("antes de guardar: ");
        clientesService.guardar(clientes);
        log.info("clientes guardar: "+clientes);
        return "redirect:/";
     }
     
     @GetMapping("/editar")
     public String Editar(Clientes clientes, Model model){
        clientes = clientesService.encontrarCliente(clientes);
        log.info("clientes: "+clientes);
        model.addAttribute("clientes",clientes);
        
        return "modificar";
     }
     
     
     @GetMapping("/eliminar")
     public String eliminar(Clientes clientes){
        clientesService.eliminar(clientes);
        return "redirect:/";
     }

     
     
}
