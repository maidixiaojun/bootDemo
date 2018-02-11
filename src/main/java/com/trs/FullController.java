package com.trs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

/**
 * Title:
 * Description:
 * Copyright: 2018 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: full
 * Author: Joy
 * Create Time:2018/2/11 14:32
 */
@RestController
@RequestMapping("full")
public class FullController {

    @GetMapping("/")
    public String home() {
        return "Hello World!";
    }

    @GetMapping("getIndex")
    public String getIndex() {
        return "Hello this's index";
    }

    @GetMapping("indexHtml")
    public ModelAndView indexHtml() throws IOException {
        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        view.addObject("time", new Date());
        view.addObject("message", "Hello Beetl!");
        return view;
    }

    @GetMapping("testBash")
    public String testBash() {
        try {
            String[] cmd = new String[]{"/bin/sh", "-c", "ls -l"};
            Process ps = Runtime.getRuntime().exec(cmd);

            BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            String result = sb.toString();

            return result;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return "";


    }
}
