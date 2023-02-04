package com.ejemplo.SpringBoot.Security.Repository;

import com.ejemplo.SpringBoot.Security.Entity.Rol;
import com.ejemplo.SpringBoot.Security.Enum.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
