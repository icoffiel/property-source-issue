package com.example.demo.config;

import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@Configuration
@PropertySources({
        @PropertySource(value = "file:/c:\\demo\\test.properties")
})
public class TestConfig {
    private Environment env;

    public TestConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public String one() {
        System.out.println("Should be visible");
        return "One";
    }

    @Bean
    @Profile("!local") // Should not be picked up due to 'local' profile
    public String two() {
        System.out.println("Should not be visible");
        System.out.println(Arrays.toString(env.getActiveProfiles()));
        return "Two";
    }
}
