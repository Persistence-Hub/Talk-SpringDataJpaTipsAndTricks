package com.thorben.janssen.talk.model;

import jakarta.persistence.Embeddable;

@Embeddable
public record Address (String street, String city, String postalCode) {}