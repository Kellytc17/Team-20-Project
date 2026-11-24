<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MicroCourse | Profile</title>

    <link rel="stylesheet" href="../css/learner-profile.css">

    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>

<body class="bg-light">

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container-fluid">

        <a class="navbar-brand fw-bold" href="/"> MicroCourse</a>

        <button class="navbar-toggler"
                type="button"
                data-bs-toggle="collapse"
                data-bs-target="#navbarNav"
                aria-controls="navbarNav"
                aria-expanded="false"
                aria-label="Toggle navigation">

            <span class="navbar-toggler-icon"></span>

        </button>

        <div class="collapse navbar-collapse"
             id="navbarNav">

            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/">Home </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link active" href="/customers/profile/${customer.id}">
                        Profile
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="#"> Courses </a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Body Content -->
<div class="container mt-5">
    <h3 class="mb-4"> Your Profile </h3>
    <div class="card shadow p-4">

        <div class="row">
            <!-- Profile Photo -->
            <div class="col-md-4 text-center">

                <img src="../assets/default-avatar.png" class="rounded-circle mb-3" width="150"
                     alt="Profile Picture">
                <br>

                <button class="btn btn-outline-primary btn-sm">
                    Change Photo
                </button>

            </div>

            <!-- Profile Information -->
            <div class="col-md-8">

                <h4 class="fw-bold">
                    ${customer.firstName}
                    ${customer.lastName}
                </h4>

                <p class="text-muted">
                    ${customer.email}
                </p>

                <a href="/customers/edit-details/${customer.id}" class="btn btn-primary mt-3 mb-4">
                  Edit Profile
                </a>

                <hr>

                <h5 class="fw-semibold">
                    Profile Information
                </h5>

                <div class="mt-3">

                    <p>
                        <strong>Username:</strong>
                        ${customer.userName}
                    </p>

                    <p>
                        <strong>Email:</strong>
                        ${customer.email}
                    </p>

                    <p>
                        <strong>Phone Number:</strong>

                        <#if customer.phoneNumber?? &&
                              customer.phoneNumber?has_content>

                            ${customer.phoneNumber}

                        <#else>

                            Not Provided

                        </#if>

                    </p>

                </div>

                <hr>

                <h5 class="fw-semibold mt-4">
                    Interests
                </h5>

                <#if customer.interests?? &&
                      customer.interests?size gt 0>

                    <ul class="list-group">

                        <#list customer.interests as interest>

                            <li class="list-group-item">

                                ${interest}

                            </li>

                        </#list>

                    </ul>

                <#else>

                    <p class="text-muted">
                        No interests added yet.
                    </p>

                </#if>

            </div>

        </div>

    </div>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
