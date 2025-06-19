package com.codegym.health_declaration.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HealthDeclaration {
    private String fullName;
    private int birthYear;
    private String gender;
    private String nationality;
    private String idNumber;

    private String transportType;
    private String vehicleNumber;
    private String seatNumber;
    private String startDate;
    private String endDate;
    private String recentPlaces;

    private String province;
    private String district;
    private String ward;
    private String address;
    private String phone;
    private String email;

    private boolean hasFever;
    private boolean hasCough;
    private boolean hasShortnessOfBreath;
    private boolean hasSoreThroat;
    private boolean hasNausea;
    private boolean hasDiarrhea;
    private boolean hasSkinRash;
    private boolean hasHemorrhage;

    private boolean contactedAnimals;
    private boolean contactedCovid;
}
