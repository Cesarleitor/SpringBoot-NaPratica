package br.com.cesar.exception;

import java.util.Date;

// TRATAMENTO DE EXCEÇÕES
public record ExceptionResponse(Date timestamp, String message, String details){}
