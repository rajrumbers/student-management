package com.example.studentmanagement;

import com.example.studentmanagement.model.Course;
import com.example.studentmanagement.service.CourseService;
import com.example.studentmanagement.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CourseServiceTest {
    @Mock
    private CourseRepository courseRepository;
    
    @InjectMocks
    private CourseService courseService;

    @Test
    public void testAddCourse() {
        Course course = new Course("C101", "Mathematics");
        when(courseRepository.existsByCode("C101")).thenReturn(false);
        when(courseRepository.save(course)).thenReturn(course);

        Course saved = courseService.addCourse(course);
        assertEquals("C101", saved.getCode());
        verify(courseRepository).save(course);
    }
}