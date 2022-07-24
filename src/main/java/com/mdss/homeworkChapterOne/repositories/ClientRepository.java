package com.mdss.homeworkChapterOne.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mdss.homeworkChapterOne.entities.Client;


public interface ClientRepository extends JpaRepository<Client, Long> {

}
