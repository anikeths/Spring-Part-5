package com.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	@RequestMapping("/addProduct")
	public ModelAndView addProduct(@RequestParam("pid") int pid, @RequestParam("pname") String pname, @RequestParam("price") int price)
	{
		Product prod = new Product();
		prod.setPid(pid);
		prod.setPname(pname);
		prod.setPrice(price);
		productService.addProduct(prod);//invoke Model/Service/Action
		return new ModelAndView("successProduct.jsp");//invoke View
	}
}
