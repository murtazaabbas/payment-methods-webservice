package net.demo.controller;

import net.demo.dto.PaymentMethodCollectionDto;
import net.demo.service.PaymentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import net.demo.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api/v1.0/configuration")
public class PaymentConfigController {

	@Autowired
	private PaymentManager paymentManager;

	@GetMapping("/payment-methods")
	public PaymentMethodCollectionDto getAllPaymentMethod() {
		return this.paymentManager.getAllPaymentMethod();
	}

	@GetMapping(value = "/payment-methods", params = {"name"})
	public PaymentMethodCollectionDto getPaymentMethodByName(@RequestParam String name) {
		if(name == null || name.isEmpty()){
			throw new ResourceNotFoundException("Invalid PaymentMethod name");
		}
		return this.paymentManager.getPaymentMethodByName(name);
	}

	@GetMapping(value = "/payment-methods", params = {"id"})
	public PaymentMethodCollectionDto getPaymentMethodPlanById(@RequestParam String id) {
		if(id == null || id.isEmpty()){
			throw new ResourceNotFoundException("Invalid id");
		}
		return this.paymentManager.getPaymentMethodPlanById(Long.parseLong(id));
	}

	@PostMapping("/payment-methods")
	public PaymentMethodCollectionDto createUser(@RequestBody PaymentMethodCollectionDto paymentMethods) {
		return this.paymentManager.createPaymentMethod(paymentMethods);
	}

	@PutMapping("/{payment-methods}")
	public PaymentMethodCollectionDto updateUser(@RequestBody PaymentMethodCollectionDto paymentMethods, @RequestParam ("payment-methods") String id) {
		return this.paymentManager.updatePaymentMethod(paymentMethods, Long.parseLong(id));
	}
}
