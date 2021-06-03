package home.chaoyang.webex;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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

    @PatchMapping("/developers/{id}")
    Developer replaceDeveloper(@RequestBody Map<String, Object> updates, @PathVariable Long id) {
      
      Optional<Developer> opt = repository.findById(id);
      if (opt.isEmpty())
          return null;
      final Developer d = opt.get();
      for (Map.Entry<String, Object> e : updates.entrySet()) {
          var k = e.getKey();
          var v = e.getValue();
          switch (k) {
              case "first_name":
                  d.setFirstName((String)v);
                  break;
              case "last_name":
                  d.setLastName((String)v);
                  break;
              case "instagram_username":
                  d.setInstagramUsername((String)v);
                  break;
              case "twitter_username":
                  d.setTwitterUsername((String)v);
                  break;
              case "dev_env":
                  d.setDevEnv((String)v);
                  break;
              case "location":
                  d.setLocation((String)v);
                  break;
              case "registered_at":
                  Instant i = Instant.parse((String)v);
                  d.setRegisteredAt(i);
                  break;
          }
      }
      return repository.save(d);
    }

    @DeleteMapping("/developers/{id}")
    void deleteDeveloper(@PathVariable Long id) {
      repository.deleteById(id);
    }
}
