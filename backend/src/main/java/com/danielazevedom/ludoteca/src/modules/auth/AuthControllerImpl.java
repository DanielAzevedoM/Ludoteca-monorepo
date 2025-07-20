package com.danielazevedom.ludoteca.src.modules.auth;

import com.danielazevedom.ludoteca.src.modules.auth.interfaces.AuthController;
import com.danielazevedom.ludoteca.src.modules.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthControllerImpl implements AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @Override
    @GetMapping("/google")
    public RedirectView redirectToGoogle() {
        String clientId    = System.getProperty("GOOGLE_CLIENT_ID");
        String redirectUri = System.getProperty("GOOGLE_REDIRECT_URI");
        String url = "https://accounts.google.com/o/oauth2/v2/auth"
          + "?client_id="    + clientId
          + "&redirect_uri=" + redirectUri
          + "&response_type=code"
          + "&scope=openid%20email%20profile";
        return new RedirectView(url);
    }

    @Override
    @GetMapping("/google/callback")
    public RedirectView handleGoogleCallback(@RequestParam("code") String code) {
        String frontend = System.getProperty("FRONTEND_URL", "http://localhost:3000");
        try {
            Map<String, Object> authResponse = authService.authenticateWithGoogle(code);
            userService.findOrCreateUserFromGoogle(authResponse);
            String idToken = (String) authResponse.get("id_token");
            // Redirect with token, encoding safely without checked exception
            String url = frontend + "/?token=" + URLEncoder.encode(idToken, StandardCharsets.UTF_8);
            return new RedirectView(url);
        } catch (Exception e) {
            String error = URLEncoder.encode(e.getMessage(), StandardCharsets.UTF_8);
            return new RedirectView(frontend + "/?error=" + error);
        }
    }
}
