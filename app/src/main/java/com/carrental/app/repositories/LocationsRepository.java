package com.carrental.app.repositories;

import com.carrental.app.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationsRepository extends JpaRepository<Location, Long> {
}
