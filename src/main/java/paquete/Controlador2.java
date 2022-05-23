package paquete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
public class Controlador2 {

    @Autowired
    Servicio servicio;

    @RequestMapping(value ="/persona/{id}", method= PUT)
    @ResponseBody
    public String updatePersona(@PathVariable("id") Long id, @RequestBody Persona personaInput) {
        Persona newPersona = servicio.findId(id);
        servicio.update(newPersona, personaInput);

        return "Persona modificada.";
    }
}
