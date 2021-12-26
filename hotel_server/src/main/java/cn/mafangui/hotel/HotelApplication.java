package cn.mafangui.hotel;

import cn.mafangui.hotel.entity.User;
import cn.mafangui.hotel.mapper.UserMapper;
import org.testng.annotations.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = "cn.mafangui.hotel.mapper")
public class HotelApplication {


    public static void main(String[] args) {
        SpringApplication.run(HotelApplication.class, args);
    }

    /*@Test
    public void tt(){
        User user = userMapper.selectByUsernameAndPassword("zhangsan", "123456");
        System.out.println(user);

    }*/
}
