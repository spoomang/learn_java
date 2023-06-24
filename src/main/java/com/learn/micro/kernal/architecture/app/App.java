package com.learn.micro.kernal.architecture.app;

import com.learn.micro.kernal.architecture.plugin.Validator;
import com.learn.micro.kernal.architecture.plugin.model.ValidatorInput;
import com.learn.micro.kernal.architecture.plugin.model.ValidatorOutput;

import java.util.HashMap;
import java.util.Map;

public class App {
    static Map<String, String> registry = new HashMap<>();

    static {
        registry.put("header", "ValidatorHeader");
        registry.put("contents", "ValidatorContents");
        registry.put("spellChecks", "ValidatorSpellCheck");
    }

    public static void main(String[] args) {

        ValidatorInput input = new ValidatorInput();
        input.module = "bupp";

        for (Map.Entry<String, String> e : registry.entrySet()) {
            String name =  e.getValue();

            System.out.println("Class name : "+name);

            try {
                Class c = Class.forName("com.learn.micro.kernal.architecture.plugin.impl."+name);

                Validator v = (Validator) c.newInstance();

                ValidatorOutput output = v.execute(input);

                System.out.println(output.results);

            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }
}
