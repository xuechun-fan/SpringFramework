package com.fxc.Validator;

import com.fxc.entities.Account;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Description：
 */
public class AccountValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Account.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", null, "姓名不能为空");
        ValidationUtils.rejectIfEmpty(errors, "password", null, "密码不能为空");
    }
}
