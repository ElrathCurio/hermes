package com.docta.ai.hermes.payload;


import com.docta.ai.hermes.model.AuthProviderEnum;


public class UserDto {

    private Long id;

    private String name;

    private String email;

    private String imageUrl;

    private String password;

    private AuthProviderEnum provider;

    private String googleEmail;

    private String providerId;

    public UserDto() {
    }

    public UserDto(Long id, String name, String email, String imageUrl, String password, AuthProviderEnum provider, String googleEmail, String providerId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.imageUrl = imageUrl;
        this.password = password;
        this.provider = provider;
        this.googleEmail = googleEmail;
        this.providerId = providerId;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AuthProviderEnum getProvider() {
        return provider;
    }

    public void setProvider(AuthProviderEnum provider) {
        this.provider = provider;
    }

    public String getGoogleEmail() {
        return googleEmail;
    }

    public void setGoogleEmail(String googleEmail) {
        this.googleEmail = googleEmail;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }
}
