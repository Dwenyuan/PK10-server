package com.pk10.control;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

/**
* RateAndLimitController Tester. 
* 
* @author <Authors name> 
* @since <pre>九月 3, 2016</pre> 
* @version 1.0 
*/



public class RateAndLimitControllerTest extends JUnitActionBase{


    @Test
    public  void testgetAllRateAndLimit() throws Exception{
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        request.setServletPath("getAllRateAndLimit");
        request.setMethod("post");
        request.setAttribute("msg", "测试action成功");
        final ModelAndView mav = this.excuteAction(request, response);

    }
} 
