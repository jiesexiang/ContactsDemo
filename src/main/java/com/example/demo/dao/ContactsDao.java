package com.example.demo.dao;

import com.example.demo.model.ContactsEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContactsDao {
    int Insert(ContactsEntity record);

    int Update(ContactsEntity record);

    int Delete(int id);

    List<ContactsEntity> GetAddressBookList();
}
