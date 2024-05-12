package org.example.usinggitmypart.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.usinggitmypart.entity.templlete.ParentEntity;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "orders")
public class Order extends ParentEntity {
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(255) default 'CREATED'")
    private OrderStatus orderStatus;
    @PrePersist
    protected void onCreate() {
        if (orderStatus == null) {
            orderStatus = OrderStatus.CREATED;
        }
    }
    private String name;
    @ManyToOne
    private User user;

}
