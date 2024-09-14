package com.laptop.dto.payment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ExtrasDTO {
    private Integer order_id;
    public ExtrasDTO(Integer order_id) {
        this.order_id = order_id;
    }
}
