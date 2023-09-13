package in.bushansirgur.expensetrackerapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_category")
public class Category {

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
