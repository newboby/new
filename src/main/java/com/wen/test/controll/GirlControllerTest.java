package com.wen.test.controll;

import com.wen.controller.GirlController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2018/7/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:springmvc-config.xml"})

//单元测试的时候真实的开启一个web服务
@WebAppConfiguration
//配置事务的回滚,对数据库的增删改都会回滚,便于测试用例的循环利用
@Transactional
public class GirlControllerTest {
    @Autowired
    GirlController controll;
    private MockMvc mockMvc;
    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(controll).build();
    }
    /**
     * perform：执行一个RequestBuilder请求，会自动执行SpringMVC的流程并映射到相应的控制器执行处理；
     * get:声明发送一个get请求的方法。MockHttpServletRequestBuilder get(String urlTemplate, Object... urlVariables)：根据uri模板		和uri变量值得到一个GET请求方式的。另外提供了其他的请求的方法，如：post、put、delete等。
     * param：添加request的参数，如上面发送请求的时候带上了了pcode = root的参数。假如使用需要发送json数据格式的时将不能使用这种		方式，可见后面被@ResponseBody注解参数的解决方法
     * andExpect：添加ResultMatcher验证规则，验证控制器执行完成后结果是否正确（对返回的数据进行的判断）；
     * andDo：添加ResultHandler结果处理器，比如调试时打印结果到控制台（对返回的数据进行的判断）；
     * andReturn：最后返回相应的MvcResult；然后进行自定义验证/进行下一步的异步处理（对返回的数据进行的判断）
     * @throws Exception
     */


    @Test
    public void setControll() throws Exception {
//        String responseString = mockMvc.perform(get("/banner/hello")    //请求的url,请求的方法是get
//                .contentType(MediaType.APPLICATION_JSON)  //数据的格式
//                .param("id","123456789")         //添加参数
//        ).andExpect(status().isOk())    //返回的状态是200
//                .andDo(print())         //打印出请求和相应的内容
//                .andReturn().getResponse().getContentAsString();   //将相应的数据转换为字符串
        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/user/1")
//                .contentType(MediaType.APPLICATION_JSON)  //数据的格式
                .param("id","1")
        );
        MvcResult mvcResult = resultActions.andReturn();
        ModelAndView modelAndView = mvcResult.getModelAndView();
        String m = mvcResult.getResponse().getContentAsString();

        System.out.println(modelAndView);
    }
}
