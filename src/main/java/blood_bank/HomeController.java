
package blood_bank;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.security.core.Authentication;

@Controller
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String home(Authentication authentication) {

        boolean isAdmin = authentication != null
                && authentication.isAuthenticated()
                && authentication.getAuthorities().stream()
                    .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));

        // Dashboard appears in the homepage navigation for everyone.
        String dashboardLink = "<a href='/dashboard'>Dashboard</a>";

        String adminControls = isAdmin
                ? "<a class='nav-login' href='/logout'>Logout</a>"
                : "<a class='nav-login' href='/login'>Admin Login</a>";

        return "<!DOCTYPE html>"
            + "<html lang='en'><head>"
            + "<meta charset='UTF-8'>"
            + "<meta name='viewport' content='width=device-width, initial-scale=1.0'>"
            + "<title>LifeDrop | Save Lives</title>"
            + "<style>"
            + "*{box-sizing:border-box;margin:0;padding:0}"
            + "html{scroll-behavior:smooth}"
            + "body{font-family:Arial,Helvetica,sans-serif;color:#24212a;"
            + "background:#fffafb;line-height:1.6}"
            + "header{position:sticky;top:0;z-index:10;background:rgba(255,255,255,.96);"
            + "backdrop-filter:blur(12px);box-shadow:0 4px 25px rgba(110,0,25,.08)}"
            + ".topbar{max-width:1250px;margin:auto;padding:15px 28px;"
            + "display:flex;align-items:center;justify-content:space-between;gap:20px;flex-wrap:wrap}"
            + ".logo{font-size:30px;font-weight:900;letter-spacing:-1.5px;"
            + "color:#d7193f;text-decoration:none;white-space:nowrap}"
            + ".logo span{color:#292333}"
            + ".logo-icon{display:inline-flex;align-items:center;justify-content:center;"
            + "width:37px;height:37px;border-radius:12px;background:#d7193f;color:white;"
            + "font-size:23px;margin-right:8px}"
            + "nav{display:flex;align-items:center;justify-content:center;gap:5px;flex-wrap:wrap}"
            + "nav a{color:#494451;text-decoration:none;font-size:14px;font-weight:700;"
            + "padding:10px 12px;border-radius:9px;transition:.25s}"
            + "nav a:hover{color:#d7193f;background:#fff0f3}"
            + ".nav-login{background:#d7193f!important;color:white!important;"
            + "padding:11px 17px!important;border-radius:10px!important}"
            + ".nav-login:hover{background:#aa102f!important;transform:translateY(-2px)}"
            + ".hero{position:relative;overflow:hidden;background:linear-gradient(120deg,#fff1f3,#ffe0e7 60%,#ffd4df)}"
            + ".hero:before{content:'';position:absolute;width:360px;height:360px;"
            + "border-radius:50%;background:rgba(255,255,255,.4);right:-100px;top:-150px}"
            + ".hero-inner{max-width:1250px;min-height:490px;margin:auto;padding:75px 35px;"
            + "display:flex;align-items:center;justify-content:space-between;gap:35px;position:relative}"
            + ".content{max-width:720px;animation:fadeup .8s ease both}"
            + ".eyebrow{display:inline-block;background:white;color:#bd1235;padding:8px 14px;"
            + "border-radius:30px;font-size:13px;font-weight:800;letter-spacing:.5px;"
            + "box-shadow:0 4px 15px #d7193f12;margin-bottom:23px}"
            + "h1{font-size:clamp(39px,5.5vw,67px);line-height:1.09;letter-spacing:-2px;"
            + "margin-bottom:22px;color:#282331}"
            + "h1 span{color:#d7193f}"
            + ".hero p{font-size:18px;color:#625461;max-width:640px;margin-bottom:30px}"
            + ".actions{display:flex;flex-wrap:wrap;gap:12px}"
            + ".btn{display:inline-flex;align-items:center;justify-content:center;"
            + "padding:14px 21px;border-radius:11px;text-decoration:none;font-weight:800;"
            + "font-size:15px;background:#d7193f;color:white;border:2px solid #d7193f;"
            + "transition:transform .25s,box-shadow .25s,background .25s}"
            + ".btn:hover{transform:translateY(-3px);box-shadow:0 10px 24px #d7193f35;"
            + "background:#ad102f;border-color:#ad102f}"
            + ".btn.outline{background:white;color:#d7193f}"
            + ".btn.outline:hover{background:#fff0f3}"
            + ".visual{min-width:250px;display:flex;justify-content:center;align-items:center;"
            + "flex:1;animation:float 4s ease-in-out infinite}"
            + ".heart{width:245px;height:245px;border-radius:48% 52% 50% 50%;"
            + "background:linear-gradient(145deg,#ed3153,#b90b32);"
            + "display:flex;align-items:center;justify-content:center;"
            + "font-size:125px;color:white;box-shadow:0 25px 55px #b90b3233;"
            + "transform:rotate(-5deg);border:10px solid rgba(255,255,255,.65)}"
            + ".trust{background:white;border-bottom:1px solid #f5e5e9}"
            + ".trust-inner{max-width:1100px;margin:auto;padding:23px 25px;"
            + "display:flex;justify-content:center;gap:45px;flex-wrap:wrap}"
            + ".trust-item{font-weight:700;color:#554956;font-size:14px}"
            + ".trust-item span{color:#d7193f;margin-right:7px}"
            + "section{padding:70px 25px;text-align:center}"
            + ".section-inner{max-width:1150px;margin:auto}"
            + ".tag{color:#d7193f;text-transform:uppercase;font-size:12px;"
            + "font-weight:900;letter-spacing:2px;margin-bottom:9px}"
            + "h2{font-size:clamp(29px,4vw,40px);letter-spacing:-1px;margin-bottom:12px}"
            + ".subtitle{color:#746875;font-size:16px;margin-bottom:35px}"
            + ".cards{display:grid;grid-template-columns:repeat(3,minmax(0,1fr));gap:20px;text-align:left}"
            + ".card{background:#fff;border:1px solid #f3dfe5;border-radius:18px;"
            + "padding:27px 23px;display:flex;flex-direction:column;align-items:flex-start;"
            + "box-shadow:0 8px 25px rgba(100,0,30,.045);transition:.3s}"
            + ".card:hover{transform:translateY(-7px);box-shadow:0 16px 35px #d7193f17;border-color:#f0a8b8}"
            + ".card-icon{width:52px;height:52px;display:flex;align-items:center;"
            + "justify-content:center;background:#fff0f3;color:#d7193f;border-radius:15px;"
            + "font-size:26px;margin-bottom:19px}"
            + ".card h3{font-size:19px;margin-bottom:9px;color:#302833}"
            + ".card p{color:#776b76;font-size:14px;margin-bottom:22px;flex-grow:1}"
            + ".card .btn{width:100%;font-size:14px;padding:11px 12px}"
            + "footer{background:#29232e;color:#e9dfe7;text-align:center;padding:30px 20px}"
            + "footer strong{color:#ff6a88}"
            + "@keyframes fadeup{from{opacity:0;transform:translateY(18px)}to{opacity:1;transform:translateY(0)}}"
            + "@keyframes float{0%,100%{transform:translateY(0)}50%{transform:translateY(-12px)}}"
            + "@media(max-width:950px){.topbar{justify-content:center}.cards{grid-template-columns:repeat(2,minmax(0,1fr))}.hero-inner{padding:60px 28px}.visual{min-width:190px}.heart{width:195px;height:195px;font-size:95px}}"
            + "@media(max-width:620px){.topbar{padding:13px 15px;gap:10px}.logo{font-size:26px}nav{gap:3px}nav a{font-size:12px;padding:8px}.hero-inner{padding:50px 22px;flex-direction:column;text-align:center}.hero p{font-size:16px}.actions{justify-content:center}.btn{padding:12px 15px;font-size:14px}.visual{min-width:0}.heart{width:155px;height:155px;font-size:75px;border-width:7px}.trust-inner{gap:13px;flex-direction:column;align-items:center}section{padding:50px 18px}.cards{grid-template-columns:1fr}.card{padding:24px}.eyebrow{font-size:11px}}"
            + "</style></head><body>"

            + "<header><div class='topbar'>"
            + "<a class='logo' href='/'><span class='logo-icon'>&#10084;</span>Life<span>Drop</span></a>"
            + "<nav>"
            + "<a href='/'>Home</a>"
            + "<a href='/register'>Register Donor</a>"
            + "<a href='/donors'>Find Donors</a>"
            + "<a href='/blood-groups'>Blood Groups</a>"
            + "<a href='/blood-stock'>Blood Stock</a>"
            + dashboardLink
            + "<a href='/about'>About</a>"
            + "<a href='/contact'>Contact</a>"
            + adminControls
            + "</nav></div></header>"

            + "<main><div class='hero'><div class='hero-inner'>"
            + "<div class='content'>"
            + "<div class='eyebrow'>&#10084; EVERY DONATION MATTERS</div>"
            + "<h1>Every Drop Can<br><span>Save a Life.</span></h1>"
            + "<p>Be someone's reason to smile. Donate blood, share hope, and help people get another chance at life. Every drop makes a difference.</p>"
            + "<div class='actions'>"
            + "<a class='btn' href='/register'>Become a Donor &#8594;</a>"
            + "<a class='btn outline' href='/blood-stock'>Check Blood Stock</a>"
            + "</div></div>"
            + "<div class='visual'><div class='heart' aria-label='Heart'>&#10084;</div></div>"
            + "</div></div>"

            + "<div class='trust'><div class='trust-inner'>"
            + "<div class='trust-item'><span>&#10003;</span>Help Save Lives</div>"
            + "<div class='trust-item'><span>&#10003;</span>Connect With Donors</div>"
            + "<div class='trust-item'><span>&#10003;</span>Support Your Community</div>"
            + "</div></div>"

            + "<section><div class='section-inner'>"
            + "<div class='tag'>GET STARTED</div>"
            + "<h2>How Can We Help You?</h2>"
            + "<p class='subtitle'>Choose an option to continue with LifeDrop.</p>"
            + "<div class='cards'>"

            + "<div class='card'><div class='card-icon'>&#10084;</div>"
            + "<h3>Become a Donor</h3>"
            + "<p>Register your details and help connect people with the blood they need.</p>"
            + "<a class='btn' href='/register'>Register Now &#8594;</a></div>"

            + "<div class='card'><div class='card-icon'>&#9906;</div>"
            + "<h3>Find Donors</h3>"
            + "<p>Explore registered donor information to find potential blood donors.</p>"
            + "<a class='btn outline' href='/donors'>View Donors &#8594;</a></div>"

            + "<div class='card'><div class='card-icon'>&#9829;</div>"
            + "<h3>Blood Availability</h3>"
            + "<p>Check recorded blood stock and see which blood groups are available.</p>"
            + "<a class='btn outline' href='/blood-stock'>Check Stock &#8594;</a></div>"

            + "</div></div></section></main>"

            + "<footer><p><strong>LifeDrop</strong> &mdash; Blood Bank Management System</p>"
            + "<p>Donate Blood. Save Lives. &copy; 2026</p></footer>"
            + "</body></html>";
    }
}
