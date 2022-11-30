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
    @Table(name = "CUSTOMERS")
    public class Customer {

        /**
         * Autogenereret entity id.
         */
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        /**
         * Kundens fornavn.
         */
        @Column(name = "FIRSTNAME")
        private String firstName;

        /**
         * Kundens efternavn.
         */
        @Column(name = "LASTNAME")
        private String lastName;

        /**
         * Kundens addresse.
         */
        @Column(name = "ADDRESS")
        private String address;

        /**
         * Kundens telefonnummer.
         */
        @Column(name = "PHONENUMBER")
        private String phoneNumber;

        /**
         * Kundens besked til firmaet.
         */
        @Column(name = "MESSAGE")
        private String message;

        /**
         * Kundens boligstørrelse.
         */
        @Column(name = "SQUAREMETERS")
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
        public Customer(String firstName, String lastName, String address, String phoneNumber, String message, double kvm) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.phoneNumber = phoneNumber;
            this.message = message;
            this.kvm = kvm;
        }

        public Customer updateFrom(Customer customer, boolean partial) {
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
            if (o == null || getClass() != o.getClass()) return false;
            Customer customer = (Customer) o;
            return Double.compare(customer.kvm, kvm) == 0 && Objects.equals(id, customer.id) && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(address, customer.address) && Objects.equals(phoneNumber, customer.phoneNumber);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, firstName, lastName, address, phoneNumber, kvm);
        }
    }



