package com.ejournal.university.info.dto.builder;

import com.ejournal.university.common.dto.AddressDto;
import com.ejournal.university.common.dto.builder.Builder;
import com.ejournal.university.info.dto.UniversityDto;

public class UniversityBuilder implements Builder<UniversityDto> {

    private String universityName;
    private String universityDescription;
    private AddressDto address;
    private String mobilePhone;
    private String email;
    private String accreditation;
    private UniversityDto.RectorDto rector;

    private UniversityBuilder() {
    }

    public static UniversityBuilder getInstance() {
        return new UniversityBuilder();
    }

    public UniversityBuilder setUniversityName(String universityName) {
        this.universityName = universityName;
        return this;
    }

    public UniversityBuilder setUniversityDescription(String universityDescription) {
        this.universityDescription = universityDescription;
        return this;
    }

    public UniversityBuilder setAddress(AddressDto address) {
        this.address = address;
        return this;
    }

    public UniversityBuilder setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public UniversityBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UniversityBuilder setAccreditation(String accreditation) {
        this.accreditation = accreditation;
        return this;
    }

    public UniversityBuilder setRector(UniversityDto.RectorDto rector) {
        this.rector = rector;
        return this;
    }

    @Override
    public UniversityDto build() {
        return new UniversityDto(universityName, universityDescription,
                address, mobilePhone, email, accreditation, rector);
    }
}
