package com.pym.service;

import com.pym.entity.StudyInfo;

import java.util.List;

/**
 * 功能描述:
 *
 * @Author pym
 * @Date 16/7/7.
 */
public interface IStudyService {

    public List<StudyInfo> getAllClzByStuId(String stuId);

    public List<StudyInfo> getAllStuByClzId(Integer clzId);

    public void delCourse(String stuId,Integer clzId);

}
