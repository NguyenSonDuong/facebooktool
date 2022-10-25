package com.kit502.facebook;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public interface IViewController {
    @RequestMapping(value = "/view/{id}",method = RequestMethod.GET)
    public ModelAndView View(@PathVariable String id, Model model);

}
