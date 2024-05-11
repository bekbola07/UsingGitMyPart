package org.example.usinggitmypart.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import org.example.usinggitmypart.entity.templlete.ParentEntity;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "users")
public class User extends ParentEntity {
    private String password;
    private String userName;
    @OneToMany
    private List<Order>  order;

}
