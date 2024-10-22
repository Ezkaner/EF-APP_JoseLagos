package pe.edu.cibertec.EF_APP_Lagos.SilvaJose.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @CircuitBreaker(name = "usuarioService", fallbackMethod = "fallbackErrorUsuario")
    public String verificarUsuarios(String nomUsuario) {
        if (nomUsuario.length() > 20 || nomUsuario.contains(" ") || !nomUsuario.matches("^[a-zA-Z0-9]*$")) {
            throw new RuntimeException("No se pudo verificar correctamente el nombre de usuario.");
        }
        return "El usuario con nombre ' "+nomUsuario+ " ' está habilitado para su registro.";
    }

    public String fallbackErrorUsuario(String nomUsuario, Throwable t) {
        return "[!] Error de verificación.";
    }
}