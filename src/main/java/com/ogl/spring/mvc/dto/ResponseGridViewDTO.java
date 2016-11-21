package com.ogl.spring.mvc.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ResponseGridViewDTO<E extends Serializable> {

    private Integer page;
    private Integer total;
    private Integer records;
    private List<E> rows;
    private String mensajeError;

}
