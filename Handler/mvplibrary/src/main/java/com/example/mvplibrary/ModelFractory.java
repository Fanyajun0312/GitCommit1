package com.example.mvplibrary;

import java.util.HashMap;
import java.util.Map;

/**
 * @date：2020/8/9
 * @describe：model层的工厂类
 * @author：FanYaJun
 */
public class ModelFractory {
    //存储全局的model层
    private static Map<String, Object> modelMap=new HashMap<>();

    /**
     * 获取model层 查询全局是否有model实例 不存在创建新的实例
     * @param cls class类
     * @param <T>//T model
     * @return
     */
    public static <T extends BaseModel> T getModel(Class<T> cls){
        String mapname = cls.getName();//key
        T model = (T) modelMap.get(mapname);
        if(model==null){
            //model
          model=  getModelReflex(mapname);
            //反射获取Model
            modelMap.put(mapname,model);

        }
        return model;
    }

    /**
     *
     * @param mapname
     * @param <T>
     * @return
     */
    private static <T extends BaseModel> T getModelReflex(String mapname) {
        T requset=null;
        try {
            requset= (T) Class.forName(mapname).newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return requset;
    }
}
