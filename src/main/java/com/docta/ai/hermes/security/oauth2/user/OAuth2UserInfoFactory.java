package com.docta.ai.hermes.security.oauth2.user;

import com.docta.ai.hermes.exception.OAuth2AuthenticationProcessingException;
import com.docta.ai.hermes.model.AuthProviderEnum;

import java.util.Map;

public class OAuth2UserInfoFactory {

    public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
        if(registrationId.equalsIgnoreCase(AuthProviderEnum.google.toString())) {
            return new GoogleOAuth2UserInfo(attributes);
        } else if (registrationId.equalsIgnoreCase(AuthProviderEnum.facebook.toString())) {
            return new FacebookOAuth2UserInfo(attributes);
        } else if (registrationId.equalsIgnoreCase(AuthProviderEnum.github.toString())) {
            return new GithubOAuth2UserInfo(attributes);
        } else {
            throw new OAuth2AuthenticationProcessingException("Sorry! Login with " + registrationId + " is not supported yet.");
        }
    }
}
