package com.example.salesdemo.Commons.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatusDto2 {
    private StatusEnum code;
    private String message;
    private Object data;
    private Object data1;
    public String getCode() {
        return code.value() + "";
    }
}
