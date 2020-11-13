package com.huayi.scrm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huayi.scrm.mapper.ContactMapper;
import com.huayi.scrm.domain.Contact;
import com.huayi.scrm.service.IContactService;
import com.huayi.common.support.Convert;

/**
 * 人脉关系记录 服务层实现
 * 
 * @author huayi
 * @date 2020-08-16
 */
@Service
public class ContactServiceImpl implements IContactService 
{
	@Autowired
	private ContactMapper contactMapper;

	/**
     * 查询人脉关系记录信息
     * 
     * @param recordId 人脉关系记录ID
     * @return 人脉关系记录信息
     */
    @Override
	public Contact selectContactById(Integer recordId)
	{
	    return contactMapper.selectContactById(recordId);
	}
	
	/**
     * 查询人脉关系记录列表
     * 
     * @param contact 人脉关系记录信息
     * @return 人脉关系记录集合
     */
	@Override
	public List<Contact> selectContactList(Contact contact)
	{
	    return contactMapper.selectContactList(contact);
	}
	
    /**
     * 新增人脉关系记录
     * 
     * @param contact 人脉关系记录信息
     * @return 结果
     */
	@Override
	public int insertContact(Contact contact)
	{
	    return contactMapper.insertContact(contact);
	}
	
	/**
     * 修改人脉关系记录
     * 
     * @param contact 人脉关系记录信息
     * @return 结果
     */
	@Override
	public int updateContact(Contact contact)
	{
	    return contactMapper.updateContact(contact);
	}

	/**
     * 删除人脉关系记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteContactByIds(String ids)
	{
		return contactMapper.deleteContactByIds(Convert.toStrArray(ids));
	}
	
}
