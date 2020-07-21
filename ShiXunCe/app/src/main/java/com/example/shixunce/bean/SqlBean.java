package com.example.shixunce.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @date：2020/7/17
 * @describe：
 * @author：FanYaJun
 */
@Entity
public class SqlBean {

    @Id
    private Long id;
    private String tit;
    @Generated(hash = 1886814438)
    public SqlBean(Long id, String tit) {
        this.id = id;
        this.tit = tit;
    }
    @Generated(hash = 2066760633)
    public SqlBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTit() {
        return this.tit;
    }
    public void setTit(String tit) {
        this.tit = tit;
    }
   

}
