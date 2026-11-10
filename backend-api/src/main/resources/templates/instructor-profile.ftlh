<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Instructor Profile</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow p-4">
        <h2 class="mb-4">Instructor Profile</h2>
        <#if successMessage??>
            <div class="alert alert-success">
                ${successMessage}
            </div>
        </#if>
        <h4>${instructor.name}</h4>

        <p><strong>Qualifications:</strong> ${instructor.qualifications!"Not provided"}</p>

        <p><strong>Areas of Expertise:</strong> ${instructor.areasOfExpertise!"Not provided"}</p>

        <p><strong>Profile Description:</strong> ${instructor.profileDescription!"Not provided"}</p>

        <a href="/instructors/signup" class="btn btn-primary">Create Another Profile</a>
    </div>
</div>

</body>
</html>
