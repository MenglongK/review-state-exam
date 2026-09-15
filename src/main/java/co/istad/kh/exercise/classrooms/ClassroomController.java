package co.istad.kh.exercise.classrooms;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/classroom")
@RequiredArgsConstructor
public class ClassroomController {
    private final ClassroomService classroomService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createClassroom(@RequestBody @Valid ClassroomRequest classroomRequest) {
        classroomService.addNewClassroom(classroomRequest);
    }
}
