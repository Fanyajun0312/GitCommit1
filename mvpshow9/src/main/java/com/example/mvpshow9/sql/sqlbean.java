package com.example.mvpshow9.sql;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @date：2020/7/14
 * @describe：
 * @author：FanYaJun
 */

@Entity
public class sqlbean {

    String title;

    @Generated(hash = 757083740)
    public sqlbean(String title) {
        this.title = title;
    }

    @Generated(hash = 1868023926)
    public sqlbean() {
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
