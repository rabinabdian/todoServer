package com.jb.todoServer.beans;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestBody;

@Data
public class PayloadTodo {



    boolean updateCompleted;

    String updateDescription;


}
