package com.unity.authentication.manager.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.ho.yaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class YamlReader {
    private static YamlReader INSTANCE;

    private static Yaml yaml;

    private YamlReader() {
    }

    public static YamlReader getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new YamlReader();
            yaml = new Yaml();
        }
        return INSTANCE;
    }

    public Map<String, Map<String, Object>> getPropertiesInPath(String path){
        try{
            File file = new File(path);
            Map<String, Map<String, Object>> properties = (Map<String, Map<String, Object>>) yaml.load(new FileInputStream(file));
            return properties;
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return new HashMap<>();
    }

    public void setPropertiesInPath(String path,String property){
        try{
            File file = new File(path);
            yaml.dump(createYaml(property),file);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public Map<String,Object> createYaml(String jsonString){
        try {
            JsonNode jsonNodeTree = new ObjectMapper().readTree(jsonString);
            // save it as YAML
            String jsonAsYaml = new YAMLMapper().writeValueAsString(jsonNodeTree);

            Map<String, Object> map = (Map<String, Object>) yaml.load(jsonAsYaml);
            return map;
        } catch (Exception e){
            e.printStackTrace();
        }
        return new HashMap<>();
    }
}
