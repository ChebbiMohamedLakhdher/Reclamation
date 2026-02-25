package com.example.reclamationweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reclamations")
public class ReclamationRestController {

    @Autowired
    private IReclamation iReclamation;
    @Autowired
    private ReclamationService reclamationService;

    @GetMapping("/hello")
    public String getTitle() {
        return "Welcome from Candidat4TWIN1";
    }

    // GET http://localhost:8080/candidats
    @GetMapping
    public List<Reclamation> getAllReclamations() {
        return iReclamation.allReclamation();
    }

    // GET http://localhost:8080/candidats/{id}
    @GetMapping("/{id}")
    public Reclamation getReclamation(@PathVariable int id) {
        return iReclamation.getReclamationById(id);
    }

    // POST http://localhost:8080/candidats
    @PostMapping
    public Reclamation addReclamation(@RequestBody Reclamation r) {
        return iReclamation.addReclamation(r);
    }

    // PUT http://localhost:8080/candidats/{id}
    @PutMapping("/{id}")
    public Reclamation updateReclamation(@PathVariable int id,
                                      @RequestBody Reclamation r) {
        return iReclamation.updateReclamation(id, r);
    }

    // DELETE http://localhost:8080/candidats/{id}
    @DeleteMapping("/{id}")
    public void deleteReclamation(@PathVariable int id) {
        iReclamation.deleteReclamation(id);
    }

    @GetMapping("/users")
    public List<User> getAllJobs() {
        return reclamationService.getUsersList();
    }

    @GetMapping("users/[id]")
    public User GetUser(@PathVariable int id) {
        return reclamationService.getUserClient(id);
    }
}
