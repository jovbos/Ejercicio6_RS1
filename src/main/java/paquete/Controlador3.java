package paquete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;

@RestController
public class Controlador3 {

    @Autowired
    Servicio servicio;

    @RequestMapping(value ="/persona/{id}", method= DELETE)
    @ResponseBody
    public String deletePersona(@PathVariable("id") Long id) {
        servicio.delete(servicio.findId(id));
        return "Persona borrada.";
    }

}
