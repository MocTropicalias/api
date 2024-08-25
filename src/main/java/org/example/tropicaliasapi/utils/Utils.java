package org.example.tropicaliasapi.utils;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

public class Utils {

    public static Map<String, String> getErros(BindingResult result) {
        Map<String, String> erros = new HashMap<>();
        if (result.hasErrors()) {
            for (FieldError erro : result.getFieldErrors()) {
                erros.put(erro.getField(), erro.getDefaultMessage());
            }
        }
        return erros;
    }

}
