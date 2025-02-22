package org.automation.constants;

public enum LoginDetails {

    LOGIN_EMAIL("alin.bungau.marius@gmail.com", "_ASdfghj_");



    private final String email;
    private String password;

    LoginDetails(String email, String password) {
        this.email = email;
        this.password = password;
    }



    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
