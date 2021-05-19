package com.example.demo.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class ExceptionResponse {
   private Date timestamp;
   private String message;
   private String details;
}

