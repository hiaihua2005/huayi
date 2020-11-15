package com.huayi.web.controller.mock;

import com.alibaba.fastjson.JSONObject;
import com.huayi.common.base.AjaxResult;
import com.huayi.common.utils.spring.SpringUtils;
import com.huayi.framework.util.SpringContextUtil;
import com.huayi.framework.web.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * 模拟json文件请求
 */
@RestController
public class MockJsonController extends BaseController {

  private static Logger log = LoggerFactory.getLogger(MockJsonController.class);

  /**
   * 模拟json文件的post请求.
   * @param fileName
   * @param model
   * @return
   * @throws IOException
   */
  @RequestMapping(value="/biz/mock/{fileName}.json",method = {RequestMethod.POST, RequestMethod.GET})
  public Object getJsonFile(HttpServletRequest request, HttpServletResponse response,
          @PathVariable("fileName")String fileName,
                            Map<String, Object> model) throws IOException {
    InputStream is = SpringContextUtil.getApplicationContext().getResource("classpath:/mock/json/"+fileName+".json").getInputStream();
    try {
      response.setHeader("X-Total-Count","10");
      String fileContent = InputStreamTOString(is,"utf-8");
      Object result = JSONObject.parse(fileContent);

      return result;
//      return success("操作成功",result);
//      return fileContent;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 将InputStream转换成某种字符编码的String
   * @param in
   * @param encoding
   * @return
   * @throws Exception
   */
  public static String InputStreamTOString(InputStream in, String encoding) throws Exception{

    ByteArrayOutputStream outStream = new ByteArrayOutputStream();
    byte[] data = new byte[4096];
    int count = -1;
    while((count = in.read(data,0,4096)) != -1) {
      outStream.write(data, 0, count);
    }
    data = null;
    return new String(outStream.toByteArray(),"UTF-8");
  }

  /**
   * 模拟json文件的post请求.
   * @param fileName
   * @return
   * @throws IOException
   */
  @RequestMapping(value="/uploads/{fileName}",method = {RequestMethod.POST, RequestMethod.GET})
  public String filesss(
          @PathVariable("fileName")String fileName
          ) throws IOException {
    ClassPathResource cr = new ClassPathResource("uploads/"+fileName);
    try {
      String fileContent = InputStreamTOString(cr.getInputStream(),"utf-8");
      return fileContent;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }


}
