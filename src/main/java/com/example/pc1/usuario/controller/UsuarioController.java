package com.example.pc1.usuario.controller;

import com.example.pc1.usuario.domain.Usuario;
import com.example.pc1.usuario.domain.UsuarioService;
import com.example.pc1.usuario.dtos.UserRequestDto;
import com.example.pc1.usuario.dtos.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registro")
    public ResponseEntity<Void> postuser(@RequestBody Usuario user){
        usuarioService.registroUsuario(user);
        return ResponseEntity.created(null).build();
    }

    @GetMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody UserRequestDto userRequestDto){
        Usuario newuser = usuarioService.buscarUsuario(userRequestDto);
        return ResponseEntity.ok().body(newuser);
    }
}
