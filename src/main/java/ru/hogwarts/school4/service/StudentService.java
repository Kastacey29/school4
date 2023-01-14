package ru.hogwarts.school4.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school4.model.Faculty;
import ru.hogwarts.school4.model.Student;

import java.util.HashMap;
import java.util.Map;
@Service
public class StudentService {
    private final Map<Long, Student> students = new HashMap<>();
    private Long lastId;
}
