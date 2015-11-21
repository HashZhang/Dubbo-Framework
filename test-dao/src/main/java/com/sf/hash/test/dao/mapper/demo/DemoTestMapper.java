package com.sf.hash.test.dao.mapper.demo;

import java.util.List;

import com.sf.hash.test.dao.domain.demo.DemoTest;
import com.sf.hash.test.dao.domain.demo.extend.DemoTestExtend;

public interface DemoTestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DemoTest record);

    int insertSelective(DemoTest record);

    DemoTest selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DemoTest record);

    int updateByPrimaryKey(DemoTest record);
    
    List<DemoTestExtend> selectAll();
    
    int deleteByCode(String code);

	List<DemoTest> selectByCode(String code);
}