package cn.mafangui.hotel.entity;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Data;

import java.util.Date;
@Data
public class Image {
    private String id;

    private String boardId;

    private String name;

    private String image;

    private Date createDt;

    private String creator;
}
