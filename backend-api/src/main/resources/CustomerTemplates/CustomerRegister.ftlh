<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Micro Course | Learner Sign-Up</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">

    <a class="navbar-brand fw-bold" href="#">
      MicroCourse
    </a>

    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" 
            data-bs-target="#navbarNav" aria-controls="navbarNav" 
            aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav ms-auto">

        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="signup-learner.html">
            Sign Up
          </a>
        </li>

        <li class="nav-item">
          <a class="nav-link" href="learner-profile.html">
            Profile
          </a>
        </li>

        <li class="nav-item">
          <a class="nav-link" href="learner-courses.html">
            Courses
          </a>
        </li>

        <li class="nav-item">
          <a class="nav-link" href="#">
            About
          </a>
        </li>

      </ul>
    </div>

  </div>
</nav>


    <div class="container mt-5">
        <div class="card shadow p-4 mx-auto" style="max-width: 450px;">
            <h3 class="text-center mb-4">Customer Sign Up</h3>

            <form action="/customers/register" method="post">
              
                <div class="mb-3">
                    <label class="form-label">Username</label>
                    <input type="text" class="form-control" name="userName" placeholder="johndoe"      required>
                  </div>

                <div class="mb-3">
                    <label class="form-label">First Name</label>
                    <input type="text" class="form-control" name="firstName" placeholder="John"
                          required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Last Name</label>
                    <input type="text" class="form-control" name="lastName" placeholder="Doe" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Email</label>
                    <input type="email" class="form-control" name="email"   placeholder="customer@example.com" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Phone Number</label>
                    <input type="text" class="form-control" name="phoneNumber" 
                          placeholder="(555) 555-5555">
                </div>
                
                <div class="mb-3">
                    <label class="form-label">Password</label>
                    <input type="password" class="form-control" name="password">
                </div>
            
                <button type="submit"
                        class="btn btn-primary w-100">
                    Sign Up
                </button>

                 <div class="text-center mt-3">
                    <small>Registering as an instructor?</small><br>
                    <a href="instructor-sign-up.html" class="text-primary">Click here</a>
                </div>
            </form>

        </div>
    </div>
</body>
</html>