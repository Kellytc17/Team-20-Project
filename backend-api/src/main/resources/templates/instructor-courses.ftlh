<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>My Published Courses</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">

    <h1>My Published Courses</h1>

    <#if successMessage??>
        <div class="alert alert-success">
            ${successMessage}
        </div>
    </#if>

    <a href="/instructors/${instructorId}/courses/new"
       class="btn btn-primary mb-3">
        Publish a New Course
    </a>

    <#if courses?has_content>
        <div class="row">
            <#list courses as course>
                <div class="col-md-6 mb-3">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">${course.title}</h5>

                            <p class="card-text">
                                ${course.description!""}
                            </p>

                            <p><strong>Topic:</strong> ${course.topic!""}</p>

                            <p><strong>Price:</strong> $${course.price!0}</p>

                            <p>
                                <strong>Duration:</strong>
                                ${course.durationInHours!"Not specified"} hours
                            </p>
                        </div>
                    </div>
                </div>
            </#list>
        </div>
    <#else>
        <p>You haven't published any courses yet.</p>
    </#if>

</div>
</body>
</html>