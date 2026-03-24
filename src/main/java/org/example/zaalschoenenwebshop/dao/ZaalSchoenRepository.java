package org.example.zaalschoenenwebshop.dao;

import org.example.zaalschoenenwebshop.models.ZaalSchoen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZaalSchoenRepository extends JpaRepository<ZaalSchoen, Long> {

    ZaalSchoen findByName(String name);

}