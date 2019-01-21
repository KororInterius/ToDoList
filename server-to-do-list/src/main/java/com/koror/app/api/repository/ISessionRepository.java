package com.koror.app.api.repository;

import com.koror.app.entity.Session;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ISessionRepository {

    @Insert("insert into `session` (`ID`, `USERID`, `SIGNATURE`, `IP`) values(#{id}, #{userId}, #{signature}, #{ip})")
    void add(Session session);

    @Delete("delete from `session` where `ID` = #{id}")
    void delete(String id);

    @Select("select * from `session` where `ID` = #{id}")
    @Results(value = {
            @Result(property = "id", column = "ID"),
            @Result(property = "userId", column = "USERID"),
            @Result(property = "signature", column = "SIGNATURE"),
            @Result(property = "ip", column = "IP")
    })
    Session getById(String id);

    @Select("select * from `session`")
    @Results(value = {
            @Result(property = "id", column = "ID"),
            @Result(property = "userId", column = "USERID"),
            @Result(property = "signature", column = "SIGNATURE"),
            @Result(property = "ip", column = "IP")
    })
    List<Session> getList();

    @Update("update `session` set `USERID` = #{userId}, `SIGNATURE` = #{signature} where `ID` = #{id}")
    void update(Session session);

}