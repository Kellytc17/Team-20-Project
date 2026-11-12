<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>MicroCourse - Instructors</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>

<body>

<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #2563EB;">
    <div class="container">
        <a class="navbar-brand fw-bold" href="/">MicroCourse</a>

        <button class="navbar-toggler" type="button"
                data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="/instructors">Instructors</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/courses">Browse Courses</a>
                </li>
            </ul>

            <div class="d-flex gap-2">
                <a href="/instructors/login" class="btn btn-outline-light">Log In</a>
                <a href="/instructors/signup" class="btn btn-outline-light">Sign Up</a>
            </div>
        </div>
    </div>
</nav>

<section class="py-5 bg-light">
    <div class="container text-center">
        <h1 class="fw-bold">Our Instructors</h1>
        <p class="lead text-muted">
            Explore instructors with different areas of expertise
            and discover who can help you learn something new.
        </p>
    </div>
</section>

<section class="py-4">
    <div class="container">
        <div class="row g-3">
            <div class="col-md-10">
                <label for="instructorSearch" class="form-label fw-bold">
                    Search Instructors
                </label>
                <input type="text" id="instructorSearch" class="form-control"
                       placeholder="Search by instructor name or expertise">
            </div>

            <div class="col-md-2 d-flex align-items-end">
                <button type="button" id="searchButton"
                        class="btn btn-primary w-100">
                    Search
                </button>
            </div>
        </div>
    </div>
</section>

<section class="py-5">
    <div class="container">
        <div class="row g-4" id="instructorList">

            <#if instructors?has_content>
                <#list instructors as instructor>
                    <div class="col-lg-4 instructor-card"
                         data-search="${(instructor.name!'')?lower_case} ${(instructor.areasOfExpertise!'')?lower_case} ${(instructor.qualifications!'')?lower_case}">

                        <div class="card h-100 shadow-sm">
                            <div class="card-body">

                                <div class="text-center mb-4">
                                    <div class="rounded-circle bg-primary text-white d-flex align-items-center justify-content-center mx-auto mb-3"
                                         style="width: 120px; height: 120px; font-size: 48px;">
                                        ${(instructor.name!'I')?substring(0,1)?upper_case}
                                    </div>

                                    <h4 class="fw-bold">
                                        ${instructor.name}
                                    </h4>

                                    <p class="text-muted mb-0">
                                        ${instructor.areasOfExpertise!'Instructor'}
                                    </p>
                                </div>

                                <hr>

                                <h5 class="fw-bold">Qualifications</h5>
                                <p class="text-muted">
                                    ${instructor.qualifications!'No qualifications provided yet.'}
                                </p>

                                <h5 class="fw-bold">About</h5>
                                <p class="text-muted">
                                    ${instructor.profileDescription!'This instructor has not added a profile description yet.'}
                                </p>

                                <a href="/instructors/${instructor.id}"
                                   class="btn btn-outline-primary w-100 mt-3">
                                    View Instructor
                                </a>

                            </div>
                        </div>
                    </div>
                </#list>
            <#else>
                <div class="col-12 text-center py-5">
                    <h4 class="fw-bold">No Instructors Yet</h4>
                    <p class="text-muted">
                        There are currently no instructor profiles available.
                        Check back later!
                    </p>
                    <a href="/instructors/signup" class="btn btn-primary">
                        Become an Instructor
                    </a>
                </div>
            </#if>

        </div>

        <p id="noSearchResults" class="text-center text-muted mt-4"
           style="display: none;">
            No instructors match your search.
        </p>
    </div>
</section>

<footer class="py-4 bg-dark text-white">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <h5 class="fw-bold">MicroCourse</h5>
                <p class="text-white-50">
                    Empowering instructors to share knowledge
                    through bite-sized courses.
                </p>
            </div>

            <div class="col-md-6 text-md-end">
                <a href="/" class="text-white text-decoration-none me-3">Home</a>
                <a href="/instructors" class="text-white text-decoration-none me-3">Instructors</a>
                <a href="/courses" class="text-white text-decoration-none">Browse Courses</a>
            </div>
        </div>

        <hr>

        <p class="text-center text-white-50 mb-0">
            &copy; 2026 MicroCourse. All rights reserved.
        </p>
    </div>
</footer>

<script>
    const searchInput = document.getElementById("instructorSearch");
    const searchButton = document.getElementById("searchButton");
    const instructorCards = document.querySelectorAll(".instructor-card");
    const noResults = document.getElementById("noSearchResults");

    function searchInstructors() {
        const searchText = searchInput.value.toLowerCase().trim();
        let visibleCount = 0;

        instructorCards.forEach(card => {
            const instructorInfo = card.dataset.search;
            const matches = instructorInfo.includes(searchText);

            card.style.display = matches ? "" : "none";

            if (matches) {
                visibleCount++;
            }
        });

        noResults.style.display =
            instructorCards.length > 0 && visibleCount === 0 ? "block" : "none";
    }

    searchButton.addEventListener("click", searchInstructors);

    searchInput.addEventListener("input", searchInstructors);
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>