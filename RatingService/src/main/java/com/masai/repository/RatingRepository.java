package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, String> {

}
