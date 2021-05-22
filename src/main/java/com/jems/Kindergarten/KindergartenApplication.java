package com.jems.Kindergarten;

import com.jems.Kindergarten.model.Kid;
import com.jems.Kindergarten.model.KidDetail;
import com.jems.Kindergarten.services.KidService;
import com.jems.Kindergarten.util.JpaConverterJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.UUID;

@SpringBootApplication
public class KindergartenApplication {

    @Autowired
    private KidService kidService;
    @Autowired
    private JpaConverterJson jpaConverterJson;

    public static void main(String[] args) {
        SpringApplication.run(KindergartenApplication.class, args);
    }

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
                "Accept", "Authorization", "Origin, Accept", "X-Requested-With",
                "Access-Control-Request-Method", "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
                "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            Kid kid = new Kid();
            kid.setCode(UUID.randomUUID().toString());
            kid.setDetail(new KidDetail() {{
                setAction("Access-Control-Allow-Origin ");
                setImageUrl("http://statistics.statistics");
                setPhone("02155485587");
            }});
            kid.setName("Amal Ahmed");
            kidService.addKid(kid);
        };
    }

    class aeer implements Serializable {
        String name;
        String asda;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAsda() {
            return asda;
        }

        public void setAsda(String asda) {
            this.asda = asda;
        }
    }
}
