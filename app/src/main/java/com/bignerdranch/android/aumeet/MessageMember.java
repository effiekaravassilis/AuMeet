package com.bignerdranch.android.aumeet;

public class MessageMember {
    String message,time,date,type,senderuid,recieveruid;


    public MessageMember(){

    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSenderuid() {
        return senderuid;
    }

    public void setSenderuid(String senderuid) {
        this.senderuid = senderuid;
    }

    public String getRecieveruid() {
        return recieveruid;
    }

    public void setRecieveruid(String recieveruid) {
        this.recieveruid = recieveruid;
    }


}
