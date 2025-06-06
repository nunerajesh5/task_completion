package com.example.task_completion.Entity;



public class JwtResponse {

    private String jwtToken;
    private String username;

    // No-argument constructor
    public JwtResponse() {
    }

    // All-argument constructor
    public JwtResponse(String jwtToken, String username) {
        this.jwtToken = jwtToken;
        this.username = username;
    }

    // Getters
    public String getJwtToken() {
        return jwtToken;
    }

    public String getUsername() {
        return username;
    }

    // Setters
    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Builder pattern
    public static JwtResponseBuilder builder() {
        return new JwtResponseBuilder();
    }

    public static class JwtResponseBuilder {
        private String jwtToken;
        private String username;

        public JwtResponseBuilder jwtToken(String jwtToken) {
            this.jwtToken = jwtToken;
            return this;
        }

        public JwtResponseBuilder username(String username) {
            this.username = username;
            return this;
        }

        public JwtResponse build() {
            return new JwtResponse(jwtToken, username);
        }
    }

    // toString method
    @Override
    public String toString() {
        return "JwtResponse{" +
                "jwtToken='" + jwtToken + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}