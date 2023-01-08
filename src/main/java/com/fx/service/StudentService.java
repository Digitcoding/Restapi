package com.fx.service;

import java.util.List;

import com.fx.exception.DataNotFoundException;
import com.fx.exception.UserNotFoundException;
import com.fx.model.StudentModel;

public interface StudentService {

	void insertData(StudentModel studentModel);

	List<StudentModel> fetchRecord();
	

	void updateRecord(StudentModel studentModel) throws UserNotFoundException;

	void deleteRecord(Long id);

	void getById(long id) throws DataNotFoundException;

	

}
