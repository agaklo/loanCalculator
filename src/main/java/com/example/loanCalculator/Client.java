package com.example.loanCalculator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
class Client {
    @Id private String id;
    private ClientSegmentEnum segment;
    private Long creditModifier;
}
