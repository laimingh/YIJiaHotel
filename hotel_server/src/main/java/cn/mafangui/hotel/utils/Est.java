package cn.mafangui.hotel.utils;

import cn.mafangui.hotel.mapper.UserMapper;
import cn.mafangui.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class Est {
    @Autowired
    public  static  MD5Utils md5Utils;
    public static void main(String[] args) {
        System.out.println(Est.md5Utils.MD5Encode("123456"));
    }

}
