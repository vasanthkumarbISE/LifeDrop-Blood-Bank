
package blood_bank;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    private String page(String title, String content) {
        return """
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport"
                      content="width=device-width, initial-scale=1.0">

                <title>LifeDrop | %s</title>

                <style>
                    * {
                        box-sizing: border-box;
                    }

                    body {
                        margin: 0;
                        font-family: Arial, sans-serif;
                        background: #fff7f7;
                        color: #333;
                    }

                    nav {
                        background: #b71c1c;
                        padding: 18px 5%%;
                        display: flex;
                        flex-wrap: wrap;
                        align-items: center;
                        justify-content: space-between;
                        gap: 15px;
                    }

                    .logo {
                        color: white;
                        font-size: 23px;
                        font-weight: bold;
                        text-decoration: none;
                    }

                    .links {
                        display: flex;
                        flex-wrap: wrap;
                        gap: 16px;
                    }

                    nav .links a {
                        color: white;
                        text-decoration: none;
                        font-size: 14px;
                    }

                    nav .links a:hover {
                        text-decoration: underline;
                    }

                    main {
                        max-width: 1000px;
                        min-height: 65vh;
                        margin: 45px auto;
                        padding: 25px;
                    }

                    h1 {
                        color: #b71c1c;
                    }

                    h2 {
                        color: #8f1523;
                    }

                    .card {
                        background: white;
                        padding: 25px;
                        margin: 18px 0;
                        border-radius: 14px;
                        border: 1px solid #f1dddd;
                        box-shadow: 0 5px 20px #00000008;
                        line-height: 1.8;
                    }

                    .btn {
                        display: inline-block;
                        padding: 12px 20px;
                        background: #b71c1c;
                        color: white;
                        text-decoration: none;
                        border-radius: 8px;
                        margin: 6px 6px 6px 0;
                        transition: 0.25s;
                    }

                    .btn:hover {
                        background: #8f1523;
                        transform: translateY(-2px);
                    }

                    .blood-grid {
                        display: grid;
                        grid-template-columns:
                            repeat(4, minmax(0, 1fr));
                        gap: 15px;
                        margin-top: 25px;
                    }

                    .blood-card {
                        background: white;
                        border: 1px solid #f0d5d8;
                        border-radius: 13px;
                        padding: 25px 10px;
                        text-align: center;
                        text-decoration: none;
                        color: #b71c1c;
                        font-size: 24px;
                        font-weight: bold;
                        transition: 0.25s;
                    }

                    .blood-card:hover {
                        background: #b71c1c;
                        color: white;
                        transform: translateY(-4px);
                    }

                    .subtitle {
                        color: #666;
                        line-height: 1.8;
                    }

                    footer {
                        background: #351717;
                        color: white;
                        text-align: center;
                        padding: 24px;
                        margin-top: 35px;
                    }

                    @media (max-width: 700px) {
                        nav {
                            align-items: flex-start;
                            flex-direction: column;
                        }

                        main {
                            margin: 20px auto;
                            padding: 18px;
                        }

                        .blood-grid {
                            grid-template-columns:
                                repeat(2, minmax(0, 1fr));
                        }
                    }
                </style>
            </head>

            <body>
                <nav>
                    <a class="logo" href="/">❤️ LifeDrop</a>

                    <div class="links">
                        <a href="/">Home</a>
                        <a href="/register">Register Donor</a>
                        <a href="/donors">Find Donors</a>
                        <a href="/blood-groups">Blood Groups</a>
                        <a href="/about">About</a>
                        <a href="/contact">Contact</a>
                    </div>
                </nav>

                <main>
                    %s
                </main>

                <footer>
                    LifeDrop | Every Drop Can Save a Life
                </footer>
            </body>
            </html>
            """.formatted(title, content);
    }

    // BLOOD GROUPS PAGE
    @GetMapping("/blood-groups")
    @ResponseBody
    public String bloodGroups() {
        return page("Blood Groups", """
            <h1>Explore Blood Groups 🩸</h1>

            <p class="subtitle">
                Learn about the eight main blood groups.
                Select a group to search the donor directory.
            </p>

            <div class="blood-grid">
                <a class="blood-card"
                   href="/donors?bloodGroup=A%2B">A+</a>

                <a class="blood-card"
                   href="/donors?bloodGroup=A-">A-</a>

                <a class="blood-card"
                   href="/donors?bloodGroup=B%2B">B+</a>

                <a class="blood-card"
                   href="/donors?bloodGroup=B-">B-</a>

                <a class="blood-card"
                   href="/donors?bloodGroup=AB%2B">AB+</a>

                <a class="blood-card"
                   href="/donors?bloodGroup=AB-">AB-</a>

                <a class="blood-card"
                   href="/donors?bloodGroup=O%2B">O+</a>

                <a class="blood-card"
                   href="/donors?bloodGroup=O-">O-</a>
            </div>

            <div class="card">
                <h2>Why are blood groups important?</h2>

                <p>
                    Blood group compatibility is important
                    for safe blood transfusions. The required
                    blood component and compatibility must be
                    checked by qualified medical professionals.
                </p>
            </div>

            <a class="btn" href="/donors">Find Donors</a>
            <a class="btn" href="/register">Become a Donor</a>
            """);
    }

    // ABOUT PAGE
    @GetMapping("/about")
    @ResponseBody
    public String about() {
        return page("About LifeDrop", """
            <h1>About LifeDrop ❤️</h1>

            <div class="card">
                <h2>Our Project</h2>

                <p>
                    LifeDrop is a Blood Bank Management System
                    designed to organize donor information
                    and make donor searches easier.
                </p>

                <p>
                    The application supports donor registration,
                    searching by blood group or city, and
                    viewing information about blood groups.
                </p>
            </div>

            <div class="card">
                <h2>Our Goal</h2>

                <p>
                    Our goal is to provide a simple platform
                    that helps organize blood donor information
                    and supports people looking for potential
                    donors.
                </p>

                <p>
                    Donor listings do not guarantee availability.
                    Always contact a hospital or authorized
                    blood bank for urgent transfusion needs.
                </p>
            </div>

            <a class="btn" href="/register">Become a Donor</a>
            <a class="btn" href="/donors">Find Donors</a>
            """);
    }

    // CONTACT PAGE
    @GetMapping("/contact")
    @ResponseBody
    public String contact() {
        return page("Contact LifeDrop", """
            <h1>Contact Us 📩</h1>

            <p class="subtitle">
                Have a question about the LifeDrop project?
                Use the contact information configured by
                your project administrator.
            </p>

            <div class="card">
                <h2>Project Information</h2>

                <p>
                    <strong>Project:</strong>
                    LifeDrop Blood Bank Management System
                </p>

                <p>
                    <strong>Email:</strong>
                    lifedrop@example.com
                </p>

                <p>
                    <strong>Phone:</strong>
                    Add your verified project contact number.
                </p>

                <p>
                    <strong>Location:</strong>
                    Add your project location.
                </p>

                <p>
                    Note: Replace these example details with
                    verified contact information before publishing.
                </p>
            </div>

            <a class="btn" href="/">Back to Home</a>
            """);
    }
}
