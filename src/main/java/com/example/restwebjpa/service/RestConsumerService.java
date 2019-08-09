package com.example.restwebjpa.service;

import com.example.restwebjpa.domain.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Component
public class RestConsumerService {

    private static final Logger log = LoggerFactory.getLogger(RestConsumerService.class);

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    public List<Point> getpointListFromRestApi(RestTemplate restTemplate) throws Exception {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>("[ \"global_id\", \"Cells\", \"CommonName\", \"ObjectAddress\"]" ,headers);
        ResponseEntity<List<Kino>>  response =
                restTemplate.exchange("https://apidata.mos.ru/v1/datasets/495/rows/?api_key=b8a9f22f2b87479d089290099b366cbf",
                        HttpMethod.POST, entity, new ParameterizedTypeReference<List<Kino>>(){}
                        );

        List<Kino> kinos = response.getBody();
        log.info(kinos.toString());

        List<Point> pointList = new ArrayList<>();

        kinos.forEach(kino -> {
            Point point = new Point(kino.getCells().getObjectAddressList().get(0).getAddress(), kino.getCells().getCommonName());
            pointList.add(point);
        });

        return pointList;
    }
}
