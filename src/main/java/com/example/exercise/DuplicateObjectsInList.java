package com.example.exercise;

import org.springframework.cglib.reflect.FastClass;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
Write an java method called (leadDuplicateCheck) ,that will validate to see if there duplicates in the collection of new leads (List<Lead>)
Java Method is expected to return segregated lists in a map as below
(True: list of non-duplicates & False: list of duplicates). Map<Boolean, List<Lead>>
Given :
A duplicate lead is defined as { Email(string), Region (String) and CompanyCode(Int) }
Lead - POJO
Email (string)
Region(string)
CompanyCode(Int)
 */
public class DuplicateObjectsInList {


    public static void main(String... args){
        List<Lead> leads = Arrays.asList(new Lead("Test@test.com", "Atlanta", 1),
                new Lead("Test@test.com", "Atlanta", 1),
                new Lead("Test1@test.com", "Atlanta", 1));
        Map<Lead, Long> frequencyMap =
                leads.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("frequencyMap: "+frequencyMap);
        //Another way
        Map<Lead, Long> frequencyMap2 = new HashMap<>();
        leads.forEach(lead -> frequencyMap2.merge(lead, 1l, Long::sum));
        System.out.println("frequencyMap2: "+frequencyMap2);

        //Or
        Map<Lead, Long> frequencyMap3 = new HashMap<>();
        leads.forEach(lead -> frequencyMap3.compute(lead, (k, v) -> (v == null)? 1 : ++v));
        System.out.println("frequencyMap3: "+frequencyMap3);

        Map<Boolean, List<Lead>> resultMap = new HashMap<>();
        resultMap.put(Boolean.TRUE, new ArrayList<>());
        resultMap.put(Boolean.FALSE, new ArrayList<>());

        frequencyMap.entrySet().forEach(entry -> {
            if(entry.getValue() == 1){
                resultMap.get(Boolean.TRUE).add(entry.getKey());
            } else {
                resultMap.get(Boolean.FALSE).add(entry.getKey());
            }
        });
        System.out.println("resultMap: "+ resultMap);
    }

    public static class Lead{
        String email;
        String region;
        int companyCode;

        public Lead(String email, String region, int companyCode) {
            this.email = email;
            this.region = region;
            this.companyCode = companyCode;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Lead lead = (Lead) o;
            return companyCode == lead.companyCode && Objects.equals(email, lead.email) && Objects.equals(region, lead.region);
        }

        @Override
        public int hashCode() {
            return Objects.hash(email, region, companyCode);
        }
    }

}
