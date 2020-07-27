package com.psh.termon.repos;

import com.psh.termon.data.Lesson;
import com.psh.termon.data.Module;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ModuleRep extends CrudRepository<Module, Long> {
    //List<Module> findByCourse_Id(Long id);
    List<Module> findByCourse_Id(Long id);
}
