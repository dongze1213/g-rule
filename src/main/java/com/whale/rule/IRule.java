package com.whale.rule;

import java.util.Map;

public interface IRule {
     Map<String,Object> loadRules();

     Map<String,Object> loadAdmissions();
}
