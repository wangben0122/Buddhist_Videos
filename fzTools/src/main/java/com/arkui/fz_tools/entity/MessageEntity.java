package com.arkui.fz_tools.entity;

/**
 * Created by 郭庆文 on 17/11/8 上午10:45
 */

public class MessageEntity{

    /**
     * is_read : 0
     * create_time : 2017-11-06 16:50:15
     * user_id : 1
     * id : 2
     * type : global
     * title : 徐一号
     * content : eeeeee
     */

    private String is_read;
    private String create_time;
    private String user_id;
    private String id;
    private String type;
    private String title;
    private String content;

    public String getIs_read() {
        return is_read;
    }

    public void setIs_read(String is_read) {
        this.is_read = is_read;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
