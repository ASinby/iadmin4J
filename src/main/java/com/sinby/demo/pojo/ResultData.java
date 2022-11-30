package com.sinby.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：sinby
 * @Date :2022/03/24 14:06
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultData<T> {

    private Boolean success;    //是否成功
    private String msg; //信息
    private Integer code = 200;   //状态码
    private T data; //返回数据

    /**
     * 返回成功失败状态和返回实体类
     */
    public ResultData(Boolean success, T data){
        this.success = success;
        this.data = data;
    }

    /**
     * 返回成功失败状态
     */
    public ResultData(Boolean success){
        this.success = success;
    }


    /**
     * 返回成功失败状态和异常码、异常消息
     */
    public ResultData(Boolean success,Integer code,String msg){
        this.success = success;
        this.code = code;
        this.msg = msg;
    }

    /**
     * 返回成功失败状态和异常码、异常消息
     */
    public ResultData(Boolean success,Integer code,String msg,T data){
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
