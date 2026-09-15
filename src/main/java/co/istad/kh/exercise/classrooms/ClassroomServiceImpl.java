package co.istad.kh.exercise.classrooms;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ClassroomServiceImpl implements ClassroomService {
    private final ClassroomRepository classroomRepository;


    @Override
    public void addNewClassroom(ClassroomRequest classroom) {
        classroomRepository.findByClassCode(classroom.classCode()).ifPresent(existing -> {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Classroom already exists");
        });

        ClassroomEntity classroomEntity = new ClassroomEntity();
        classroomEntity.setClassCode(classroom.classCode());
        classroomEntity.setSubject(classroom.subject());
        classroomEntity.setStatus(classroom.status());

        classroomRepository.save(classroomEntity);
    }
}
