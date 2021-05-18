package com.example.demo.Model;
import lombok.*;
import java.util.Date;
import java.util.List;
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User {
    private Integer id;
    private String name;
    private Date birthDate;
}
