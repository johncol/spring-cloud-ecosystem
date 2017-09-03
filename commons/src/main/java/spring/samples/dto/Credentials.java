package spring.samples.dto;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
public class Credentials implements Serializable {

  private static final long serialVersionUID = 3215456465L;

  private String username;
  private String password;

  public Credentials() {
  }

  public Credentials(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
