package com.patrick.store.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.patrick.store.domain.enums.PaymentState;

import javax.persistence.Entity;
import java.io.Serial;
import java.util.Date;

@Entity
public class BilletPayment extends Payment{

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dueDate;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date payDay;

    public BilletPayment() {
    }

    public BilletPayment(Integer id, PaymentState state, Order order, Date dueDate, Date payDay) {
        super(id, state, order);
        this.dueDate = dueDate;
        this.payDay = payDay;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getPayDay() {
        return payDay;
    }

    public void setPayDay(Date payDay) {
        this.payDay = payDay;
    }
}
