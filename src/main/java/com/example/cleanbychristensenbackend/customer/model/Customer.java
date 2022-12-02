package com.example.cleanbychristensenbackend.customer.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

    @Getter
    @Setter
    @NoArgsConstructor
    @Entity
    @Table(name = "customers")
    public class Customer {

        /**
         * Autogenereret entity id.
         */
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        /**
         * Besked emne
         */
        @Column(name = "subject")
        private String subject;

        /**
         * Kundens fornavn.
         */
        @Column(name = "firstname")
        private String firstName;

        /**
         * Kundens efternavn.
         */
        @Column(name = "lastname")
        private String lastName;

        /**
         * Kundens addresse.
         */
        @Column(name = "address")
        private String address;

        /**
         * Kundens telefonnummer.
         */
        @Column(name = "phonenumber")
        private String phoneNumber;

        /**
         * Kundens besked til firmaet.
         */
        @Column(name = "message")
        private String message;

        /**
         * Kundens boligstørrelse.
         */
        @Column(name = "squaremeters")
        private Double kvm;

        /**
         * Constructs a new customer.
         *
         * @param firstName
         * @param lastName
         * @param address
         * @param phoneNumber
         * @param message
         * @param kvm
         */
        public Customer(String subject, String firstName, String lastName, String address, String phoneNumber, String message, Double kvm) {
            this.subject = subject;
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.phoneNumber = phoneNumber;
            this.message = message;
            this.kvm = kvm;
        }

        public Customer updateFrom(Customer customer, boolean partial) {
            if (!partial || customer.subject != null) {
                this.subject = customer.subject;
            }
            if (!partial || customer.firstName != null) {
                this.firstName = customer.firstName;
            }
            if (!partial || customer.lastName != null) {
                this.lastName = customer.lastName;
            }
            if (!partial || customer.address != null) {
                this.address = customer.address;
            }
            if (!partial || customer.phoneNumber != null) {
                this.phoneNumber = customer.phoneNumber;
            }
            if (!partial || customer.message != null) {
                this.message = customer.message;
            }
            if (!partial || customer.kvm != 0) {
                this.kvm = customer.kvm;
            }

            return this;
        }

        /**
         * toString
         */
        @Override
        public String toString() {
            return "Customer{" +
                    "id=" + id +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }


        /**
         * equals
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Customer)) return false;
            Customer customer = (Customer) o;
            return Objects.equals(getId(), customer.getId()) && Objects.equals(getSubject(), customer.getSubject()) && Objects.equals(getFirstName(), customer.getFirstName()) && Objects.equals(getLastName(), customer.getLastName()) && Objects.equals(getAddress(), customer.getAddress()) && Objects.equals(getPhoneNumber(), customer.getPhoneNumber()) && Objects.equals(getMessage(), customer.getMessage()) && Objects.equals(getKvm(), customer.getKvm());
        }


        @Override
        public int hashCode() {
            return Objects.hash(id, subject, lastName, address, phoneNumber, message, kvm);
        }
    }



