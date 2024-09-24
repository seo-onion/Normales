package com.example.pc1.kart.infrastructure;

import com.example.pc1.kart.domain.Kart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KartRepository extends JpaRepository<Kart,Long> {
}
