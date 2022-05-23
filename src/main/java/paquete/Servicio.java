package paquete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class Servicio {
    @Autowired
    List<Persona> personaList;

    public void addPersona(Persona personaInput) {
        personaInput.setId(personaList.stream().count());
        personaList.add(personaInput);
    }

    public Persona findId(Long id) {
        Persona persona = personaList.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
        return persona;
    }

    public Persona findNombre(String name) {
        Persona persona = personaList.stream()
                .filter(p -> p.getNombre().equals(name))
                .findFirst()
                .orElse(null);
        return persona;
    }

    public void update(Persona personaOld, Persona personaNew) {
        Optional<Persona> o = Optional.of(personaNew);

        personaOld.setEdad(o.map(Persona::getEdad).orElse(personaOld.getEdad()));
        personaOld.setNombre(o.map(Persona::getNombre).orElse(personaOld.getNombre()));
        personaOld.setPoblacion(o.map(Persona::getPoblacion).orElse(personaOld.getPoblacion()));

    }

    public void delete(Persona persona) {
        personaList.remove(persona);
    }
}
