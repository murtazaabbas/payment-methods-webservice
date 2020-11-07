package net.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "payment_plan")
public class PaymentPlan {

	@Id
	@Column(name = "PLAN_ID")
	private long id;

	@Column(name = "net_amount")
	private float netAmount;

	@Column(name = "tax_amount")
	private float taxAmount;

	@Column(name = "gross_amount")
	private float grossAmount;

	@Column(name = "currency")
	private String currency;

	@Column(name = "duration")
	private String duration;

	@ManyToMany( mappedBy = "paymentPlans", cascade = CascadeType.ALL)
	private List<PaymentMethod> paymentMethods;

	public PaymentPlan() {
		
	}

	public List<PaymentMethod> getPaymentMethods() {
		return paymentMethods;
	}

	public void setPaymentMethods(List<PaymentMethod> paymentMethods) {
		this.paymentMethods = paymentMethods;
	}

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
