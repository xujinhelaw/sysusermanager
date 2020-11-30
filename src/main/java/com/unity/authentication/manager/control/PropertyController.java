package com.unity.authentication.manager.control;

import com.unity.authentication.manager.pojo.PropertyReq;
import com.unity.authentication.manager.utils.YamlReader;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class PropertyController {

    //{"path":"E:\\IdeaProjects\\sysusermanager\\src\\main\\resources\\application.yml"}
    @RequestMapping(method = RequestMethod.POST,value = "/getProperties")
    @ResponseBody
    public Map<String, Map<String,Object>> getProperties(@RequestBody PropertyReq propertyReq){
        return YamlReader.getInstance().getPropertiesInPath(propertyReq.getPath());
    }
}
