package co.istad.kh.exercise.students;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    Optional<StudentEntity> findByEmailAndClassroom_ClassCode(String email, String classCode);
}
