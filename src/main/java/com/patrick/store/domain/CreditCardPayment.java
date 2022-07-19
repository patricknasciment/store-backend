package com.patrick.store.domain;

import com.patrick.store.domain.enums.PaymentState;

import javax.persistence.Entity;
import java.io.Serial;

@Entity
public class CreditCardPayment extends Payment{
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer installments;

    public CreditCardPayment() {
    }

    public CreditCardPayment(Integer id, PaymentState state, Order order, Integer installments) {
        super(id, state, order);
        this.installments = installments;
    }

    public Integer getInstallments() {
        return installments;
    }

    public void setInstallments(Integer installments) {
        this.installments = installments;
    }
}
