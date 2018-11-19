package com.distance.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.distance.ShortDistance;
import com.distance.model.Distance;

@RestController
@RequestMapping("/v1")
public class DistanceController {
	
	ShortDistance shortDistance =new ShortDistance();
	@RequestMapping(value="/distance" ,method=RequestMethod.POST,produces = { "application/json" })
	public Distance  input(@RequestBody Distance distance) throws IOException {
		distance.setOutput(shortDistance.calculate(distance.getNodes(),distance.getFilepath()));
		return distance;
		
	}

}
