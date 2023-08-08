package com.example.TicketOnline.exceptions;

public class ExceptionTicket extends  Exception {
    private String errorCode;


     public ExceptionTicket(String message, Throwable th){
        super(message,th);

    }
    public ExceptionTicket(String message, String errorCode ){
        super(message );
        this.errorCode = errorCode;

    }

    public ExceptionTicket(String message, Throwable th, String errorCode) {
        super(message, th);
        this.errorCode = errorCode;
    }
    public String getErrorCode() {
        return errorCode;
    }
}
