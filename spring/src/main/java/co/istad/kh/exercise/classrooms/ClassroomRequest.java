package co.istad.kh.exercise.classrooms;

public record ClassroomRequest(
        String classCode,
        String subject,
        Boolean status
) {
}
