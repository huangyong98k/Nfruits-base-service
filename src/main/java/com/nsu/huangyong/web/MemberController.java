package com.nsu.huangyong.web;

import com.nsu.huangyong.common.constant.CommonRespCode;
import com.nsu.huangyong.service.MemberService;
import com.nsu.huangyong.vo.CommonResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/api")
@Api(value = "API-base-service",description = "会员业务支撑服务")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @ApiOperation(value ="会员登录" )
    @GetMapping("/member/login")
    public CommonResp login(@RequestParam("phoneNo") String phoneNo,
                            @RequestParam("loginPassword") String loginPassword,
                            HttpServletRequest request){
        log.info("recevie phoneNo:{}    loginPassword:{}",phoneNo,loginPassword);
        if(memberService.memberLogin(phoneNo,loginPassword,request)){
            return new CommonResp(CommonRespCode.SUCCESS);
        }
        return new CommonResp(CommonRespCode.FAIL,"用户名或密码错误");
    }

    @ApiOperation(value ="会员注册" )
    @GetMapping("/member/register")
    public CommonResp register(@RequestParam("phoneNo") String phoneNo,
                               @RequestParam("password") String password,
                               @RequestParam("captcha") String captcha,
                               HttpServletRequest request){
        log.info("recevie phoneNo:{}    password:{}    captcha:{}",phoneNo,password,captcha);
        if(memberService.memberRegister(phoneNo,password,captcha,request)){
            return new CommonResp(CommonRespCode.SUCCESS);
        }
        return new CommonResp(CommonRespCode.FAIL,"注册失败");
    }

    @ApiOperation(value ="密码找回" )
    @GetMapping("/member/resetregister")
    public CommonResp resetRegister(@RequestParam("phoneNo") String phoneNo,
                               @RequestParam("password") String password,
                               @RequestParam("captcha") String captcha,
                               HttpServletRequest request){
        log.info("recevie phoneNo:{}    password:{}    captcha:{}",phoneNo,password,captcha);
        if(memberService.resetPassword(phoneNo,password,captcha,request)){
            return new CommonResp(CommonRespCode.SUCCESS);
        }
        return new CommonResp(CommonRespCode.FAIL,"验证码错误");
    }

    @ApiOperation(value ="检验是否存在此用户" )
    @GetMapping("/member/isregister")
    public CommonResp isRegister(@RequestParam("phoneNo") String phoneNo, HttpServletRequest request){
        log.info("recevie  phoneNo:{}",phoneNo);
        if(memberService.isRegister(phoneNo)){
            return new CommonResp(CommonRespCode.SUCCESS);
        }
        return new CommonResp(CommonRespCode.FAIL,"该号码未注册");
    }

    @ApiOperation(value ="实名认证" )
    @GetMapping("/member/certification")
    public CommonResp certification(@RequestParam("member")String member,
                                    @RequestParam("trueName")String trueName,
                                    @RequestParam("certificateType")String certificateType,
                                    @RequestParam("certificateNo")String certificateNo){
        log.info("recevie message:{},{},{},{}",member,trueName,certificateType,certificateNo);
        return memberService.certification(member,trueName,certificateType,certificateNo);
    }

    @ApiOperation(value ="修改个人信息" )
    @GetMapping("/member/updataMember")
    public CommonResp modifyMember(@RequestParam("memberNo") String memberNo,
                                   @RequestParam("nickname")String nickname,
                                   @RequestParam("sex")String sex,
                                   @RequestParam("birthDate")String birthDate){
        log.info("recevie message:{},{},{},{}",memberNo,nickname,sex,birthDate);
        boolean isTrue = memberService.modifyMember(memberNo,nickname,sex,birthDate);
        if (isTrue){
            log.info("updata member success!!!");
            return new CommonResp(CommonRespCode.SUCCESS);
        } else {
            log.error("updata member failed!!");
            return new CommonResp(CommonRespCode.FAIL,"修改失败！！！");
        }
    }


}
