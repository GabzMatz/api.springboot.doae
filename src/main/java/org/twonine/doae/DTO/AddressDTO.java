package org.twonine.doae.DTO;



public record AddressDTO(String postalCode, String street, Integer number, String city,
                         String country, String state, String complement) {

}
