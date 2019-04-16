package com.example.lianxi0325.controller;

import com.example.lianxi0325.dto.UserChangePwdDTO;
import com.example.lianxi0325.dto.UserRegisterDTO;
import com.example.lianxi0325.entity.User;
import com.example.lianxi0325.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.Size;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@EnableAutoConfiguration
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //登录
    @GetMapping("/login")
    public void login(
            @RequestParam @Size(min=2,max=12) String username,
            @RequestParam @Size(min=6,max=20) String password, HttpSession httpSession) throws Exception {

        logger.info("username={},password={}",username,password);

        User user = userService.selectUser(username);

        //用户名校验
        if (user==null){
            throw new Exception("username doesn't exist");
        }

        String salt = user.getSalt();
        String saltPassword = password+salt;
        String inputMd5Password = DigestUtils.md5DigestAsHex(saltPassword.getBytes());

        String  md5Password = user.getPassword();

        //密码校验
        if (!inputMd5Password.equals(md5Password)){
            throw new Exception("password is invalid");
        }

        //获取sessionid并把用户信息保存到session
        String id = httpSession.getId();
        httpSession.setAttribute(id,user);

    }

    //注册
    @PostMapping("/register")
    public Integer register(@RequestBody UserRegisterDTO userRegisterDTO){

        logger.info("userRegisterDTO={}",userRegisterDTO);

        User user = new User();

        user.setUsername(userRegisterDTO.getUsername());

        //盐
        String salt = UUID.randomUUID().toString();
        user.setSalt(salt);

        String saltPassword = userRegisterDTO.getPassword()+salt;
        String md5Password = DigestUtils.md5DigestAsHex(saltPassword.getBytes());

        user.setPassword(md5Password);

        userService.insert(user);

        return user.getId();
    }

    //修改密码
    @PostMapping("/changePwd")
    public void changePassword(@RequestBody UserChangePwdDTO userChangePwdDTO,HttpSession httpSession) throws Exception {

        logger.info("oldPassword={},newPassword={}",userChangePwdDTO.getOldPassword(),userChangePwdDTO.getNewPassword());

        //根据sessionid获取session存的用户
        User currentUser = (User) httpSession.getAttribute(httpSession.getId());

        //根据session判断用户是否登录
        if(currentUser==null){
            throw new Exception("user doesn't login");
        }

        String salt = currentUser.getSalt();

        //旧密码+盐
        String oldSaltPassword = userChangePwdDTO.getOldPassword()+salt;
        //旧MD5密码
        String oldMd5Password = DigestUtils.md5DigestAsHex(oldSaltPassword.getBytes());

        //判断旧密码是否正确
        if(!oldMd5Password.equals(currentUser.getPassword())){
            throw new Exception("oldPassword is invalid");
        }

        String newSalt = UUID.randomUUID().toString();
        currentUser.setSalt(newSalt);

        //新md5密码
        String newSaltPassword = userChangePwdDTO.getNewPassword()+newSalt;
        String newMD5Password = DigestUtils.md5DigestAsHex(newSaltPassword.getBytes());

        currentUser.setPassword(newMD5Password);

        //清空session
        httpSession.removeAttribute(httpSession.getId());

        userService.updatePassword(currentUser);

    }

}
