package com.dicamo.sobar.controller;

import com.dicamo.sobar.dto.SobarVO;
import com.dicamo.sobar.service.SobarService;
import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class SobarRestController {

    @Autowired
    SobarService service;

//     Json통신을 위한 RestController
//     해당 주소로 Post 처리를 받았을 때 컨트롤러
//     RequestParam으로 넘어온 데이터들을 해당 변수에 매핑
    @PostMapping("post/json")
    public String postSobarJson(@RequestBody SobarVO vo){
        try{
            String str = service.sobarInsertByUuid(vo.getUuid(), vo.getProductCode());

            return str + "";
        } catch (Exception e){
            return "unknown error";
        }
    }
    @PostMapping("post")
//     ModelAttribute로 SobarVO 객체에 바인딩시켜 ResponseBody로 값 반환
    public String postSobar(@ModelAttribute SobarVO vo) {
        try{
            String str = service.sobarInsertByUuid(vo.getUuid(), vo.getProductCode());
            return str + "";

        } catch (Exception e) {
            e.printStackTrace();
            return "unknown error";
        }


    }



    // http 통신이 가능하게 서블릿팩토리에 커넥션을 추가하여 Bean으로 생성
    @Bean
    public ServletWebServerFactory serverFactory() {
        TomcatServletWebServerFactory tomcatServletWebServerFactory
                = new TomcatServletWebServerFactory();
        tomcatServletWebServerFactory.addAdditionalTomcatConnectors(createStandardConnector());

        return tomcatServletWebServerFactory;
    }

    private Connector createStandardConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setPort(8080);

        return connector;
    }
}
