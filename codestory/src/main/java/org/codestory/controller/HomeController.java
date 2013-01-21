package org.codestory.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    final static String MY_EMAIL = "newouf@gmail.com";

    final static String FIRST_QUESTION = "Quelle est ton adresse email";

	@RequestMapping(value="/")
	public @ResponseBody String entryPoint(String q, HttpServletResponse response) throws IOException{

        if (FIRST_QUESTION.equals(q)) {
            return MY_EMAIL;
        }

        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "No response for that question");
		return null;
	}
}
