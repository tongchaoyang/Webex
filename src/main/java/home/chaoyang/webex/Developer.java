package home.chaoyang.webex;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor 
public class Developer implements Serializable {
    private @Id @GeneratedValue Long id;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("instagram_username")
    private String instagramUsername;
    @JsonProperty("twitter_username")
    private String twitterUsername;
    @JsonProperty("dev_env")
    private String devEnv;
    private String location;
    @JsonProperty("registered_at")
    private Instant registeredAt;
    
    public Developer(String fn, String ln, String in, String tn, 
            String env, String loc, Instant at) {
        this.firstName = fn;
        this.lastName = ln;
        this.instagramUsername = in;
        this.twitterUsername = tn;
        this.devEnv = env;
        this.location = loc;
        this.registeredAt = at;
    }
}
