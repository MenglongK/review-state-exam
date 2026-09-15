package co.istad.kh.exercise.classrooms;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "classrooms")
public class ClassroomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(name = "class_code", nullable = false, unique = true)
    private String classCode;
    @NotBlank
    @Column(name = "subject", nullable = false)
    private String subject;
    @NotNull
    @Column(name = "status", nullable = false)
    private Boolean status;
}
