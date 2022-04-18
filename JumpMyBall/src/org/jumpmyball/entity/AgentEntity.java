package org.jumpmyball.entity;

import java.util.Objects;

public class AgentEntity {
    private int id;
    private String title;
    private String AgentType;
    private String Address;
    private String phone;
    private String email;
    private String logo;
    private int priority;

    public AgentEntity(int id, String title, String agentType, String address, String phone, String email, String logo, int priority) {
        this.id = id;
        this.title = title;
        AgentType = agentType;
        Address = address;
        this.phone = phone;
        this.email = email;
        this.logo = logo;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAgentType() {
        return AgentType;
    }

    public void setAgentType(String agentType) {
        AgentType = agentType;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "AgentEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", AgentType='" + AgentType + '\'' +
                ", Address='" + Address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", logo='" + logo + '\'' +
                ", priority=" + priority +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgentEntity that = (AgentEntity) o;
        return id == that.id && priority == that.priority && Objects.equals(title, that.title) && Objects.equals(AgentType, that.AgentType) && Objects.equals(Address, that.Address) && Objects.equals(phone, that.phone) && Objects.equals(email, that.email) && Objects.equals(logo, that.logo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, AgentType, Address, phone, email, logo, priority);
    }
}