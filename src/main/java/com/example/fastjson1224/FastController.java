package com.example.fastjson1224;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.Feature;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping(value = "/json2",produces="application/json;charset=UTF-8")
    public JSONObject json2(@RequestBody String body){
        // JSONObject obj = JSON.parseObject(data, Feature.SupportNonPublicField); // 当使用 TemplatesImpl的时候用这个
        JSONObject parse = JSON.parseObject(body, Feature.SupportNonPublicField);
        JSONObject result = new JSONObject();
        result.put("code", 200);
        result.put("message", "success");
        result.put("data", "Hello " + parse.get("name"));


        return result;
    }

    @PostMapping(value = "/json3",produces="application/json;charset=UTF-8")
    public JSONObject json3(@RequestBody String body){
        // JSONObject obj = JSON.parseObject(data, Feature.SupportNonPublicField); // 当使用 TemplatesImpl的时候用这个
        JSONObject parse = JSON.parseObject(body);
        JSONObject result = new JSONObject();
        result.put("code", 200);
        result.put("message", "success");
        result.put("data", "Hello " + parse.get("name"));


        return result;
    }
}

