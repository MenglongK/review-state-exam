package co.istad.kh.exercise.students;

import co.istad.kh.exercise.classrooms.ClassroomEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "students")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @ManyToOne
    @JoinColumn(name = "classroom", referencedColumnName = "class_code")
    private ClassroomEntity classroom;
}
