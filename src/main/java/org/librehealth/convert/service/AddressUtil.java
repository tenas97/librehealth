package org.librehealth.convert.service;

import org.hl7.fhir.dstu3.model.Address;
import org.hl7.fhir.dstu3.model.Identifier;
import org.hl7.fhir.dstu3.model.Patient;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class AddressUtil {

    public static Address getAddressObject(String payload) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject addressObj = (JSONObject) parser.parse(payload);
            Address address = new Address();

            String uuid = (String) addressObj.get("uuid");
            address.setId(uuid);

            String cityVillage = (String) addressObj.get("cityVillage");
            address.setCity(cityVillage);

            String stateProvince = (String) addressObj.get("stateProvince");
            address.setState(stateProvince);

            String country = (String) addressObj.get("country");
            address.setCountry(country);

            String postalCode = (String) addressObj.get("postalCode");
            address.setPostalCode(postalCode);

            String countyDistrict = (String) addressObj.get("countyDistrict");
            address.setDistrict(countyDistrict);

            Boolean preferred = (Boolean) addressObj.get("preferred");
            if (preferred) {
                address.setUse(Address.AddressUse.HOME);
            } else {
                address.setUse(Address.AddressUse.OLD);
            }

            String address1 = (String) addressObj.get("address1");
            if (address1 != null  && !"".equals(address1)) {
                address.addLine(address1);
            }

            String address2 = (String) addressObj.get("address2");
            if (address2 != null  && !"".equals(address2)) {
                address.addLine(address2);
            }

            String address3 = (String) addressObj.get("address3");
            if (address3 != null  && !"".equals(address3)) {
                address.addLine(address3);
            }

            return address;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
