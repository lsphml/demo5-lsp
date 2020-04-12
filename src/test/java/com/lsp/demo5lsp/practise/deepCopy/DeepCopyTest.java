package com.lsp.demo5lsp.practise.deepCopy;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lsp.demo5lsp.base.BaseUnit;
import org.apache.commons.lang.SerializationUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author lsp
 * @description java深层拷贝的几种实现方式
 * @date 2020/3/25 14:18
 **/

public class DeepCopyTest extends BaseUnit {

    /**
     * @Description 通过new创建实现deepCopy
      * @param
     * @Return void
     * @Author lsp
     * @Date 2020/3/25 14:27
     */
    @Test
    public void ConstructorCopy(){
        Name name = new Name("liu","ming");
        Coder oldCoder = new Coder(name,"man","12345");
        Coder newCoder = new Coder(new Name(name.getFirstName(),name.getLastName()),oldCoder.getGender(),oldCoder.getPhone());
        oldCoder.setPhone("6789");
        Assert.assertNotSame(oldCoder.getPhone(),newCoder.getPhone());
    }


    /**
     * @Description 序列化实现deepCopy
      * @param
     * @Return void
     * @Author lsp
     * @Date 2020/3/25 14:43
     */
    @Test
    public void serializableCopy(){
        Name name = new Name("liu","ming");
        Coder oldCoder = new Coder(name,"man","12345");
        // 使用SerializationUtils的clone方法(底层就是使用字节流和对象流)
        Coder newCoder = (Coder)SerializationUtils.clone(oldCoder);
        oldCoder.setPhone("6789");
        Assert.assertNotSame(oldCoder.getPhone(),newCoder.getPhone());
    }


    /**
     * @Description 利用json转化方法实现deepCopy
      * @param
     * @Return void
     * @Author lsp
     * @Date 2020/3/25 15:00
     */
    @Test
    public void jsonCopy() throws JsonProcessingException {
        Name name = new Name("liu","ming");
        Coder oldCoder = new Coder(name,"man","12345");
        // 通过fastJson实现json化转化
        String json = JSON.toJSONString(oldCoder);
        Coder newCoder = JSON.parseObject(json,Coder.class);
        //通过jackson实现json化转化
        ObjectMapper objectMapper = new ObjectMapper();
        Coder new2Coder = objectMapper.readValue(objectMapper.writeValueAsString(oldCoder),Coder.class);
    }


}
