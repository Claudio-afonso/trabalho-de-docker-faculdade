package com.example.login;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping
@CrossOrigin(origins = "*") // permite frontend local/estático
public class AuthController {

    // Credenciais estáticas conforme requisito (sem BD)
    private static final String USUARIO_VALIDO = "admin";
    private static final String SENHA_VALIDA = "123456";

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest req, BindingResult br) {
        if (br.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new Message("Requisição inválida: " + br.getAllErrors().get(0).getDefaultMessage()));
        }
        if (USUARIO_VALIDO.equals(req.getUsuario()) && SENHA_VALIDA.equals(req.getSenha())) {
            return ResponseEntity.ok(new Message("Login bem-sucedido!"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new Message("Credenciais inválidas"));
        }
    }

    // Classe simples para padronizar resposta JSON
    static class Message {
        private String mensagem;
        public Message(String mensagem) { this.mensagem = mensagem; }
        public String getMensagem() { return mensagem; }
        public void setMensagem(String mensagem) { this.mensagem = mensagem; }
    }
}
