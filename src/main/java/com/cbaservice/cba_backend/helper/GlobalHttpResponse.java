package com.cbaservice.cba_backend.helper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GlobalHttpResponse<T> {
    private int status;
    private String msg;
    private T data;
}
