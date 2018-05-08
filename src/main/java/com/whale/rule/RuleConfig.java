package com.whale.rule;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RuleConfig {
    @Bean
    public RuleLoader getRuleLoader(@Value("${rule.resource.root}") String resourceRoot) {
        return new RuleLoader(resourceRoot);
    }
}
