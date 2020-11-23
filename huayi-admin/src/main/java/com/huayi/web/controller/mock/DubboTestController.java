//package com.huayi.web.controller.mock;
//
//import com.alibaba.fastjson.JSONObject;
//import com.huayi.framework.util.SpringContextUtil;
//import com.huayi.framework.web.base.BaseController;
//import com.huayi.service.ICardService;
//import com.huayi.service.ITestMe;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.dubbo.config.annotation.Reference;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.HashMap;
//import java.util.Map;
//
//@Controller
//@RequestMapping("/biz/user")
//@Slf4j
//public class DubboTestController extends BaseController {
//
//
//  @Reference
//  ICardService cardService;
//  @Reference
//  ITestMe testMe;
//
//  /**
//   * Dubbo请求.
//   * @return
//   * @throws IOException
//   */
//  @RequestMapping(value="/dubbo",method = {RequestMethod.POST, RequestMethod.GET})
//  public Object getJsonFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
//    String result = cardService.sayHello("22222");
//    log.debug("cardservice:"+result);
//    String testMeResult = testMe.testMe();
//    log.debug("testMe:"+testMeResult);
//    Map resultData = new HashMap();
//    resultData.put("cardResult",result);
//    resultData.put("testResult",testMeResult);
//    return success(resultData);
//  }
//
//}
