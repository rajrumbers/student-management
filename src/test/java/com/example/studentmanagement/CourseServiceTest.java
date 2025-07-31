package com.example.studentmanagement;

import com.example.studentmanagement.model.Course;
import com.example.studentmanagement.service.CourseService;
import com.example.studentmanagement.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CourseServiceTest {
    @Test
    public void testAddCourse() {
        CourseRepository repo = mock(CourseRepository.class);
        CourseService service = new CourseService();
        service = Mockito.spy(service);
        service.courseRepository = repo;

        Course course = new Course("C101", "Mathematics");
        when(repo.existsByCode("C101")).thenReturn(false);
        when(repo.save(course)).thenReturn(course);

        Course saved = service.addCourse(course);
        assertEquals("C101", saved.getCode());
        verify(repo).save(course);
    }
}