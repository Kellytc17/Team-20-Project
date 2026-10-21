package com.example.MicroCourse.provider.service;

import com.example.MicroCourse.provider.entity.Lesson;
import com.example.MicroCourse.provider.entity.Resource;
import com.example.MicroCourse.provider.repository.LessonRepository;
import com.example.MicroCourse.provider.repository.ResourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {

    private final ResourceRepository resourceRepository;
    private final LessonRepository lessonRepository;

    public ResourceService(ResourceRepository resourceRepository,
                           LessonRepository lessonRepository) {
        this.resourceRepository = resourceRepository;
        this.lessonRepository = lessonRepository;
    }

    public Resource createResource(Resource resource) {
        Lesson lesson = findLesson(resource);
        resource.setLesson(lesson);

        return resourceRepository.save(resource);
    }

    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    public Resource getResourceById(Long id) {
        return resourceRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Resource not found with ID: " + id));
    }

    public Resource updateResource(Long id, Resource updatedResource) {
        Resource existingResource = getResourceById(id);

        existingResource.setTitle(updatedResource.getTitle());
        existingResource.setResourceType(updatedResource.getResourceType());
        existingResource.setUrl(updatedResource.getUrl());
        existingResource.setLesson(findLesson(updatedResource));

        return resourceRepository.save(existingResource);
    }

    public void deleteResource(Long id) {
        Resource resource = getResourceById(id);
        resourceRepository.delete(resource);
    }

    private Lesson findLesson(Resource resource) {
        if (resource.getLesson() == null ||
                resource.getLesson().getId() == null) {
            throw new IllegalArgumentException(
                    "A valid lesson ID is required.");
        }

        Long lessonId = resource.getLesson().getId();

        return lessonRepository.findById(lessonId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Lesson not found with ID: " + lessonId));
    }
}