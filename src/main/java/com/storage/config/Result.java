package com.storage.config;

public class Result {
    private Integer code;
    private String msg;
    private Object data;
    //    private Long count;
    public Result(Integer code, String msg, Object data){
        this.code=code;
        this.msg=msg;
        this.data=data;
    }
//    public Result(Integer code, String msg, Long count, Object data){
//        this.code=code;
//        this.msg=msg;
//        this.count=count;
//        this.data=data;
//    }

    public static Result success(Object data){
        return new Result(200,"success",data);
    }

//    public static Result suctotal(Long total,Object data){
//        return new Result(200,"success",total,data);
//    }

//    public static Result suclayer(Object data){
//        return new Result(0,"success",data);
//    }

    public static Result success(){
        return new Result(200,"success",null);
    }

    public static Result failed(Integer code,String msg){
        return new Result(code,msg,null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

//    public Long getCount() {
//        return count;
//    }
//
//    public void setCount(Long count) {
//        this.count = count;
//    }
}
