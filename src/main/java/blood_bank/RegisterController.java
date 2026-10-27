
package blood_bank;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegisterController {

    @GetMapping("/register")
    @ResponseBody
    public String registerPage() {
        return """
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport"
                      content="width=device-width, initial-scale=1.0">
                <title>LifeDrop | Register Donor</title>
                <style>
                    body {
                        font-family: Arial, sans-serif;
                        background: #fff5f5;
                        margin: 0;
                        padding: 30px 15px;
                    }
                    nav {
                        background: #b71c1c;
                        padding: 18px;
                        text-align: center;
                    }
                    nav a {
                        color: white;
                        margin: 8px;
                        text-decoration: none;
                        display: inline-block;
                    }
                    .container {
                        max-width: 550px;
                        margin: 25px auto;
                        background: white;
                        padding: 28px;
                        border-radius: 15px;
                        box-shadow: 0 5px 20px #0001;
                    }
                    h1 { color: #c62828; text-align: center; }
                    p { text-align: center; color: #555; }
                    label {
                        display: block;
                        margin-top: 15px;
                        font-weight: bold;
                    }
                    input, select {
                        box-sizing: border-box;
                        width: 100%;
                        padding: 12px;
                        margin-top: 7px;
                        border: 1px solid #ddd;
                        border-radius: 7px;
                    }
                    button {
                        width: 100%;
                        padding: 13px;
                        margin-top: 22px;
                        background: #c62828;
                        color: white;
                        border: none;
                        border-radius: 7px;
                        cursor: pointer;
                        font-size: 16px;
                    }
                    a { color: #c62828; }
                </style>
            </head>
            <body>
     
<nav class="nav-links" id="navLinks">
    <a href="/">Home</a>
    <a href="/register">Register Donor</a>
    <a href="/donors">Find Donors</a>
    <a href="/blood-groups">Blood Groups</a>
    <a href="/blood-stock">Blood Stock</a>
    <a href="/about">About</a>
    <a href="/contact">Contact</a>
</nav>


                <div class="container">
                    <h1>Become a Blood Donor</h1>
                    <p>Your donation can help save a life.</p>

                    <form id="donorForm">
                        <label>Full Name</label>
                        <input type="text" name="name"
                               placeholder="Enter your full name" required>

                        <label>Age</label>
                        <input type="number" name="age" min="18" max="100"
                               placeholder="Enter your age" required>

                        <label>Blood Group</label>
                        <select name="bloodGroup" required>
                            <option value="">Select blood group</option>
                            <option>A+</option>
                            <option>A-</option>
                            <option>B+</option>
                            <option>B-</option>
                            <option>AB+</option>
                            <option>AB-</option>
                            <option>O+</option>
                            <option>O-</option>
                        </select>

                        <label>Phone Number</label>
                        <input type="tel" name="phone"
                               placeholder="Enter phone number" required>

                        <label>City</label>
                        <input type="text" name="city"
                               placeholder="Enter your city" required>

                        <button type="submit">Register as Donor</button>
                    </form>
                    
<script>
    document.getElementById("donorForm").addEventListener("submit", async function(event) {
        event.preventDefault();

        const form = event.target;

        const donor = {
            name: form.elements["name"].value.trim(),
            age: Number(form.elements["age"].value),
            bloodGroup: form.elements["bloodGroup"].value,
            phone: form.elements["phone"].value.trim(),
            city: form.elements["city"].value.trim()
        };

        try {
            const response = await fetch("/api/donors", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(donor)
            });

            if (!response.ok) {
                throw new Error("Registration failed. Please check your details.");
            }

            alert("Donor registered successfully!");
            form.reset();

        } catch (error) {
            alert("Could not register donor. Please make sure the server is running and try again.");
            console.error(error);
        }
    });
</script>


                    <p><a href="/">Back to Home</a></p>
                </div>
            </body>
            </html>
            """;
    }
}
