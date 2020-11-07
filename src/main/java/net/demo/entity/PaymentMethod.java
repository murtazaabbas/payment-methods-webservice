package net.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "payment_method")
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "METHOD_ID", unique = true, nullable = false)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "payment_type")
    private String paymentType;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "payment_method_plans", joinColumns = {
            @JoinColumn(name = "METHOD_ID") },
            inverseJoinColumns = { @JoinColumn(name = "PLAN_ID") }
            )
    private List<PaymentPlan> paymentPlans;

    public PaymentMethod() {

    }

    public List<PaymentPlan> getPaymentPlans() {
        return paymentPlans;
    }

    public void setPaymentPlans(List<PaymentPlan> paymentPlans) {
        this.paymentPlans = paymentPlans;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
