package com.vvs.webfluxcityapp.router;

import com.vvs.webfluxcityapp.handler.CityHandler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class CityRouter {
  
  @Bean
  public RouterFunction<ServerResponse> routeCity(CityHandler cityHandler) {
    return RouterFunctions
      .route(GET("/hello").and(accept(MediaType.TEXT_PLAIN)), cityHandler::helloCity);
  }
}
