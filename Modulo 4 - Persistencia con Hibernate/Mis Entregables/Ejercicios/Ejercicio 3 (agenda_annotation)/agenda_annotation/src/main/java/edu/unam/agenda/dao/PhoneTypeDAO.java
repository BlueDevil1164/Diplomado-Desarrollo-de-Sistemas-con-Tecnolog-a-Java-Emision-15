package edu.unam.agenda.dao;

import edu.unam.agenda.model.PhoneType;

import java.util.List;

public interface PhoneTypeDAO extends GenericDAO<PhoneType, Integer> {
    List<PhoneType> getAllPhoneTypes();

    PhoneType getPhoneTypeById(Integer id);

    Boolean insertPhoneType(PhoneType phoneType);

    Boolean updatePhoneType(PhoneType phoneType);

    Boolean deletePhoneType(PhoneType phoneType);
}