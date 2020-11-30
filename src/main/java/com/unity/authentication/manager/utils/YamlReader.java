package com.unity.authentication.manager.utils;

import org.ho.yaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
}
