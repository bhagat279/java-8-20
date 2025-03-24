package java_8_20.doctor_patents;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Doctor {
    private String name;

    public Doctor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Patient {
    private String name;
    private Doctor doctor;

    public Patient(String name, Doctor doctor) {
        this.name = name;
        this.doctor = doctor;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", doctor=" + doctor +
                '}';
    }
}

public class DoctorPatientAnalysis {
    public static void main(String[] args) {


        Doctor doctor1 = new Doctor("Dr. Smith");
        Doctor doctor2 = new Doctor("Dr. Johnson");
        Doctor doctor3 = new Doctor("Dr. Lee");

        // Sample patients
        Patient patient1 = new Patient("John", doctor1);
        Patient patient2 = new Patient("Alice", doctor2);
        Patient patient3 = new Patient("Bob", doctor1);
        Patient patient4 = new Patient("Charlie", doctor1);
        Patient patient5 = new Patient("David", doctor3);
        Patient patient6 = new Patient("Eve", doctor3);
        Patient patient7 = new Patient("Frank", doctor3);

        List<Patient> patients = Arrays.asList(patient1, patient2, patient3, patient4, patient5, patient6, patient7);


       Map<String,Long> map=  patients.stream().collect(Collectors.groupingBy(
                patient -> patient.getDoctor().getName(),
                Collectors.counting()
        ));

        Map.Entry<String, Long> stringLongEntry = map.entrySet().stream().sorted(Comparator.comparing((Map.Entry<String,Long> e)->e.getValue())
                .thenComparing(e->e.getKey())
                .reversed()

        ).findFirst().get();

        System.out.println(stringLongEntry.getKey());

    }
}

// You are given a list of Patient and Doctor objects. Write a program to find the doctor who has treated the most patients and print the doctor's name along with
//  the count of patients.