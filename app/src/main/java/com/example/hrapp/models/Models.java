package com.example.hrapp.models;

import java.util.List;

public class Models {

    public static class Users {
        private String uid;
        public static final String UID = "uid";
        private String first_name;
        public static final String FIRST_NAME = "first_name";
        private String last_name;
        public static final String LAST_NAME = "last_name";
        private String secret_key;
        public static final String SECRET_KEY = "secret_key";
        private String date_of_birth;
        public static final String DOB = "date_of_birth";
        private String phone_number;
        public static final String PHONE_NO = "phone_number";
        private String email_address;
        public static final String EMAIL_ADDRESS = "email_address";
        private String wage;
        public static final String WAGE = "wage";
        private String leave_dates_available;
        public static final String LEAVE_DATES_AVAILABLE = "leave_dates_available";
        private String performance_ratings;
        public static final String PERFORMANCE_RATING = "performance_ratings";
        private String nationalId;
        public static final String NATIONAL_ID = "nationalId";
        private String kraPin;
        public static final String KRA_PIN = "kraPin";
        private String nssf;
        public static final String NSSF = "nssf";
        private String nhif;
        public static final String NHIF = "nhif";
        private String createdAt;
        public static final String CREATED_AT = "createdAt";
        private String role;
        public static final String ROLE = "role";
        private String position;
        public static final String POSITION = "position";


        public static final String ADMIN = "Admin";
        public static final String EMPLOYEE = "Employee";

        public static final String EMPLOYEE_DB = "Employees";

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public Users() {
        }

        public String getSecret_key() {
            return secret_key;
        }

        public void setSecret_key(String secret_key) {
            this.secret_key = secret_key;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public Users(String first_name) {
            this.first_name = first_name;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        public String getDate_of_birth() {
            return date_of_birth;
        }

        public void setDate_of_birth(String date_of_birth) {
            this.date_of_birth = date_of_birth;
        }

        public String getPhone_number() {
            return phone_number;
        }

        public void setPhone_number(String phone_number) {
            this.phone_number = phone_number;
        }

        public String getEmail_address() {
            return email_address;
        }

        public void setEmail_address(String email_address) {
            this.email_address = email_address;
        }

        public String getWage() {
            return wage;
        }

        public void setWage(String wage) {
            this.wage = wage;
        }

        public String getLeave_dates_available() {
            return leave_dates_available;
        }

        public void setLeave_dates_available(String leave_dates_available) {
            this.leave_dates_available = leave_dates_available;
        }

        public String getPerformance_ratings() {
            return performance_ratings;
        }

        public void setPerformance_ratings(String performance_ratings) {
            this.performance_ratings = performance_ratings;
        }

        public String getNationalId() {
            return nationalId;
        }

        public void setNationalId(String nationalId) {
            this.nationalId = nationalId;
        }

        public String getKraPin() {
            return kraPin;
        }

        public void setKraPin(String kraPin) {
            this.kraPin = kraPin;
        }

        public String getNssf() {
            return nssf;
        }

        public void setNssf(String nssf) {
            this.nssf = nssf;
        }

        public String getNhif() {
            return nhif;
        }

        public void setNhif(String nhif) {
            this.nhif = nhif;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }
    }

    public static class Updates {
        private String updateId;
        public static final String UPDATE_ID = "updateId";
        private String updateTitle;
        public static final String UPDATE_TITLE = "updateTitle";
        private String updatePostedAt;
        public static final String UPDATE_POSTED_AT = "updatePostedAt";
        private String updateContent;
        public static final String UPDATE_CONTENT = "updateContent";

        public static final String UPDATE_DB = "Updates";

        public static final String UPDATE_SUR = "UPD";

        public String getUpdateId() {
            return updateId;
        }

        public void setUpdateId(String updateId) {
            this.updateId = updateId;
        }

        public String getUpdateTitle() {
            return updateTitle;
        }

        public void setUpdateTitle(String updateTitle) {
            this.updateTitle = updateTitle;
        }

        public String getUpdatePostedAt() {
            return updatePostedAt;
        }

        public void setUpdatePostedAt(String updatePostedAt) {
            this.updatePostedAt = updatePostedAt;
        }

        public String getUpdateContent() {
            return updateContent;
        }

        public void setUpdateContent(String updateContent) {
            this.updateContent = updateContent;
        }
    }

    public static class Comments {
        private String uid;
        private String userName;
        public static final String USER_NAME = "userName";
        private String commentContent;
        public static final String COMMENT_CONTENT = "commentContent";
        private String commentedAt;
        public static final String COMMENTED_AT = "commentedAt";

        public Comments(String commentContent) {
            this.commentContent = commentContent;
        }

        public Comments() {
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getCommentContent() {
            return commentContent;
        }

        public void setCommentContent(String commentContent) {
            this.commentContent = commentContent;
        }

        public String getCommentedAt() {
            return commentedAt;
        }

        public void setCommentedAt(String commentedAt) {
            this.commentedAt = commentedAt;
        }
    }

    public static class Tickets {
        private String ticketId;
        public static final String TICKET_ID = "ticketId";
        private boolean solved;
        public static final String SOLVED = "solved";
        private String userId;
        public static final String USER_ID = "userId";
        private String userName;
        public static final String USER_NAME = "userName";
        private String dateCreatedAt;
        public static final String DATE_CREATED = "dateCreatedAt";
        private String dateSolvedAt;
        public static final String DATE_SOLVED = "dateSolvedAt";
        private String ticketContent;
        public static final String TICKET_CONTENT = "ticketContent";
        private String ticketSeverity;
        public static final String TICKET_SEVERITY = "ticketSeverity";
        private List<Comments> ticketComments;
        public static final String TICKET_COMMENT = "ticketComments";

        public static final String TICKET_SUR = "TKT";

        public static final String LOW_S = "Low";
        public static final String MID_S = "Mid";
        public static final String HIGH_S = "High";

        public static final String TICKET_DB = "Tickets";


        public Tickets() {
        }

        public Tickets(String ticketContent) {
            this.ticketContent = ticketContent;
        }

        public List<Comments> getTicketComments() {
            return ticketComments;
        }

        public void setTicketComments(List<Comments> ticketComments) {
            this.ticketComments = ticketComments;
        }

        public String getTicketId() {
            return ticketId;
        }

        public void setTicketId(String ticketId) {
            this.ticketId = ticketId;
        }

        public boolean isSolved() {
            return solved;
        }

        public void setSolved(boolean solved) {
            this.solved = solved;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getDateCreatedAt() {
            return dateCreatedAt;
        }

        public void setDateCreatedAt(String dateCreatedAt) {
            this.dateCreatedAt = dateCreatedAt;
        }

        public String getDateSolvedAt() {
            return dateSolvedAt;
        }

        public void setDateSolvedAt(String dateSolvedAt) {
            this.dateSolvedAt = dateSolvedAt;
        }

        public String getTicketContent() {
            return ticketContent;
        }

        public void setTicketContent(String ticketContent) {
            this.ticketContent = ticketContent;
        }

        public String getTicketSeverity() {
            return ticketSeverity;
        }

        public void setTicketSeverity(String ticketSeverity) {
            this.ticketSeverity = ticketSeverity;
        }
    }
}
