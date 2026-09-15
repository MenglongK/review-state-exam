package co.istad.kh.exercise.students;

import co.istad.kh.exercise.classrooms.ClassroomEntity;
import co.istad.kh.exercise.classrooms.ClassroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ClassroomRepository classroomRepository;

    @Override
    public void addNewStudent(StudentRequest studentRequest) {

        ClassroomEntity classroom = classroomRepository.findByClassCode(studentRequest.classCode()).orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT, "Classroom already exists"));

        studentRepository.findByEmailAndClassroom_ClassCode(studentRequest.email(), studentRequest.classCode()).ifPresent(existing -> {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Student already exists in this classroom");
        });

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setEmail(studentRequest.email());
        studentEntity.setClassroom(classroom);

        studentRepository.save(studentEntity);
    }
}
