package paquete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class Controlador4 {

    @Autowired
    Servicio servicio;

    @RequestMapping(value = "/persona/{id}", method= GET)
    @ResponseBody
    public Persona lookPersonaId(@PathVariable("id") Long id) {
        return servicio.findId(id);
    }
    @RequestMapping(value = "/nombre/{nombre}", method = GET)
    public Persona lookPersonaNombre(@PathVariable("nombre") String name) {
        return servicio.findNombre(name);
    }
}
