package cn.mafangui.hotel.controller.common;

import cn.mafangui.hotel.entity.Image;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/image")
public class ImageController {
    @PostMapping
    public Object add(Image image){
        System.out.println(image.toString());
        return image;
    }
}
