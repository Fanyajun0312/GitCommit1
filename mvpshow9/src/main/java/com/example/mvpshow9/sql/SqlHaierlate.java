package com.example.mvpshow9.sql;

import com.example.mvpshow9.BaseApp;
import com.example.mvpshow9.dao.DaoMaster;
import com.example.mvpshow9.dao.sqlbeanDao;

import java.util.List;

/**
 * @date：2020/7/14
 * @describe：
 * @author：FanYaJun
 */
public class SqlHaierlate {
    public static SqlHaierlate insance;
    private sqlbeanDao sqlbeanDao;

    public static SqlHaierlate getInsance() {
       if(insance==null){
            synchronized (SqlHaierlate.class){
                if(insance==null){
                    insance=new SqlHaierlate();

                }
            }
       }
       return insance;
    }
    public SqlHaierlate() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(BaseApp.getApp(), "des.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        sqlbeanDao = daoMaster.newSession().getSqlbeanDao();
    }
    public boolean isHisad(sqlbean sqlbean){
        List<com.example.mvpshow9.sql.sqlbean> list = sqlbeanDao.queryBuilder().where(com.example.mvpshow9.dao.sqlbeanDao.Properties.Title.eq(sqlbean.getTitle())).list();
        if(list!=null&&list.size()>0){
            return true;
        }else {
            return false;
        }
    }
}
