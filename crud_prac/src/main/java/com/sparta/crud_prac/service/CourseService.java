package com.sparta.crud_prac.service;

import com.sparta.crud_prac.domain.Course;
import com.sparta.crud_prac.domain.CourseRepository;
import com.sparta.crud_prac.domain.CourseRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CourseService {
    private final CourseRepository courseRepository;

//    public CourseService(CourseRepository courseRepository){
//        this.courseRepository = courseRepository;
//    }

    @Transactional
    public Long update(Long id, CourseRequestDto requestDto){
        Course course1 = courseRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이다가 존재하지 않습니다.")
        );
        course1.update(requestDto);
        return course1.getId();
    }
}
