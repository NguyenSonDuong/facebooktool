package com.kit502.facebook.controller.view;


import com.kit502.facebook.IViewController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/facebook")
public class FacebookController implements IViewController {
    @Override
    public ModelAndView View(@PathVariable String id, Model model) {
        ModelAndView modelAndView = new ModelAndView("facebookpage/list");
        modelAndView.addObject("name","DUONG");
        modelAndView.addObject("id",id);

        return modelAndView;
    }
}
