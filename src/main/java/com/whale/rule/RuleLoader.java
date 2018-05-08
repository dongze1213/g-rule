package com.whale.rule;

import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceException;
import groovy.util.ScriptException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import sun.security.jca.GetInstance;

import java.io.IOException;

public class RuleLoader {
    private GroovyScriptEngine engine;



    public RuleLoader(String resourceRoot) {
        try {
            engine = new GroovyScriptEngine(resourceRoot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public IRule load(String ruleName) {
        Class ruleClass = null;
        try {
            ruleClass = engine.loadScriptByName(ruleName + ".groovy");
        } catch (ResourceException e) {
            e.printStackTrace();
        } catch (ScriptException e) {
            e.printStackTrace();
        }

        IRule rule = null;

        try {
            rule = (IRule) ruleClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return rule;
    }
}
