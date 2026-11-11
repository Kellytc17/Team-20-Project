<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Available Courses</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">

    <h1>Available Courses</h1>
    <p>Explore the courses offered by our instructors.</p>

    <#if courses?has_content>
        <div class="row">
            <#list courses as course>
                <div class="col-md-6 mb-3">
                    <div class="card h-100">
                        <div class="card-body">
                            <h5 class="card-title">${course.title}</h5>

                            <p>${course.description!""}</p>

                            <p><strong>Topic:</strong> ${course.topic!""}</p>

                            <p><strong>Price:</strong> $${course.price!0}</p>

                            <p>
                                <strong>Duration:</strong>
                                ${course.durationInHours!"Not specified"} hours
                            </p>

                            <p>
                                <strong>Instructor:</strong>
                                ${course.instructor.name}
                            </p>
                        </div>
                    </div>
                </div>
            </#list>
        </div>
    <#else>
        <p>No courses are available yet.</p>
    </#if>

</div>
</body>
</html>