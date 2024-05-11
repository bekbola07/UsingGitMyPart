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
    private OrderStatus orderStatus;
    private String name;
    @ManyToOne
    private User user;

}
