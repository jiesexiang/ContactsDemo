package com.example.demo.service;

import com.example.demo.model.ContactsEntity;
import com.github.pagehelper.PageInfo;

public interface ContactsService {

    int AddAddressBook(ContactsEntity user);

    int UpdateAddressBook(ContactsEntity user);

    int DeletaAddressbook(int id);

    PageInfo<ContactsEntity> findAllAddressBook(int pageNum, int pageSize);
}
