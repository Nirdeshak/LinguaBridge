package com.example.EnglishApp.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "Users.GetAllUsers", procedureName = "GetAllUsers", resultClasses = Users.class),
        @NamedStoredProcedureQuery(name = "Users.GetUsersById", procedureName = "GetUsersById", parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "uUserId", type = Integer.class)
        }, resultClasses = Users.class),
        @NamedStoredProcedureQuery(name = "Users.InsertUsers", procedureName = "InsertUsers", parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "uName", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "uEmail", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "uPhone", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "uusername", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "upassword_hash", type = String.class),
        }, resultClasses = Users.class),

        @NamedStoredProcedureQuery(name = "Users.UpdateUsers", procedureName = "UpdateUsers", parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "uUserId", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "uName", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "uEmail", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "uPhone", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "uusername", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "upassword_hash", type = String.class),
        }, resultClasses = Users.class),

})
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column
    private Integer userid;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private String username;
    @Column
    private String password_hash;
    @Column
    private LocalDateTime createon;
}
