package com.example.pc1.usuario.infraestructure;


import com.example.pc1.usuario.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    Usuario findUsuarioByUsername(String username);
    Usuario findUsuarioByPassword(String password);
}
