package com.dzh.trial.trial.prescriptionStateMachine.entity;

//import com.dzh.trial.trial.prescriptionStateMachine.enums.OrderStatus;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/*@Entity
@Table(name = "order")*/
public class Order {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    private String id;

    @Column(name = "status")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
