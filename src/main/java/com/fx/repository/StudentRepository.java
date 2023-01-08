package com.fx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fx.model.StudentModel;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Long> {

	@Query(value= "Select * from student WHERE name =:name and address=:address",nativeQuery = true)
	List<StudentModel> getByNameAndAddress(@Param(value = "name") String name, @Param(value="address") String address);

}
