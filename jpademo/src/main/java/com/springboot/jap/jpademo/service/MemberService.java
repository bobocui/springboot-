package com.springboot.jap.jpademo.service;

import com.springboot.jap.jpademo.dao.MemberDao;
import com.springboot.jap.jpademo.pojo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MemberService {

    @Autowired
    private MemberDao memberDao;

    //插入会员
    public void addMember(Member member) {
        memberDao.save(member);
    }

    //修改会员
    public void updateMember(Member member) {
        memberDao.save(member);
    }

    //很久会员ID去删除一个会员
    public void deleteMemberById(Long id) {
        memberDao.deleteById(id);
    }

    //查询所有会员
    public List<Member> findAll() {
        return memberDao.findAll();
    }

    //根据ID去查询一条数据  注意2.0之后不能使用findOne
    public Member findMemberById(Long id) {
        return memberDao.findById(id).get();
    }

    //根据姓名去查询会员
    public List<Member> findMemberByName(String name) {
        return memberDao.findByName(name);
    }

    //根据地址去查询会员
    public List<Member> findMemberByAddress(String address) {
        return memberDao.findByAddress(address);
    }
}
