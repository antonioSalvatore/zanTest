package com.letsjam.business_objects.entities;

import com.google.gson.annotations.Expose;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "MusicianEntity")
@Table(name = "musician", schema ="jam")
public class MusicianEntity implements Serializable {

    private static final long serialVersionUID = -8260206893010106502L;

    @Id
    @Column(name = "musician_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jam.musician_id_seq")
    @SequenceGenerator(schema = "jam", name = "jam.musician_id_seq", sequenceName = "jam.musician_id_seq", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "name")
    @Expose
    private String name;

    @Column(name = "surname")
    @Expose
    private String surname;

    @Column(name = "age")
    @Expose
    private int age;

    @Column(name = "city")
    @Expose
    private String city;

    @Column(name = "musical_instrument")
    @Expose
    private String musicalInstrument;

    @Column(name = "email", nullable = false, unique = true)
    @Expose
    private String email;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "login_id")
    @JsonManagedReference
    private LoginEntity loginEntity;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "musicianEntity", cascade = {CascadeType.ALL})
    private List<BandEntity> bandEntities;


    // --- GETTERS & SETTERS --- //

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMusicalInstrument() {
        return musicalInstrument;
    }

    public void setMusicalInstrument(String musicalInstrument) {
        this.musicalInstrument = musicalInstrument;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LoginEntity getLoginEntity() {
        return loginEntity;
    }

    public void setLoginEntity(LoginEntity loginEntity) {
        this.loginEntity = loginEntity;
    }

    public List<BandEntity> getBandEntities() {
        return bandEntities;
    }

    public void setBandEntities(List<BandEntity> bandEntities) {
        this.bandEntities = bandEntities;
    }


    // --- BUILDER --- //

    public static final class Builder {
        private Long id;
        private String name;
        private String surname;
        private int age;
        private String city;
        private String musicalInstrument;
        private String email;
        private LoginEntity loginEntity;
        private List<BandEntity> bandEntities;

        private Builder() {
        }

        public static Builder aMusicianEntity() {
            return new Builder();
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder withAge(int age) {
            this.age = age;
            return this;
        }

        public Builder withCity(String city) {
            this.city = city;
            return this;
        }

        public Builder withMusicalInstrument(String musicalInstrument) {
            this.musicalInstrument = musicalInstrument;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withLoginEntity(LoginEntity loginEntity) {
            this.loginEntity = loginEntity;
            return this;
        }

        public Builder withBandEntities(List<BandEntity> bandEntities) {
            this.bandEntities = bandEntities;
            return this;
        }

        public Builder but() {
            return aMusicianEntity().withId(id).withName(name).withSurname(surname).withAge(age).withCity(city).withMusicalInstrument(musicalInstrument).withEmail(email).withLoginEntity(loginEntity).withBandEntities(bandEntities);
        }

        public MusicianEntity build() {
            MusicianEntity musicianEntity = new MusicianEntity();
            musicianEntity.setId(id);
            musicianEntity.setName(name);
            musicianEntity.setSurname(surname);
            musicianEntity.setAge(age);
            musicianEntity.setCity(city);
            musicianEntity.setMusicalInstrument(musicalInstrument);
            musicianEntity.setEmail(email);
            musicianEntity.setLoginEntity(loginEntity);
            musicianEntity.setBandEntities(bandEntities);
            return musicianEntity;
        }
    }


    // --- EQUALS --- //

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof MusicianEntity)) return false;

        MusicianEntity that = (MusicianEntity) o;

        final EqualsBuilder append = new EqualsBuilder();

        append.append(id, that.id);
        append.append(age, that.age);
        append.append(name, that.name);
        append.append(surname, that.surname);
        append.append(city, that.city);
        append.append(musicalInstrument, that.musicalInstrument);
        append.append(email, that.email);
        append.append(loginEntity != null ? loginEntity.getId() : null,
                that.loginEntity != null ? that.loginEntity.getId() : null);
        // this field is a list, and the persistent bags needs this
        if (bandEntities != null && that.bandEntities != null &&
                bandEntities.size() == that.bandEntities.size()) {
            List<BandEntity> tmpBandEntities = bandEntities;
            for (int i = 0, tmpBandEntitiesSize = tmpBandEntities.size(); i < tmpBandEntitiesSize; i++) {
                BandEntity thisField = tmpBandEntities.get(i);
                BandEntity thatField = that.bandEntities.get(i);
                append.append(thisField, thatField);
            }
        } else
            append.append(true, false);

        return append.isEquals();
    }


    // --- HASHCODE --- //

    @Override
    public int hashCode() {
        HashCodeBuilder append = new HashCodeBuilder(17, 37);

        append.append(id);
        append.append(id);
        append.append(name);
        append.append(surname);
        append.append(age);
        append.append(city);
        append.append(musicalInstrument);
        append.append(email);
        append.append(loginEntity != null ? loginEntity.getId() : null);
        // this field is a list, and the persistent bags needs this
        if(bandEntities == null)
            append.append(bandEntities);
        else{
            for(BandEntity element : bandEntities){
                append.append(element);
            }
        }

        return append.toHashCode();
    }


    // --- TO STRING --- //

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("id", id)
                .append("name", name)
                .append("surname", surname)
                .append("age", age)
                .append("city", city)
                .append("musicalInstrument", musicalInstrument)
                .append("email", email)
                .append("loginEntity", loginEntity)
                .append("bandEntities", bandEntities)
                .toString();
    }
}
