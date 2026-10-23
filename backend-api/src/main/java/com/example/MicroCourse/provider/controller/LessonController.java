package com.example.MicroCourse.provider.controller;

import com.example.MicroCourse.provider.entity.Lesson;
import com.example.MicroCourse.provider.service.LessonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {

    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Lesson createLesson(@RequestBody Lesson lesson) {
        return lessonService.createLesson(lesson);
    }

    @GetMapping
    public List<Lesson> getAllLessons() {
        return lessonService.getAllLessons();
    }

    @GetMapping("/{id}")
    public Lesson getLessonById(@PathVariable Long id) {
        return lessonService.getLessonById(id);
    }

    @PutMapping("/{id}")
    public Lesson updateLesson(@PathVariable Long id,
                               @RequestBody Lesson lesson) {
        return lessonService.updateLesson(id, lesson);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLesson(@PathVariable Long id) {
        lessonService.deleteLesson(id);
    }
}