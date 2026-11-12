<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Publish a Course</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1>Publish a Course</h1>
    <p>Enter your course information and pricing below.</p>

    <#if errorMessage??>
        <div class="alert alert-danger">
            ${errorMessage}
        </div>
    </#if>

    <form action="/instructors/${instructorId}/courses" method="post">

        <div class="mb-3">
            <label for="title" class="form-label">Course Title</label>
            <input type="text" class="form-control" id="title"
                   name="title" required>
        </div>

        <div class="mb-3">
            <label for="description" class="form-label">Description</label>
            <textarea class="form-control" id="description"
                      name="description" rows="4"></textarea>
        </div>

        <div class="mb-3">
            <label for="topic" class="form-label">Topic</label>
            <input type="text" class="form-control" id="topic"
                   name="topic">
        </div>

        <div class="mb-3">
            <label for="price" class="form-label">Price ($)</label>
            <input type="number" class="form-control" id="price"
                   name="price" min="0" step="0.01" required>
        </div>

        <div class="mb-3">
            <label for="durationInHours" class="form-label">
                Duration (hours)
            </label>
            <input type="number" class="form-control" id="durationInHours"
                   name="durationInHours" min="1">
        </div>

        <button type="submit" class="btn btn-primary">
            Publish Course
        </button>

        <a href="/instructors/${instructorId}/courses"
           class="btn btn-secondary">Cancel</a>
    </form>
</div>
</body>
</html>