package com.example.demo;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.ResponseBody;


@Controller

public class DemoController { @ResponseBody @RequestMapping("/display")
public String display() {

return "Hi … This is the deployment on cloud";

}

}
