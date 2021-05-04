package com.jb.todoServer.beans;

import com.fasterxml.jackson.annotation.*;

import java.util.Arrays;
import java.util.stream.Stream;


public enum PriorityTodo {

    URGENT(5),

    HIGH (4),

    MEDIUM (3),

    LOW   (2) ,

    DEFAULT(1);



//    SOME_MEMBER1(10),
//    SOME_MEMBER2(15);

    private int code;

    PriorityTodo(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    @JsonValue
    public int toValue() {
        return getCode();
    }

    public static PriorityTodo forCode(int code) {
        for (PriorityTodo element : values()) {
            if (element.code == code) {
                return element;
            }
        }
        return null; //or throw exception if you like...
    }

    @JsonCreator
    public static PriorityTodo forValue(String v) {
        return PriorityTodo.forCode(Integer.parseInt(v));
    }




//    INPUT("Input", "I"),
//    OUTPUT("Output", "O")
//    ;
//
//    private final String mode;
//    private final String code;
//
//    PriorityTodo(String mode, String code) {
//        this.mode = mode;
//        this.code = code;
//    }
//
//    public String getMode() {
//        return mode;
//    }
//
//    public String getCode() {
//        return code;
//    }
//
//    @JsonCreator
//    static PriorityTodo findValue(@JsonProperty("mode") String mode, @JsonProperty("code") String code) {
//        return Arrays.stream(PriorityTodo.values()).filter(pt -> pt.mode.equals(mode) && pt.code.equals(code)).findFirst().get();
//    }

//
//    @JsonCreator
//    public static PriorityTodo forValue(String name)
//    {
//        return EnumUtil.getEnumByNameIgnoreCase(PriorityTodo.class, name);
//    }

}
