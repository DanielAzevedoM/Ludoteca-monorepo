package com.danielazevedom.ludoteca.src.modules.auth;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AuthService {

    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @SuppressWarnings("unchecked")
    public Map<String, Object> authenticateWithGoogle(String code) throws IOException, InterruptedException {
        String clientId = System.getProperty("GOOGLE_CLIENT_ID");
        String clientSecret = System.getProperty("GOOGLE_CLIENT_SECRET");
        String redirectUri = System.getProperty("GOOGLE_REDIRECT_URI");

        // Monta o body da requisição de token
        String body = "code=" + URLEncoder.encode(code, StandardCharsets.UTF_8)
                + "&client_id=" + URLEncoder.encode(clientId, StandardCharsets.UTF_8)
                + "&client_secret=" + URLEncoder.encode(clientSecret, StandardCharsets.UTF_8)
                + "&redirect_uri=" + URLEncoder.encode(redirectUri, StandardCharsets.UTF_8)
                + "&grant_type=authorization_code";

        HttpRequest tokenRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://oauth2.googleapis.com/token"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        HttpResponse<String> tokenResponse = httpClient.send(tokenRequest, HttpResponse.BodyHandlers.ofString());
        if (tokenResponse.statusCode() != 200) {
            throw new RuntimeException("Falha ao trocar código por token: " + tokenResponse.body());
        }

        Map<String, Object> tokenData = objectMapper.readValue(tokenResponse.body(), Map.class);
        String idToken = (String) tokenData.get("id_token");

        // Busca informações do usuário
        String accessToken = (String) tokenData.get("access_token");
        HttpRequest userInfoRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://www.googleapis.com/oauth2/v2/userinfo?access_token=" + accessToken))
                .GET()
                .build();

        HttpResponse<String> userInfoResponse = httpClient.send(userInfoRequest, HttpResponse.BodyHandlers.ofString());
        if (userInfoResponse.statusCode() != 200) {
            throw new RuntimeException("Falha ao obter informações do usuário: " + userInfoResponse.body());
        }

        Map<String, Object> profileData = objectMapper.readValue(userInfoResponse.body(), Map.class);

        // Retorna profile e idToken juntos
        Map<String, Object> response = new HashMap<>(profileData);
        response.put("id_token", idToken);
        return response;
    }
}