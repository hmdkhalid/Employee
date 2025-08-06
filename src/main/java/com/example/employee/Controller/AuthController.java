package com.example.employee.Controller;

import com.example.employee.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins ="http://localhost:8085") // Permet toutes les origines pendant les tests
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> loginData) {
        try {
            String username = loginData.get("username");
            String password = loginData.get("password");

            System.out.println("Tentative de connexion: " + username);

            boolean isAuthenticated = authService.authenticate(username, password);

            if (isAuthenticated) {
                return ResponseEntity.ok(Map.of(
                        "success", true,
                        "message", "Connexion réussie"
                ));
            } else {
                return ResponseEntity.status(401).body(Map.of(
                        "success", false,
                        "message", "Identifiants incorrects"
                ));
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de la connexion: " + e.getMessage());
            return ResponseEntity.status(500).body(Map.of(
                    "success", false,
                    "message", "Erreur serveur"
            ));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register(@RequestBody Map<String, String> registerData) {
        try {
            String username = registerData.get("username");
            String password = registerData.get("password");

            System.out.println("Tentative d'inscription pour: " + username);

            boolean registered = authService.register(username, password);

            if (registered) {
                return ResponseEntity.ok(Map.of(
                        "success", true,
                        "message", "Compte créé avec succès"
                ));
            } else {
                return ResponseEntity.status(400).body(Map.of(
                        "success", false,
                        "message", "Nom d'utilisateur déjà utilisé"
                ));
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de l'inscription: " + e.getMessage());
            return ResponseEntity.status(500).body(Map.of(
                    "success", false,
                    "message", "Erreur serveur"
            ));
        }
    }

    @GetMapping("/test")
    public ResponseEntity<Map<String, Object>> test() {
        return ResponseEntity.ok(Map.of(
                "success", true,
                "message", "API Auth fonctionne correctement"
        ));
    }
}
