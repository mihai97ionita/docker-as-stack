package com.mihai97ionita.docker.repository;
import com.mihai97ionita.docker.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Shop, Long> {

}
