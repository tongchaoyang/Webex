package home.chaoyang.webex;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor 
public class Developer implements Serializable {
    private @Id @GeneratedValue Long id;
    @Column(name="first_name", length=50, nullable=false)
    private String firstName;
    @Column(name="last_name", length=50, nullable=false)
    private String lastName;
    @Column(name="instagram_username", length=50, nullable=true)
    private String instagramUsername;
    @Column(name="twitter_username", length=50, nullable=true)
    private String twitterUsername;
    @Column(name="dev_env", length=100, nullable=true)
    private String devEnv;
    @Column(length=100, nullable=false)
    private String location;
    @Column(name="registered_at")
    @Temporal(TemporalType.DATE)
    private Date registeredAt;
    
    public Developer(String fn, String ln, String in, String tn, 
            String env, String loc, Date at) {
        this.firstName = fn;
        this.lastName = ln;
        this.instagramUsername = in;
        this.twitterUsername = tn;
        this.devEnv = env;
        this.location = loc;
        this.registeredAt = at;
    }
}
