package ru.hogwarts.school4.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school4.model.Faculty;
import ru.hogwarts.school4.service.FacultyService;

@RestController
@RequestMapping("faculty")
public class FacultyController {
private final FacultyService facultyService;

public FacultyController(FacultyService facultyService) {
    this.facultyService=facultyService;
}
    @PostMapping
    public ResponseEntity addFaculty(@RequestBody Faculty faculty) {
        Faculty addFaculty = facultyService.createFaculty(faculty);
        return ResponseEntity.ok(addFaculty);
    }

    @GetMapping("{facultyId}")
    public ResponseEntity getFaculty(@PathVariable Long facultyId) {
        Faculty faculty = facultyService.getFacultyByld(facultyId);
        if(faculty == null) {
            return ResponseEntity.notFound() .build();
        }
        return ResponseEntity.ok(faculty);
    }

    @PutMapping()
    public ResponseEntity updateFaculty(@RequestBody Faculty faculty) {
        Faculty updatedFaculty = facultyService.updateFaculty(faculty.getId(), faculty);
        return ResponseEntity.ok(updatedFaculty);
    }
    @DeleteMapping("{facultyId}")
    public ResponseEntity deleteFaculty(@PathVariable Long facultyId) {
        Faculty faculty = facultyService.deleteFacultyByld(facultyId);
        if(faculty == null) {
            return ResponseEntity.notFound() .build();
        }
        return ResponseEntity.ok(faculty);
    }
}
