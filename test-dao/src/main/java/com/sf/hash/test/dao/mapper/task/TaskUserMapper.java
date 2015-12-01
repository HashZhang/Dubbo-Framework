package com.sf.hash.test.dao.mapper.task;

import java.util.List;

import com.sf.hash.test.dao.domain.task.Task;
import com.sf.hash.test.dao.domain.task.TaskUser;
import com.sf.hash.test.dao.domain.user.User;

public interface TaskUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TaskUser record);

    int insertSelective(TaskUser record);

    TaskUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TaskUser record);

    int updateByPrimaryKey(TaskUser record);
    
    List<Task> selectTaskByUserID(long id);
    
    List<User> selectUserByTaskID(long id);
}