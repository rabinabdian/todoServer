package com.jb.todoServer.beans;

import com.fasterxml.jackson.annotation.*;

import java.util.Arrays;
import java.util.stream.Stream;


public enum PriorityTodo {
    URGENT,
    HIGH,
    MEDIUM,
    LOW  ,
    DEFAULT;
}
