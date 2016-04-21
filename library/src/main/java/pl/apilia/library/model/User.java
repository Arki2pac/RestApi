package pl.apilia.library.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Email;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Data;

/**
 * Created by Grzegorz on 2016-04-19.
 */
@Entity
@Data
@Table(name = "library_users")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String login;

    @NotNull
    private String surName;

    @Email
    @NotNull
    @Column(unique = true)
    private String email;

    @JsonIgnore
    private String password;

    @Pattern(regexp = "^[0-9]{6,14}$")
    private String mobilePhoneNumber;

    @NotNull
    private String role;
}
