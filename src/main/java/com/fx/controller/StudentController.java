package com.fx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fx.exception.DataNotFoundException;
import com.fx.exception.UserNotFoundException;
import com.fx.model.StudentModel;
import com.fx.service.StudentService;

@RestController
@RequestMapping("api/Student")
public class StudentController {
	
	@Autowired
	public StudentService stuService;
	
	/**
	 * @author ajith
	 * @param studentModel
	 * @return
	 */
	@PostMapping(value = "v1/api/insert")
	public String insertStudentData(@RequestBody StudentModel studentModel) {
		
		stuService.insertData(studentModel);
		return "Student Record Create sucessfully!!!";
	}
	
	@GetMapping(value = "v1/api/fetch")
	public List<StudentModel> fetchStudentData(){
		
		
		return stuService.fetchRecord();
	}
	
	
	@GetMapping(value = "{id}")
	public String getStudentDataId(@PathVariable(value = "id") long id) throws DataNotFoundException {
		stuService.getById(id);
		return "the record details are" + id;
	}
	
	
	@PutMapping(value ="v1/api/update")
	public String updateRecord(@RequestParam Long id, @RequestBody StudentModel studentModel) throws UserNotFoundException{
		studentModel.setId(id);
		stuService.updateRecord(studentModel);
		
		return "update record successfully !!!";
		
	}
	
	@DeleteMapping(value = "v1/api/delete/{id}")
	public String deleteRecord(@PathVariable Long id) {
		stuService.deleteRecord(id);
		return "delete the record successfully !!!";
	}
	

}
