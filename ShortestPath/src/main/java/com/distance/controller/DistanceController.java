package com.distance.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.distance.ShortDistance;
import com.distance.model.Distance;
import com.distance.repository.DistanceRepository;
import com.mongodb.MongoException;

@RestController
@RequestMapping("/v1")
public class DistanceController {
	
	@Autowired
	DistanceRepository distanceRepository;
	
	ShortDistance shortDistance =new ShortDistance();
	@RequestMapping(value="/distance" ,method=RequestMethod.POST,produces = { "application/json" })
	public Distance  input(@RequestBody Distance distance) throws Exception {
 		distance.setOutput(shortDistance.calculate(distance.getNodes(),distance.getFilepath()));
		saveRequestDetails(distance);
		return distance;
		
	}
	
	public void saveRequestDetails(Distance distance) throws Exception{
		try{
		distanceRepository.save(distance);
		}catch(MongoException e){
			throw new Exception("Unable to save request details");
		}
		
	}
	
	@RequestMapping(value = "/get")
	public List<Distance> getRequestDetails() throws Exception {
		try{
			List<Distance> output =distanceRepository.findAll();
			return output;
			}
			catch(MongoException e){
				throw new Exception("Unable to get request details");
			}
	}

}
