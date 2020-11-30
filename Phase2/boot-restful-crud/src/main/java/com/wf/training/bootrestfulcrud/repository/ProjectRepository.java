package com.wf.training.bootrestfulcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wf.training.bootrestfulcrud.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{

}
