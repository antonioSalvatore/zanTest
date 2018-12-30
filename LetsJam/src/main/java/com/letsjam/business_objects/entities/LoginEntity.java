package com.letsjam.business_objects.entities;

import com.google.gson.annotations.Expose;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;

@Entity(name = "LoginEntity")
@Table(name = "login", schema = "jam")
public class LoginEntity {

    @Id
    @Column(name = "login_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jam.login_id_seq")
    @SequenceGenerator(schema = "jam", name = "jam.login_id_seq", sequenceName = "jam.login_id_seq", initialValue = 1, allocationSize = 1)
    private int id;

    @Column(name = "username", nullable = false, unique = true)
    @Expose
    private String username;

    @Column(name = "password", nullable = false)
    @Expose
    private String password;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "loginEntity", cascade = {CascadeType.ALL})
    private MusicianEntity musicianEntity;


    // --- GETTERS & SETTERS --- //

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public MusicianEntity getMusicianEntity() {
        return musicianEntity;
    }

    public void setMusicianEntity(MusicianEntity musicianEntity) {
        this.musicianEntity = musicianEntity;
    }


    // --- BUILDER --- //

    public static final class Builder {
        private int id;
        private String username;
        private String password;
        private MusicianEntity musicianEntity;

        private Builder() {
        }

        public static Builder aLoginEntity() {
            return new Builder();
        }

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder withMusicianEntity(MusicianEntity musicianEntity) {
            this.musicianEntity = musicianEntity;
            return this;
        }

        public Builder but() {
            return aLoginEntity().withId(id).withUsername(username).withPassword(password).withMusicianEntity(musicianEntity);
        }

        public LoginEntity build() {
            LoginEntity loginEntity = new LoginEntity();
            loginEntity.setId(id);
            loginEntity.setUsername(username);
            loginEntity.setPassword(password);
            loginEntity.setMusicianEntity(musicianEntity);
            return loginEntity;
        }
    }


    // --- EQUALS --- //

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof LoginEntity)) return false;

        LoginEntity that = (LoginEntity) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(username, that.username)
                .append(password, that.password)
                .append(musicianEntity != null ? musicianEntity.getId() : null,
                    that.musicianEntity != null ? that.musicianEntity.getId() : null)
                .isEquals();
    }


    // --- HASHCODE --- //

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(username)
                .append(password)
                .append(musicianEntity != null ? musicianEntity.getId() : null)
                .toHashCode();
    }


    // --- TO STRING --- //

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("id", id)
                .append("username", username)
                .append("password", password)
                .append("musicianEntity", musicianEntity)
                .toString();
    }
}
