package com.tenco.Repo.interfaces.student;

import com.tenco.model.student.StudentDTO;

public interface StudentRepository {


    StudentDTO studentInfo(int id);

//    StudentDTO selectStudentById(int id);

    // 보류 (내 정보 수정)
//    StudentDTO studentInfoModify(int password, String email, String tel, String address, int id);


}