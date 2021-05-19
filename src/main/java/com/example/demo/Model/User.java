package com.example.demo.Model;
import lombok.*;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User {
    private Integer id;
    @Size(min = 2, message = "Name should habe at least 2 characters!")
    private String name;
    @Past()
    private Date birthDate;
}
