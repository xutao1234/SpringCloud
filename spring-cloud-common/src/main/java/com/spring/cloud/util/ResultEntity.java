package com.spring.cloud.util;

/**
 * @Author: taotao
 * @Date: 2020/1/6 17:50
 * @Version 1.0
 * 整个项目统一使用这个类型作为Ajax请求或远程方法调用返回相应的数据格式
 * @param <T>
 */
public class ResultEntity<T> {
    public static final String SUCCESS = "SUCCESS";
    public static final String FAILED = "FAILED";
    public static final String NO_MESSAGE = "NO_MESSAGE";
    public static final String NO_DATA = "NO_DATA";

    /*
    * 操作成功，不需要返回数据
    */
    public static ResultEntity<String> successWithoutData(){
        return new ResultEntity<String>(SUCCESS,NO_MESSAGE,NO_DATA);
    }

    /*
    * 操作成功，需要返回数据
    * */
    public static <E> ResultEntity<E> successWithData(E data){
        return new ResultEntity<E>(SUCCESS,NO_MESSAGE,data);
    }

    /*
    * 操作失败，返回错误消息
    * */
    public static <E> ResultEntity<E> failed(String message){
        return new ResultEntity<E>(FAILED,message,null);
    }

    private String result;
    private String message;
    private T data;

    public ResultEntity() {
    }

    public ResultEntity(String result, String message, T data) {
        this.result = result;
        this.message = message;
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultEntity{" +
                "result='" + result + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
