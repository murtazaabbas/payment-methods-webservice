package net.demo.repository;

import net.demo.entity.PaymentPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.demo.entity.PaymentMethod;

import java.util.List;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long>{

    List<PaymentMethod> findByNameEquals(String name);
    List<PaymentMethod> findByPaymentPlans(PaymentPlan paymentPlan);
}
