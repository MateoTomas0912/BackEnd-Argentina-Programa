package com.argentinaprograma.ap.repository;

import com.argentinaprograma.ap.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfoRepo extends JpaRepository<Usuario,Long> {
}
