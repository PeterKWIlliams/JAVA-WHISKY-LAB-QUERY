package com.codeclan.example.WhiskyTracker.repositories;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WhiskyRepository extends JpaRepository<Whisky, Long> {
    List<Whisky> findWhiskyByYear(int year);
    List<Whisky> findByDistilleryNameAndAge(String name,int age);
    List<Whisky> findByDistilleryRegionIgnoreCase(String region);

}