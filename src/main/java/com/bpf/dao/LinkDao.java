package com.bpf.dao;

import com.bpf.bean.Link;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LinkDao extends JpaRepository<Link, Integer> {

    @Query(nativeQuery = true,
            value = "select id, name, url, icon, comment, create_time from t_link where name like %:name% and user_id=:userId")
    List<Link> findLinksByNameLikeAndUserIdEquals(@Param("name") String name,@Param("userId") Integer userId);

    @Query(nativeQuery = true,
            value = "select id, name, url, icon, comment, create_time from t_link where url like %:url% and user_id=:userId")
    List<Link> findLinksByUrlContainsAndUserIdEquals(@Param("url") String url,@Param("userId") Integer userId);

    @Query(nativeQuery = true,
            value = "select id, name, url, icon, comment, create_time from t_link where name=:name and user_id=:userId")
    Link findLinkByNameAndUserIdEquals(@Param("name") String name,@Param("userId") Integer userId);
}
