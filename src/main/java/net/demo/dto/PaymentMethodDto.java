package net.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class PaymentMethodDto {

    private String name;
    private String displayName;
    private String paymentType;
    private List<PaymentPlanDto> paymentPlans;

    public List<PaymentPlanDto> getPaymentPlans() {
        return paymentPlans;
    }

    public void setPaymentPlans(List<PaymentPlanDto> paymentPlans) {
        this.paymentPlans = paymentPlans;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}
