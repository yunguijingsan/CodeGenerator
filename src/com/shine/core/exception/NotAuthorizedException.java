package com.shine.core.exception;

public class NotAuthorizedException extends EihServiceException{
    @SuppressWarnings("compatibility:3638299897685922061")
    private static final long serialVersionUID = 4065879046927993115L;
    public static NotAuthorizedException create(){
      return  new NotAuthorizedException();
    }
}
