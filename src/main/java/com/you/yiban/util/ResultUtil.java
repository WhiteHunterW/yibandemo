package com.you.yiban.util;

import com.you.yiban.vo.ResultVo;

/**
 * @author w.z
 * @date 2019/8/12 14:57
 */
public class ResultUtil {
    
    public static ResultVo success(Object object){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(1);
        resultVo.setMsg("请求成功");
        resultVo.setData(object);
        return resultVo;
    }
    
    public static ResultVo success(){
        return success(null);
    }
    
    public static ResultVo success(String data){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(1);
        resultVo.setMsg("请求成功");
        resultVo.setData(data);
        return resultVo;
    }
    public static ResultVo success(int data){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(1);
        resultVo.setMsg("请求成功");
        resultVo.setData(data);
        return resultVo;
    }
    
    public static ResultVo error(String msg){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(0);
       resultVo.setMsg(msg);
        return resultVo;
    }
    
    public static ResultVo error(){
        return error(null);
    }
    
    
}
