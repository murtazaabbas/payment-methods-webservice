package net.demo.dto;

import java.util.List;

public class PaymentMethodCollectionDto {

    private List<PaymentMethodDto> paymentMethods;

    public PaymentMethodCollectionDto(){
    }

    public PaymentMethodCollectionDto(List<PaymentMethodDto> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public List<PaymentMethodDto> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(List<PaymentMethodDto> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }
}
