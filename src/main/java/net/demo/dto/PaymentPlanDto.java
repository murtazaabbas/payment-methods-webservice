package net.demo.dto;

public class PaymentPlanDto {

    private long id;
    private float netAmount;
    private float taxAmount;
    private float grossAmount;
    private String currency;
    private String duration;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(float netAmount) {
        this.netAmount = netAmount;
    }

    public float getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(float taxAmount) {
        this.taxAmount = taxAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public float getGrossAmount() {
        return grossAmount;
    }

    public void setGrossAmount(float grossAmount) {
        this.grossAmount = grossAmount;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
