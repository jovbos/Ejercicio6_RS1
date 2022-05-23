package paquete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class Controlador1 {

    @Autowired
    Servicio servicio;

    @RequestMapping(value ="/persona", method= POST)
    @ResponseBody
    public String addpersona(@RequestBody Persona persona) {
        servicio.addPersona(persona);
        return "Persona añadida.";
    }
}
