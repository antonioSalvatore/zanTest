package com.letsjam.business_objects.entities;

import com.google.gson.annotations.Expose;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

@Entity(name ="BandEntity")
@Table(name = "band", schema = "jam")
public class BandEntity {
    @Id
    @Column(name = "band_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jam.band_id_seq")
    @SequenceGenerator(schema = "jam", name = "jam.band_id_seq", sequenceName = "jam.band_id_seq", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "band_name")
    @Expose
    private String bandName;

    @Column(name = "musical_genre")
    @Expose
    private String musicalGenre;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "musician_id")
    private MusicianEntity musicianEntity;


    // --- GETTERS & SETTERS --- //

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public String getMusicalGenre() {
        return musicalGenre;
    }

    public void setMusicalGenre(String musicalGenre) {
        this.musicalGenre = musicalGenre;
    }

    public MusicianEntity getMusicianEntity() {
        return musicianEntity;
    }

    public void setMusicianEntity(MusicianEntity musicianEntity) {
        this.musicianEntity = musicianEntity;
    }


    // --- BUILDER --- //

    public static final class Builder {
        private Long id;
        private String bandName;
        private String musicalGenre;
        private MusicianEntity musicianEntity;

        private Builder() {
        }

        public static Builder aBandEntity() {
            return new Builder();
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withBandName(String bandName) {
            this.bandName = bandName;
            return this;
        }

        public Builder withMusicalGenre(String musicalGenre) {
            this.musicalGenre = musicalGenre;
            return this;
        }

        public Builder withMusicianEntity(MusicianEntity musicianEntity) {
            this.musicianEntity = musicianEntity;
            return this;
        }

        public Builder but() {
            return aBandEntity().withId(id).withBandName(bandName).withMusicalGenre(musicalGenre).withMusicianEntity(musicianEntity);
        }

        public BandEntity build() {
            BandEntity bandEntity = new BandEntity();
            bandEntity.setId(id);
            bandEntity.setBandName(bandName);
            bandEntity.setMusicalGenre(musicalGenre);
            bandEntity.setMusicianEntity(musicianEntity);
            return bandEntity;
        }
    }


    // --- EQUALS --- //

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof BandEntity)) return false;

        BandEntity that = (BandEntity) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(bandName, that.bandName)
                .append(musicalGenre, that.musicalGenre)
                .append(musicianEntity != null ? musicianEntity.getId() : null,
                    that.musicianEntity != null ? that.musicianEntity.getId() : null)
                .isEquals();
    }


    // --- HASHCODE --- //

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(bandName)
                .append(musicalGenre)
                .append(musicianEntity != null ? musicianEntity.getId() : null)
                .toHashCode();
    }


    // --- TO STRING --- //

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("bandName", bandName)
                .append("musicalGenre", musicalGenre)
                .append("musicianEntity", musicianEntity)
                .toString();
    }
}
