package cn.mafangui.hotel.controller.user;

import cn.mafangui.hotel.entity.User;
import cn.mafangui.hotel.response.AjaxResult;
import cn.mafangui.hotel.response.MsgType;
import cn.mafangui.hotel.response.ResponseTool;
import cn.mafangui.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

   /*
     * 更新用户信息
     * @param userId
     * @param name
     * @param gender
     * @param phone
     * @param email
     * @param address
     * @param idcard
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/update")
    public AjaxResult userUpdate(Integer userId,String username, String name, String gender, String phone,
                                 String email, String address, String idcard, HttpServletRequest request){

        HttpSession session = request.getSession();
        System.out.println(userId);
        if (!session.getAttribute("userId").equals(userId)){
            return ResponseTool.failed(MsgType.PERMISSION_DENIED);
        }
        System.out.println(username);
        User user = new User();
        user.setUserId(userId);
//        user.setUsername(username);
        user.setName(name);
        user.setGender(gender);
        user.setPhone(phone);
        user.setEmail(email);
        user.setAddress(address);
        user.setIdcard(idcard);
        System.out.println(user);
        if(userService.updateUser(user)==1)
            return ResponseTool.success("修改成功");
        return ResponseTool.success("未获取到当前userid");
    }
    @RequestMapping(value = "/queryPassword",method = RequestMethod.POST)
    public AjaxResult queryPassword(String username, String idCard,HttpServletRequest request) {

        if(StringUtils.isEmpty(username)){
            return ResponseTool.failed("用户名不能为空");
        }else if(StringUtils.isEmpty(idCard)) {
            return ResponseTool.failed("身份证号不能为空");
        }
      /*  List<RoomType> rooms=roomTypeService.findAllType();
        for (RoomType room : rooms) {
            System.out.println(room);
        }*/

        User user  =  userService.selectByUsernameAndIdCard(username, idCard);


        if(user==null){
            return ResponseTool.failed("用户名或身份证号不正确");
        }
        HttpSession session = request.getSession();
        session.setAttribute("userId",user.getUserId());
        session.setAttribute("idCard",user.getIdcard());
        HashMap map = new HashMap<>();
//        map.put("sessionId",session.getId());
        map.put("psd",user.getPsd());


        return ResponseTool.success(map);
//        return ResponseTool.success();

    }
    /**
     * 更改密码
     * @param username
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/updatePassword")
    public AjaxResult updatePassword(String username,String oldPassword,String newPassword){
        User user = userService.selectByUsernameAndPassword(username,oldPassword);
        if (user == null){
            return ResponseTool.failed("密码不对");
        }
        user.setPassword(newPassword);
        if(userService.updateUser(user)==1)
            return ResponseTool.success("修改成功");
        return ResponseTool.failed("修改失败");
    }

    /**
     *  获取个人资料
     * @param request
     * @return
     */
    @RequestMapping(value = "/profile")
    public AjaxResult getProfile(HttpServletRequest request){
        String username = (String) request.getSession().getAttribute("username");
        User user = userService.selectByUsername(username);

        if(user==null) return ResponseTool.failed("未知错误");

//        user.setPassword(null);
//        StringBuilder sb = new StringBuilder(user.getIdcard());
//        sb.replace(5,12,"********");
//        user.setIdcard(sb.toString());
        return ResponseTool.success(user);
    }



    /**
     * 注销
     * @param request
     * @return
     */
    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public AjaxResult logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("userId");
        session.removeAttribute("username");
        return ResponseTool.success("注销成功");
    }


}
