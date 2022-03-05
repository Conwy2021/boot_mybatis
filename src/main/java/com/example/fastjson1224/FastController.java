package com.example.fastjson1224;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @Author:LiuKangwei
 * @Date:2022/3/5 19:41
 * @Description:
 */
@RestController
public class FastController {

    @GetMapping (value = "/json",produces="application/json;charset=UTF-8")
    public JsonBean testJson() {

        JsonBean jsonBean = new JsonBean();
        jsonBean.setBirthDay(new Date());
        jsonBean.setName("测试");
        jsonBean.setQqList(null);

        // 效果
        /*{
            "code": "200",
                "data": {
            "birthDay": "2019年05月12日",
                    "name": "测试",
                    "qqList": []
        },
            "msg": ""
        }*/
        return jsonBean;
    }


    @Data
    class JsonBean {
        @JSONField(name="NAME")
        private String name;
        @JSONField(format = "yyyy年MM月dd日")
        private Date birthDay;
        private List<String> qqList;
    }
}
