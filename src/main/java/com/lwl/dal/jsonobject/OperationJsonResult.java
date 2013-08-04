package com.lwl.dal.jsonobject;


public  class  OperationJsonResult<T>{
    /**
     * 操作结果返回码
     * 默认为其他错误
     */
    private int resultCode;
    private String message;
    private T data;

    @SuppressWarnings("rawtypes")
    public static OperationJsonResult createSuccess() {
        OperationJsonResult operationJsonResult =  new OperationJsonResult();
        operationJsonResult.setResultCode(OperationResultCode.SUCESS.getCode());
        return operationJsonResult;
    }

    @SuppressWarnings("rawtypes")
    public static OperationJsonResult createError() {
        OperationJsonResult operationJsonResult =  new OperationJsonResult();
        operationJsonResult.setResultCode(OperationResultCode.OTHER_ERROR.getCode());
        return operationJsonResult;
    }

    public int getResultCode() {
        return resultCode;
    }
    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
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
