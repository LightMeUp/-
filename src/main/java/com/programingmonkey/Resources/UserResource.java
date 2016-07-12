package com.programingmonkey.Resources;
import com.programingmonkey.Domain.Count;
import com.programingmonkey.Domain.MobileVerifyCode;
import com.programingmonkey.Domain.VerifyCode;
import com.programingmonkey.Message;
import com.programingmonkey.Service.CountService;
import com.programingmonkey.Service.VerifyCodeService;
import com.programingmonkey.Utils.SaltEncrypt;
import com.programingmonkey.Utils.StringUtil;
import com.programingmonkey.Utils.verifyUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
/**
 * Created by Feng on 7/12/16.
 */
@Path("user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
    @Autowired
    private CountService service;
    @Autowired
    private VerifyCodeService verifyCodeService;

    //
    @GET
    @Path("/regist/{mobile:[0-9]*}")
    public Response getVerifyCode(@PathParam("mobile") final String mobile) {
        if (!verifyUtil.isRightMobile(mobile)) throw new BadRequestException("无效手机号,请从新输入");

            if (service.isRegist(mobile) == true)
                //已经被注册
                throw new BadRequestException(mobile + "此号码已经被注册,请直接登录");

                //  用户频繁请求验证码,两次验证码发送时间小于1分钟
                if (verifyCodeService.isTooOften(mobile))
                    throw new BadRequestException("操作过于频繁,请一分钟后再次尝试");
                String verifyCode = StringUtil.getVerifyCode();
                Date requestDate = new Date();
                VerifyCode code = new VerifyCode();
                code.setMobile(mobile);
                code.setVerifycode(verifyCode);
                code.setRequesttime(requestDate);
                code.setActivetime(new Date(requestDate.getTime() + 5 * 60 * 1000));
                verifyCodeService.add(code);
                Message message = new Message();
                message.setMessage("验证码已经发送:" + verifyCode + "有效时间5分钟");
                return Response.ok(message).build();
    }

    @PUT
    @Path("/regist/mobile")
    public Response RegistByMobile(MobileVerifyCode mobileVerifyCode)
    {
        /*
        * 1.检查验证码是否有效*/
        if (!verifyCodeService.isVerifyCodeEffective(mobileVerifyCode.getMobile(),mobileVerifyCode.getVerifycode())){
            throw new BadRequestException("验证码已经过期,请重新请求验证码");
        }
        VerifyCode verifyCode = verifyCodeService.findByOptions(mobileVerifyCode.getMobile(),mobileVerifyCode.getVerifycode());
        if (verifyCode==null)
            throw new BadRequestException("验证码错误,请重新输入");

        Count count = new Count();
        count.setMobile(mobileVerifyCode.getMobile());             // 设置电话
        count.setId(StringUtil.getUUID());   // 设置账号ID
        count.setRegistDate(new Date());    // 设置注册时间
        count.setLastLoginDate(new Date());   // 设置最后登录时间
        count.setIschecked(0);                // 是否认证,使用手机认证
        count.setSalt(StringUtil.getSalt()); // 设置加盐
        //初始密码为123456
        count.setSecurityToken(SaltEncrypt.Encrypt("123456",count.getSalt())); //设置安全码
        count.setSex("保密");
        service.create(count);
        return Response.ok(count).build();
    }


}
