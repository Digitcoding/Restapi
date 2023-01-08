package com.fx.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fx.exception.DataNotFoundException;
import com.fx.exception.UserNotFoundException;
import com.fx.model.StudentModel;
import com.fx.repository.StudentRepository;
import com.fx.service.StudentService;




@Service
public class StudentServiceImpl implements StudentService {

	 @Autowired
	 public StudentRepository stuRepo;
	
	@Override
	public void insertData(StudentModel studentModel) {
		
		stuRepo.save(studentModel);
	}

	@Override
	public List<StudentModel> fetchRecord() {
		return stuRepo.findAll();
	}

	@Override
	public void updateRecord(StudentModel studentModel) throws UserNotFoundException {
		if(stuRepo.existsById(studentModel.getId())) {
			   stuRepo.save(studentModel);	
			  List<StudentModel> studentModelResponse= stuRepo.getByNameAndAddress(studentModel.getName(),studentModel.getAddress());
			  System.err.println(studentModelResponse.stream().filter(p->p.getId()==8L).count());
			  System.out.println(studentModelResponse.stream().filter(p->p.getAddress().equals("Achenpudur")).count());
			 System.err.println(studentModelResponse.get(0).getAddress());
		} else {
			
			throw new UserNotFoundException("user not there in our data: "+studentModel.getId() );
		}
     	
	}

	@Override
	public void deleteRecord(Long id) {
		stuRepo.deleteById(id);		
	}

	@Override
	public void getById(long id) throws DataNotFoundException {
	
		if(stuRepo.existsById(id)) {
			stuRepo.findById(id);
			
		} else {
			throw new DataNotFoundException("User not found with this id"+id);
		}
		
		
	}

	
		
	

}
