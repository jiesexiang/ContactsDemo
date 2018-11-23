package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.model.ContactsEntity;
import com.example.demo.model.ResponesParam;
import com.example.demo.service.ContactsService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/contacts")
@Api(value="通讯录控制器")
public class ContactsController {

    @Autowired
    private ContactsService contactsService;

    private final static Logger logger = LoggerFactory.getLogger(ContactsController.class);

    @ResponseBody
    @PostMapping("/add")
    @ApiOperation(value="添加通讯录")
    public Object addAddressBook(@RequestBody ContactsEntity record){


        ResponesParam resp=new ResponesParam();
        resp.setCode(1);
        resp.setMsg("添加成功");
        if(null == record || record.getName()==null){
            resp.setCode(-100);
            resp.setMsg("姓名不能为空");
            return resp;
        }
        try
        {
            logger.info("addAddressBook -> requestXml : {}", new Object[]{JSON.toJSONString(record)});
            if (contactsService.AddAddressBook(record) != 1) {
                resp.setCode(-1);
                resp.setMsg("添加失败！");
            }
        }
        catch(Exception e)
        {
            resp.setCode(-401);
            resp.setMsg("未知原因，请联系管理员！");
            logger.error("addAddressBook -> 错误信息：{}, ", new Object[]{e.getMessage()});
        }
        logger.info("addAddressBook -> responseXml : {}", new Object[]{JSON.toJSONString(resp)});
        return resp;
    }
    @ResponseBody
    @PostMapping("/update")
    @ApiOperation(value="修改通讯录")
    public Object UpdateAddressBook(@RequestBody ContactsEntity record){


        ResponesParam resp=new ResponesParam();
        resp.setCode(1);
        resp.setMsg("修改成功");
        if(null == record || record.getId()==0){
            resp.setCode(-100);
            resp.setMsg("id不能为空");
            return resp;
        }
        if(null == record || record.getName()==null){
            resp.setCode(-100);
            resp.setMsg("姓名不能为空");
            return resp;
        }
        try {
            logger.info("addAddressBook -> requestXml : {}", new Object[]{JSON.toJSONString(record)});
            if (contactsService.UpdateAddressBook(record) != 1) {
                resp.setCode(-1);
                resp.setMsg("修改失败！");
            }
        }
        catch(Exception e)
        {
            resp.setCode(-401);
            resp.setMsg("修改失败！未知原因，请联系管理员！");
            logger.error("UpdateAddressBook -> 错误信息：{}, ", new Object[]{e.getMessage()});
        }
        logger.info("UpdateAddressBook -> responseXml : {}", new Object[]{JSON.toJSONString(resp)});
        return resp;
    }
    @ResponseBody
    @PostMapping("/delete")
    @ApiOperation(value="根据ID删除通讯录")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "id", value = "主键", dataType = "Integer")
    })
    public Object DeleteAddressBook(
            @RequestParam(name = "id", required = false, defaultValue = "0")
            int id){


        ResponesParam resp=new ResponesParam();
        resp.setCode(1);
        resp.setMsg("删除成功");
        if(id == 0){
            resp.setCode(-100);
            resp.setMsg("id不能为空");
            return resp;
        }
        try {
            logger.info("DeleteAddressBook -> requestXml : id={}", new Object[]{id});
            if (contactsService.DeletaAddressbook(id) != 1) {
                resp.setCode(-1);
                resp.setMsg("删除失败！");
            }
        }
        catch(Exception e)
        {
            resp.setCode(-401);
            resp.setMsg("删除失败！未知原因，请联系管理员！");
            logger.error("DeleteAddressBook -> 错误信息：{}, ", new Object[]{e.getMessage()});
        }
        logger.info("DeleteAddressBook -> responseXml : {}", new Object[]{JSON.toJSONString(resp)});
        return resp;
    }
    @ResponseBody
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    @ApiOperation(value="查询通讯录", notes="分页查询通讯录")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "pageNum", value = "页码", dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "pageSize", value = "每页的条数", dataType = "Integer")
    })
    public Object findAllAddressBook(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize){

        PageInfo<ContactsEntity> pageinfoList= contactsService.findAllAddressBook(pageNum,pageSize);
        String a = "findAllAddressBook -> responseXml : "+JSON.toJSONString(pageinfoList);
        logger.info(a);
        return pageinfoList;
    }

}
