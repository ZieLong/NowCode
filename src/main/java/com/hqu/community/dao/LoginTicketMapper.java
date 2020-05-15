package com.hqu.community.dao;

import com.hqu.community.entity.LoginTicket;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
@Deprecated
public interface LoginTicketMapper {
    @Insert({
            "insert into login_ticket (user_id, ticket, status, expired)" ,
                    "values(#{userId}, #{ticket}, #{status}, #{expired})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertLoginTicket(LoginTicket loginTicket);

    @Select({"select id,user_id,ticket,status,expired " ,
            "from login_ticket where ticket=#{ticket}"
    })
    LoginTicket selectByTicket(String ticket);

    @Update({
            "Update login_ticket set status=#{status} where ticket = #{ticket}"
    })
    int updateStatus(@Param("ticket") String ticket,
                     @Param("status") int status);
}
