package com.infoobjects.Entity;
import lombok.Data;
import jakarta.persistence.*;
import java.util.Set;
@Data
@Entity // specify that class is an entity and used to create table
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "username" }),
        @UniqueConstraint(columnNames = { "email" })
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //for the automatic generation of value
    private long id;
    private String name;
    private String username;
    private String email;
    private String password;
}

