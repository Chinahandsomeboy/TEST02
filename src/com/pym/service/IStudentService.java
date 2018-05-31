package com.pym.service;

import com.pym.entity.Student;

/**
 * Created by pym on 16/6/22.
 */
public interface IStudentService {

    public Student login(String id,String pwd);
    public boolean update(Student student);
    public boolean delete(String id);

    /**
     *  @return 0 成功,1 已经选过此课程,2 已选满,-1 未知错误
     */
    public int selectCource(String stuId, Integer clzId);

    public boolean changePwd(String stuId, String old,String newpwd);
}
