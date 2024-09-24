package com.example.pc1.usuario.domain;


import com.example.pc1.exceptions.ConflictException;
import com.example.pc1.exceptions.LocalNotFoundException;
import com.example.pc1.usuario.dtos.UserRequestDto;
import com.example.pc1.usuario.dtos.UserResponseDto;
import com.example.pc1.usuario.dtos.UserUpdateDto;
import com.example.pc1.usuario.infraestructure.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.invoke.LambdaConversionException;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    ModelMapper modelMapper;

    public void registroUsuario(Usuario user) throws ConflictException{
        Usuario user1 = usuarioRepository.findUsuarioByUsername(user.getUsername());
        if(user1!=null){
            throw new ConflictException();
        }
        usuarioRepository.save(user);
    }

    public UserResponseDto buscarUsuario(UserRequestDto userRequestDto) throws LocalNotFoundException {


        Usuario usuario1 = usuarioRepository.findUsuarioByUsername(userRequestDto.getUsername());
        Usuario usuario2 = usuarioRepository.findUsuarioByPassword(userRequestDto.getPassword());
        if(usuario1 == null || usuario2 == null){
            throw new LocalNotFoundException();
        }
        if(usuario1.getPassword().equals(usuario2.getPassword())){
            return modelMapper.map(usuario1,UserResponseDto.class);
        }
        return null;
    }

    public UserResponseDto buscarUsuarioString(String user, String password, UserUpdateDto newusuario)throws LocalNotFoundException{


        Usuario usuario1 = usuarioRepository.findUsuarioByUsername(user);
        Usuario usuario2 = usuarioRepository.findUsuarioByPassword(password);
        if(usuario1 == null || usuario2 == null){
            throw new LocalNotFoundException();
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
