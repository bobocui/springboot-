package com.springboot.jap.jpademo.controller;

import com.springboot.jap.jpademo.common.CommonResult;
import com.springboot.jap.jpademo.pojo.Member;
import com.springboot.jap.jpademo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping(value = "/addMember")
    //添加一个会员
    public CommonResult addMember(@RequestBody Member member) {
        CommonResult result = new CommonResult();
        try {
            memberService.addMember(member);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }

    //修改一个会员(jpa是根据id来修改的)
    @PutMapping(value = "/updateMember")
    public CommonResult updateMemberById(Member member) {
        CommonResult result = new CommonResult();
        try {
            memberService.updateMember(member);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }

    //根据id删除一条数据
    @DeleteMapping(value = "/deleteMember/{id}")
    public CommonResult deleteMemberById(@PathVariable(name = "id", required = true) Long id) {
        CommonResult result = new CommonResult();
        try {
            memberService.deleteMemberById(id);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }

    //查询所有
    @GetMapping(value = "/findAll")
    public CommonResult findAll() {
        CommonResult result = new CommonResult();
        try {
            List<Member> list = memberService.findAll();
            //将查询结果封装到CommonResult中
            result.setData(list);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }

    //根据id查询一条数据(2.0后不能使用findOne了)
    @GetMapping(value = "/findMemberById/{id}")
    public CommonResult findMemberById(@PathVariable(name = "id") Long id) {
        CommonResult result = new CommonResult();
        try {
            Member member = memberService.findMemberById(id);
            //将查询结果封装到CommonResult中
            result.setData(member);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }

    //根据会员姓名查询多条数据
    @GetMapping(value = "/findMemberByName")
    public CommonResult findMemberByName(String name) {
        CommonResult result = new CommonResult();
        try {
            List<Member> memberList = memberService.findMemberByName(name);
            //将查询结果封装到CommonResult中
            result.setData(memberList);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }
}
