package com.sivalabs.javalibs.recordbuilder;

import io.soabase.recordbuilder.core.RecordBuilder;

@RecordBuilder
record Address(String street, String city, String state, String country)
        implements AddressBuilder.With {}