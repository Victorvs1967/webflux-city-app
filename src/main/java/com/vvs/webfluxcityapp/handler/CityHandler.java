package com.vvs.webfluxcityapp.handler;

import java.util.Optional;

import com.vvs.webfluxcityapp.error.GlobalException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class CityHandler {
  
  public Mono<ServerResponse> helloCity(ServerRequest request) {
    return ServerResponse
      .ok()
      .body(sayHelloCity(request), String.class);
  }

  private Mono<String> sayHelloCity(ServerRequest request) {

    Optional<String> sityParamOptional = request.queryParam("city");
    if (!sityParamOptional.isPresent()) {
      throw new GlobalException(HttpStatus.BAD_REQUEST, "request param city is ERROR");
    }

    return Mono.just("Hello, " + sityParamOptional.get());
  }
}
