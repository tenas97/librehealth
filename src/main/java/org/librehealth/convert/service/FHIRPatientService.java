package org.librehealth.convert.service;

import org.hl7.fhir.dstu3.model.Patient;
import org.librehealth.convert.client.ApacheHttpClientGet;

public class FHIRPatientService {

    private String baseUrl  = "https://radiology.librehealth.io/lh-toolkit/ws/rest/v1/patient/";

    public Patient getPatient(String patientId) {
        ApacheHttpClientGet apacheHttpClientGet = ApacheHttpClientGet.getInstance();
        String libreHealthPerson = apacheHttpClientGet.executeGet(baseUrl + patientId);
        Patient patient = PatientUtil.getFHIRPatientObject(libreHealthPerson);
        return patient;
    }
}
