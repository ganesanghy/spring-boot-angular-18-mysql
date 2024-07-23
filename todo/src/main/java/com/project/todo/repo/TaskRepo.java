package com.project.todo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.todo.model.Task;

@Repository	
public interface TaskRepo extends JpaRepository<Task,Long>{

}
