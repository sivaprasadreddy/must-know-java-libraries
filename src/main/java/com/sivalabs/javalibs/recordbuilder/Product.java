package com.sivalabs.javalibs.recordbuilder;

import java.math.BigDecimal;

record Product(
        Long id,
        String name,
        String description,
        BigDecimal price
){}
