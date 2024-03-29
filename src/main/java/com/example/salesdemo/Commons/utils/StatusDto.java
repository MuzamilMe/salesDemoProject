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
public class StatusDto {
    private StatusEnum code;
    private String message;
    private Object data;
    public String getCode() {
        return code.value() + "";
    }
}
