package edu.lesson.ex.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.lesson.ex.vo.SampleVO;
import lombok.extern.log4j.Log4j;

//아래 @RestController를 사용하면 기존(.jsp)과는 다른 문법사항이 적용됨.
//Rest가 붙으면 Controller의 문법과 달리하라는말
@RestController
@RequestMapping("/sample")
@Log4j
public class SampleController {
	@GetMapping(value = "/getText", produces = "text/plain; charset = utf-8")
	public String getText() {
		log.info("MIME TYPE : " + MediaType.TEXT_PLAIN_VALUE);
		
		return "안녕하세요~ json입니다. 처음뵙겠습니다.";
	}
	
	
	@GetMapping(value = "/check", params = {"height", "weight"}) 
	public ResponseEntity<SampleVO> check(Double height, Double weight) {
		 SampleVO vo = new SampleVO(0, "" + height, "" + weight);

	     ResponseEntity<SampleVO> result = null;

	     if (height < 150) {
	        result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
	     } else {
	        result = ResponseEntity.status(HttpStatus.OK).body(vo);
	     }

	     return result;
	  
	}
	
	@GetMapping(value = "/getSample")
	public SampleVO getSample() {
		return new SampleVO(113, "로켓", "라쿤");
	}

}
