package com.patrick.store.domain;

import com.patrick.store.domain.enums.PaymentState;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "tb_payment")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;
    private Integer state;

    @OneToOne
    @JoinColumn(name = "order_id")
    @MapsId
    private Order order;

    public Payment() {
    }

    public Payment(Integer id, PaymentState state, Order order) {
        this.id = id;
        this.state = state.getCod();
        this.order = order;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PaymentState getState() {
        return PaymentState.toEnum(state);
    }

    public void setState(PaymentState state) {
        this.state = state.getCod();
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;

        return id != null ? id.equals(payment.id) : payment.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
