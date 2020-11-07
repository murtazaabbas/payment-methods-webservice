package net.demo.service;

import net.demo.dto.PaymentMethodCollectionDto;

public interface PaymentManager {

    // get all
    public PaymentMethodCollectionDto getAllPaymentMethod();
    // filter
    public PaymentMethodCollectionDto getPaymentMethodByName(String name);
    public PaymentMethodCollectionDto getPaymentMethodPlanById(Long id);
    // post
    public PaymentMethodCollectionDto createPaymentMethod(PaymentMethodCollectionDto paymentMethod);
    //put
    public PaymentMethodCollectionDto updatePaymentMethod(PaymentMethodCollectionDto paymentMethod, Long id);
}
