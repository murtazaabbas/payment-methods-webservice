package net.demo.service;

import net.demo.configuration.ObjectMapperUtils;
import net.demo.dto.PaymentMethodCollectionDto;
import net.demo.dto.PaymentMethodDto;
import net.demo.entity.PaymentMethod;
import net.demo.entity.PaymentPlan;
import net.demo.exception.ResourceNotFoundException;
import net.demo.repository.PaymentMethodRepository;
import net.demo.repository.PaymentPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentManagerImpl implements PaymentManager {
    @Autowired
    private PaymentMethodRepository paymentMethodRepository;
    @Autowired
    private ObjectMapperUtils objectMapperUtils;
    @Autowired
    private PaymentPlanRepository paymentPlanRepository;

    @Override
    public PaymentMethodCollectionDto getAllPaymentMethod() {
        List<PaymentMethod> paymentMethods = this.paymentMethodRepository.findAll();
        return new PaymentMethodCollectionDto(objectMapperUtils.mapAll(paymentMethods, PaymentMethodDto.class));
    }

    @Override
    public PaymentMethodCollectionDto getPaymentMethodByName(String name) {
        List<PaymentMethod> paymentMethods = this.paymentMethodRepository.findByNameEquals(name);
        return new PaymentMethodCollectionDto(objectMapperUtils.mapAll(paymentMethods, PaymentMethodDto.class));
    }

    @Override
    public PaymentMethodCollectionDto getPaymentMethodPlanById(Long id) {
        PaymentPlan paymentPlan = this.paymentPlanRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Payment plan not found with id :" + id));
        List<PaymentMethod> paymentMethods = this.paymentMethodRepository.findByPaymentPlans(paymentPlan);
        return new PaymentMethodCollectionDto(objectMapperUtils.mapAll(paymentMethods, PaymentMethodDto.class));
    }

    @Override
    public PaymentMethodCollectionDto createPaymentMethod(PaymentMethodCollectionDto paymentMethodCollection) {
        List<PaymentMethodDto> receivedPaymentMethods = paymentMethodCollection.getPaymentMethods();
        List<PaymentMethod> paymentMethods = objectMapperUtils.mapAll(receivedPaymentMethods, PaymentMethod.class);
        return new PaymentMethodCollectionDto(
                objectMapperUtils.mapAll(this.paymentMethodRepository.saveAll(paymentMethods), PaymentMethodDto.class)
        );
    }

    @Override
    public PaymentMethodCollectionDto updatePaymentMethod(PaymentMethodCollectionDto paymentMethod, Long id) {
        PaymentMethod existingPaymentMethod = this.paymentMethodRepository.getOne(id);
        PaymentMethodDto newPaymentMethod = paymentMethod.getPaymentMethods().get(0);
        existingPaymentMethod.setDisplayName(newPaymentMethod.getDisplayName());
        existingPaymentMethod.setName(newPaymentMethod.getName());
        existingPaymentMethod.setPaymentType(newPaymentMethod.getPaymentType());
        existingPaymentMethod.setPaymentPlans(this.objectMapperUtils.mapAll(newPaymentMethod.getPaymentPlans(), PaymentPlan.class));

        List<PaymentMethod> paymentMethods = new ArrayList<>();
        paymentMethods.add(existingPaymentMethod);
        return new PaymentMethodCollectionDto(this.objectMapperUtils.mapAll(this.paymentMethodRepository.saveAll(paymentMethods), PaymentMethodDto.class));
    }
}
