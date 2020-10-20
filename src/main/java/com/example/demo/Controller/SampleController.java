package com.example.demo.Controller;
import com.example.demo.result.CodeMessage;
import com.example.demo.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wanglei
 * @date 2020/10/19 4:23 下午
 * @File : SampleController.java
 */
@Controller
public class SampleController {
    @RequestMapping("test")
    public String sample(Model model){
        String name="wanglei";
        model.addAttribute("name",name);
        return "hello";
    }
    @RequestMapping("test1")
    @ResponseBody
    public Result<String> sample(){
        return Result.error(CodeMessage.SERVER_ERROR);
    }
}
