package com.ejournal.university.info.dto;

import com.ejournal.university.common.dto.AddressDto;
import com.ejournal.university.info.dto.builder.UniversityBuilder;

public class UniversityDto {

    private String universityName;
    private String universityDescription;
    private AddressDto address;
    private String mobilePhone;
    private String email;
    private String accreditation;
    private RectorDto rector;

    public class RectorDto {
        private String firstName;
        private String lastName;
        private String middleName;
    }

    public UniversityDto(){}

    public UniversityDto(String universityName,
                         String universityDescription,
                         AddressDto address,
                         String mobilePhone,
                         String email,
                         String accreditation,
                         RectorDto rector) {
        this.universityName = universityName;
        this.universityDescription = universityDescription;
        this.address = address;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.accreditation = accreditation;
        this.rector = rector;
    }

    public UniversityBuilder builder(){
        return UniversityBuilder.getInstance();
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getUniversityDescription() {
        return universityDescription;
    }

    public void setUniversityDescription(String universityDescription) {
        this.universityDescription = universityDescription;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccreditation() {
        return accreditation;
    }

    public void setAccreditation(String accreditation) {
        this.accreditation = accreditation;
    }

    public RectorDto getRector() {
        return rector;
    }

    public void setRector(RectorDto rector) {
        this.rector = rector;
    }
}
