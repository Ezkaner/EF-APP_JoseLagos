package pe.edu.cibertec.EF_APP_Lagos.SilvaJose.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.EF_APP_Lagos.SilvaJose.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/verificar/{nomUsuario}")
    public ResponseEntity<String> verificarUsuario(@PathVariable String nomUsuario) {
        return ResponseEntity.ok(usuarioService.verificarUsuarios(nomUsuario));
    }
}