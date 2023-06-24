package com.learn.micro.kernal.architecture.plugin.impl;

import com.learn.micro.kernal.architecture.plugin.Validator;
import com.learn.micro.kernal.architecture.plugin.model.ValidatorInput;
import com.learn.micro.kernal.architecture.plugin.model.ValidatorOutput;

public class ValidatorHeader implements Validator {

    @Override
    public ValidatorOutput execute(ValidatorInput input) {
        ValidatorOutput output = new ValidatorOutput();
        output.results = "Completed header check for "+input.module;
        return output;
    }
}
