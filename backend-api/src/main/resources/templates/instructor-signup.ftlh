<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Instructor Signup</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-7">
            <div class="card shadow p-4">

                <h2 class="text-center mb-4">Create Instructor Profile</h2>
                <#if errors??>
                    <#list errors as error>
                        <div class="alert alert-danger">
                            ${error.defaultMessage}
                        </div>
                    </#list>    
                </#if>

                <#if successMessage??>
                    <div class="alert alert-success">
                        ${successMessage}
                    </div>
                </#if>

                <form action="/instructors/signup" method="post">

                    <div class="mb-3">
                        <label class="form-label">Full Name</label>
                        <input type="text" name="name" class="form-control" value="${(instructor.name)!''}">
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Qualifications</label>
                        <input type="text" name="qualifications" class="form-control">
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Areas of Expertise</label>
                        <input type="text" name="areasOfExpertise" class="form-control">
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Profile Description</label>
                        <textarea name="profileDescription" class="form-control" rows="4"></textarea>
                    </div>

                    <button type="submit" class="btn btn-primary w-100">
                        Create Profile
                    </button>

                </form>

            </div>
        </div>
    </div>
</div>

</body>
</html>