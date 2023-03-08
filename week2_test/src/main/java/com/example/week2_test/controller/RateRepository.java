package com.example.week2_test.controller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

// public class CrncRateRepository {

// }
public interface RateRepository extends JpaRepository<Rate, String> {
    List<Rate> findAll();
}