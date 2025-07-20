package com.danielazevedom.ludoteca.src.modules.auth.interfaces;

import org.springframework.web.servlet.view.RedirectView;

public interface AuthController {
    RedirectView redirectToGoogle();
    RedirectView handleGoogleCallback(String code);
}