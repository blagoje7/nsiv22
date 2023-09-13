package in.bushansirgur.expensetrackerapi.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "req_name")
    @NotBlank(message = "Requirement name must not be null")
    @Size(min = 3, message = "Requirement name must be at least 3 characters")
    private String name;

    @Column
    private String description;



}
