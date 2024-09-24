package com.example.pc1.usuario.controller;

import com.example.pc1.usuario.domain.Usuario;
import com.example.pc1.usuario.domain.UsuarioService;
import com.example.pc1.usuario.dtos.UserRequestDto;
import com.example.pc1.usuario.dtos.UserResponseDto;
import com.example.pc1.usuario.dtos.UserUpdateDto;
import org.apache.catalina.User;
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

    @GetMapping("/ingreso")
    public ResponseEntity<UserResponseDto> login(@RequestBody UserRequestDto userRequestDto){
        UserResponseDto newuser = usuarioService.buscarUsuario(userRequestDto);
        return ResponseEntity.ok().body(newuser);
    }

    @PatchMapping("/update")
    public ResponseEntity<UserResponseDto> update(@RequestParam String username,@RequestParam String password,@RequestBody UserUpdateDto usuario){
        UserResponseDto newuser = usuarioService.buscarUsuarioString(username,password,usuario);
        return ResponseEntity.ok().body(newuser);
    }
}
