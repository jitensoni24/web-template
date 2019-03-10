package com.dtech.web.template.resource;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResource {
    @JsonInclude(Include.NON_NULL)
    private Boolean active;

    @JsonInclude(Include.NON_NULL)
    @NotEmpty
    private String username;

    @JsonInclude(Include.NON_NULL)
    private String password;

    @JsonInclude(Include.NON_NULL)
    @Email(message = "validation.email.suffix")
    private String email;
    
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
