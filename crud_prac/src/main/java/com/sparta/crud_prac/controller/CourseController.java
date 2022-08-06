package com.sparta.crud_prac.controller;

import com.sparta.crud_prac.domain.Course;
import com.sparta.crud_prac.domain.CourseRepository;
import com.sparta.crud_prac.domain.CourseRequestDto;
import com.sparta.crud_prac.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CourseController {
    
    private final CourseRepository courseRepository;
    private final CourseService courseService;

    @PostMapping("/api/courses")
    public Course createCourse(@RequestBody CourseRequestDto requestDto){
        Course course = new Course(requestDto);
        return courseRepository.save(course);
    }

    @GetMapping("/api/courses")
    public List<Course> getCourse(){
        return courseRepository.findAll();
    }

    @PutMapping("/api/courses/{id}")
    public Long updateCourse(@PathVariable Long id,@RequestBody CourseRequestDto requestDto){
        return courseService.update(id , requestDto);
    }

    @DeleteMapping("/api/courses/{id}")
    public Long deleteCourse(@PathVariable Long id){
        courseRepository.deleteById(id);
        return id;
    }
    
}
