package com.springboot.jap.jpademo.dao;

import com.springboot.jap.jpademo.pojo.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 */
public interface MemberDao extends JpaRepository<Member, Long> {

    //根据会员名称查询
    public List<Member> findByName(String name);

    public List<Member> findByAddress(String addresss);

}
