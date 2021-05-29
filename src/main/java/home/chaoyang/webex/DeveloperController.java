package home.chaoyang.webex;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeveloperController {
    private final DeveloperRepo repository;

    DeveloperController(DeveloperRepo repository) {
      this.repository = repository;
    }


    @GetMapping("/developers")
    List<Developer> getAll() {
      return repository.findAll();
    }

    @PostMapping("/developers")
    Developer newDeveloper(@RequestBody Developer newDeveloper) {
      return repository.save(newDeveloper);
    }

    @GetMapping("/developers/{id}")
    Developer getDeveloper(@PathVariable Long id) {      
      return repository.findById(id)
        .orElseThrow(() -> new DeveloperNotFoundException(id));
    }

    @PutMapping("/developers/{id}")
    Developer replaceDeveloper(@RequestBody Developer newDeveloper, @PathVariable Long id) {
      
      return repository.findById(id)
        .map(Developer -> {
          Developer.setFirstName(newDeveloper.getFirstName());
          Developer.setLastName(newDeveloper.getLastName());
          return repository.save(Developer);
        })
        .orElseGet(() -> {
          newDeveloper.setId(id);
          return repository.save(newDeveloper);
        });
    }

    @DeleteMapping("/developers/{id}")
    void deleteDeveloper(@PathVariable Long id) {
      repository.deleteById(id);
    }
}
