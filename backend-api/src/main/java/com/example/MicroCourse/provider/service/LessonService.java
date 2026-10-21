package com.example.MicroCourse.provider.service;

import com.example.MicroCourse.provider.entity.Course;
import com.example.MicroCourse.provider.entity.Lesson;
import com.example.MicroCourse.provider.repository.CourseRepository;
import com.example.MicroCourse.provider.repository.LessonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {

    private final LessonRepository lessonRepository;
    private final CourseRepository courseRepository;

    public LessonService(LessonRepository lessonRepository,
                         CourseRepository courseRepository) {
        this.lessonRepository = lessonRepository;
        this.courseRepository = courseRepository;
    }

    public Lesson createLesson(Lesson lesson) {
        Course course = findCourse(lesson);
        lesson.setCourse(course);
        return lessonRepository.save(lesson);
    }

    public List<Lesson> getAllLessons() {
        return lessonRepository.findAll();
    }

    public Lesson getLessonById(Long id) {
        return lessonRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Lesson not found with ID: " + id));
    }

    public Lesson updateLesson(Long id, Lesson updatedLesson) {
        Lesson existingLesson = getLessonById(id);

        existingLesson.setTitle(updatedLesson.getTitle());
        existingLesson.setDescription(updatedLesson.getDescription());
        existingLesson.setLessonOrder(updatedLesson.getLessonOrder());
        existingLesson.setCourse(findCourse(updatedLesson));

        return lessonRepository.save(existingLesson);
    }

    public void deleteLesson(Long id) {
        Lesson lesson = getLessonById(id);
        lessonRepository.delete(lesson);
    }

    private Course findCourse(Lesson lesson) {
        if (lesson.getCourse() == null ||
                lesson.getCourse().getId() == null) {
            throw new IllegalArgumentException(
                    "A valid course ID is required.");
        }

        Long courseId = lesson.getCourse().getId();

        return courseRepository.findById(courseId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Course not found with ID: " + courseId));
    }
}
