package com.xylon.book.util;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;

@Slf4j
public class JsonUtil {

    public String ClassIntoJson(Object object){
        JsonMapper jsonMapper = new JsonMapper();

        String json = null;

        try {
            json = jsonMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("Turn object " + object.toString() + " into json failure.");
        }

        return json;
    }

//    public String ListIntoJson(List list){
//       JsonMapper jsonMapper = new JsonMapper();
//
//       return jsonMapper.toString();
//    }

}
