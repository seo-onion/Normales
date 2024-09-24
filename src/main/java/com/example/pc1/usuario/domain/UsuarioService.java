package com.example.pc1.usuario.domain;


import com.example.pc1.usuario.dtos.UserRequestDto;
import com.example.pc1.usuario.dtos.UserResponseDto;
import com.example.pc1.usuario.dtos.UserUpdateDto;
import com.example.pc1.usuario.infraestructure.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    ModelMapper modelMapper;

    public void registroUsuario(Usuario user){
        usuarioRepository.save(user);
    }

    public UserResponseDto buscarUsuario(UserRequestDto userRequestDto){


        Usuario usuario1 = usuarioRepository.findUsuarioByUsername(userRequestDto.getUsername());
        Usuario usuario2 = usuarioRepository.findUsuarioByPassword(userRequestDto.getPassword());
        if(usuario1 == null || usuario2 == null){
            throw new RuntimeException("Error 404");
        }
        if(usuario1.getPassword().equals(usuario2.getPassword())){
            return modelMapper.map(usuario1,UserResponseDto.class);
        }
        return null;
    }

    public UserResponseDto buscarUsuarioString(String user, String password, UserUpdateDto newusuario){


        Usuario usuario1 = usuarioRepository.findUsuarioByUsername(user);
        Usuario usuario2 = usuarioRepository.findUsuarioByPassword(password);
        if(usuario1 == null || usuario2 == null){
            throw new RuntimeException("Error 404");
        }
        if(usuario1.getPassword().equals(usuario2.getPassword())){
            usuario1 = modelMapper.map(newusuario,Usuario.class);
            usuario1.setId(usuario2.getId());
            usuario1.setUsername(usuario2.getUsername());
            return modelMapper.map(usuario1,UserResponseDto.class);
        }
        return null;
    }



}
