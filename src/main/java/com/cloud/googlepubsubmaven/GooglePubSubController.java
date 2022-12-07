package com.cloud.googlepubsubmaven;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cloud.googlepubsubmaven.GooglepubsubmavenApplication.PubsubOutboundGateway;

@RestController
public class GooglePubSubController {

	@Autowired
	PubsubOutboundGateway messageGatewuy;
	
	@Autowired
	InputDetailsRepo detailsRepo;

//	@PostMapping(value = "/publish")
//	public String publishMessage(@RequestBody InputDetails details) {
//		return "Message Published to gcp";
//
//	}
//	

	@GetMapping(value = "sample")
	public String sample() {
		return "sample";
	}

	@PostMapping(value = "/publish")
	public ModelAndView publishMessage(HttpServletRequest request) {
		//String message = request.getParameter("Fuel_Type_Petrol");
		
		InputDetails message = new InputDetails();
		message.setFuel_type(request.getParameter("Fuel_Type_Petrol"));
		message.setKms(request.getParameter("Kms_Driven"));
		message.setOwner(request.getParameter("Owner"));
		message.setPresent_price(request.getParameter("Present_Price"));
		message.setSeller_type(request.getParameter("Seller_Type_Individual"));
		message.setTransmission_type(request.getParameter("Transmission_Mannual"));
		message.setYear(request.getParameter("Year"));
		System.out.println("request coming " + message);
		detailsRepo.save(message);
		messageGatewuy.sendToPubsub(message.toString());
		
		//return "Message published to Google Pub/Sub successfully";
		return new ModelAndView("redirect:https://sainathcloudcomputing.uc.r.appspot.com/predict");
	}

}
