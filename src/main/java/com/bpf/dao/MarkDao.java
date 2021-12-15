package com.bpf.dao;

import com.bpf.bean.Mark;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MarkDao extends JpaRepository<Mark, Integer> {

    List<Mark> findMarkByName(String name);

    @Query(nativeQuery = true, value = "select id, name from t_mark where name=:name and user_id=:id")
    Mark findMarkByNameAndUserIdEquals(@Param("name") String name, Integer id);
}
