package com.whale.rule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

public class RuleRunner {
    private  RuleEngine engine;

    public RuleRunner(IRule rule){
        engine=buildRuleEngine(rule.loadRules(),rule.loadAdmissions());
    }

    private static RuleEngine buildRuleEngine(Map<String, Object> rules, Map<String, Object> admissions) {
        Map map = new HashMap();
        RuleEngine engine=new RuleEngine();

        map.putAll(rules);
        map.put("admission",admissions);
        engine.rules(map);
        return engine;
    }

    public Object run(Object predicates,Object subjects,Object... objects){
      //  def bob = new Person ( [ name:'Bob Barker', age:83 ] )
        Object price = engine.evaluate("admission",predicates,subjects, objects );
        return price;
    }
}
