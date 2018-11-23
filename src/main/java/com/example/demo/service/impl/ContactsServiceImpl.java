package com.example.demo.service.impl;

import com.example.demo.dao.ContactsDao;
import com.example.demo.model.ContactsEntity;
import com.example.demo.service.ContactsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "contactsService")
public class ContactsServiceImpl implements ContactsService {

    @Resource
    private ContactsDao dao;

    @Override
    public int AddAddressBook(ContactsEntity record)
    {
        return dao.Insert(record);
    }

    @Override
    public int UpdateAddressBook(ContactsEntity record)
    {
        return dao.Update(record);
    }
    @Override
    public int DeletaAddressbook(int id)
    {
        return dao.Delete(id);
    }
    /*
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */
    @Override
    public PageInfo<ContactsEntity> findAllAddressBook(int pageNum, int pageSize)
    {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<ContactsEntity> list = dao.GetAddressBookList();
        PageInfo<ContactsEntity> result = new PageInfo<>(list);
        return result;

    }
}
