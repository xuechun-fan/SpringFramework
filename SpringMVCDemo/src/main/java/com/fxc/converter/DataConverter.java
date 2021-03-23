package com.fxc.converter;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description：
 */
public class DataConverter implements Converter<String, Date> {
    private String pattern;

    public DataConverter(String pattern) {
        this.pattern = pattern;
    }
    @Override
    public Date convert(String s) {
        SimpleDateFormat sdf = new SimpleDateFormat(this.pattern);
        Date date = null;
        try{
            date = sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
