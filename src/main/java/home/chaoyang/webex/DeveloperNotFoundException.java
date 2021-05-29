package home.chaoyang.webex;

public class DeveloperNotFoundException  extends RuntimeException {
    DeveloperNotFoundException(Long id) {
        super("Could not find developer " + id);
      }
}
