package com.sinby.iadmin4J.pojo;

import com.baomidou.mybatisplus.extension.api.R;
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
public class ResultData {

    private String message; //信息
    private Integer code = 200;   //状态码
    private Object data; //返回数据

    public static ResultData ok() {
        ResultData resultData = new ResultData();

        resultData.setCode(200);
        resultData.setMessage("成功");

        return resultData;
    }
    public static ResultData error() {
        ResultData resultData = new ResultData();

        resultData.setCode(400);
        resultData.setMessage("失败");

        return resultData;
    }
    public static ResultData fail(Integer code, String msg) {
        ResultData resultData = new ResultData();

        resultData.setCode(code);
        resultData.setMessage(msg);

        return resultData;
    }
}
