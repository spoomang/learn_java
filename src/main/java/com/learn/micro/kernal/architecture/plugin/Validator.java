package com.learn.micro.kernal.architecture.plugin;

import com.learn.micro.kernal.architecture.plugin.model.ValidatorInput;
import com.learn.micro.kernal.architecture.plugin.model.ValidatorOutput;

public interface Validator {
    ValidatorOutput execute (ValidatorInput input);
}
