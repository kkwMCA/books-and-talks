package com.bnt.books.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
class WebConfig implements WebMvcConfigurer{

   @Override
   public void addCorsMappings(CorsRegistry registry) {
      registry.addMapping("/**")
         .allowedOrigins("http://localhost:3000","http://localhost:3001")  // Replace with the actual URL of your React app
         .allowedMethods("GET", "POST", "PUT", "DELETE")
         .allowedHeaders("*");
   }
}