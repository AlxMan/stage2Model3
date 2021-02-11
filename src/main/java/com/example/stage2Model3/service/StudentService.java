package com.example.stage2Model3.service;

import com.example.stage2Model3.dao.StudentDao;
import com.example.stage2Model3.entity.Student;


public class StudentService {
    public boolean AddStudent(Student student) {
        boolean flag=false;
        if(!StudentDao.isExist(student.getId())) {
            StudentDao.AddStudent(student);
            flag=true;
        }else {
            System.out.println("此人已存在");
        }
        return flag;
    }

}
