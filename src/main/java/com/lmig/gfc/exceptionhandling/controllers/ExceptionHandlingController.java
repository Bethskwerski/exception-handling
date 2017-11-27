package com.lmig.gfc.exceptionhandling.controllers;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ExceptionHandlingController {

	@GetMapping("/")
	public String showForm() {
		return "exceptionHandling/default";
	}

	@PostMapping("/handleString")
	public ModelAndView handleString(String probablySomeText) {
		ModelAndView mv = new ModelAndView("exceptionHandling/default");
		try {
			mv.addObject("stringResult", probablySomeText.substring(4));
		} catch (StringIndexOutOfBoundsException sioobe) {
			String errorMessage = "string should be four characters";
			mv.addObject("stringResult", errorMessage);
		}
		return mv;
	}

	@PostMapping("/handleUrl")
	public ModelAndView handleUrl(String probablyAUrl) throws MalformedURLException {
		ModelAndView mv = new ModelAndView("exceptionHandling/default");
		try {
			mv.addObject("urlResult", new URL(probablyAUrl));
		} catch (MalformedURLException mue) {
			String errorMessage = "not a valid URL";
			mv.addObject("urlResult", errorMessage);
		}
		return mv;
	}

	@PostMapping("/handleInteger")
	public ModelAndView handleInteger(String probablyAnInteger) {
		ModelAndView mv = new ModelAndView("exceptionHandling/default");
		try {
			mv.addObject("integerResult", Integer.parseInt(probablyAnInteger));
		} catch (NumberFormatException nfe) {
			String errorMessage = "not an integer";
			mv.addObject("integerResult", errorMessage);
		}
		return mv;
	}

	@PostMapping("/handleDecimal")
	public ModelAndView handleDecimal(String probablyADecimal) {
		ModelAndView mv = new ModelAndView("exceptionHandling/default");
		try {
			mv.addObject("decimalResult", Double.parseDouble(probablyADecimal));
		} catch (NumberFormatException nfe) {
			String errorMessage = "not a decimal";
			mv.addObject("decimalResult", errorMessage);
		}
		return mv;
	}

	@PostMapping("/handleDate")
	public ModelAndView handleDate(String probablyADate) {
		ModelAndView mv = new ModelAndView("exceptionHandling/default");
		try {
			mv.addObject("dateResult", LocalDate.parse(probablyADate));
		} catch (DateTimeParseException ctpe) {
			String errorMessage = "not a date";
			mv.addObject("dateResult", errorMessage);
		}
		return mv;
	}

}