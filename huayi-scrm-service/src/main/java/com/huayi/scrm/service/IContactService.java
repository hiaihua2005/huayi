package com.huayi.scrm.service;

import com.huayi.scrm.domain.Contact;
import java.util.List;

/**
 * 人脉关系记录 服务层
 * 
 * @author huayi
 * @date 2020-08-16
 */
public interface IContactService 
{
	/**
     * 查询人脉关系记录信息
     * 
     * @param recordId 人脉关系记录ID
     * @return 人脉关系记录信息
     */
	public Contact selectContactById(Integer recordId);
	
	/**
     * 查询人脉关系记录列表
     * 
     * @param contact 人脉关系记录信息
     * @return 人脉关系记录集合
     */
	public List<Contact> selectContactList(Contact contact);
	
	/**
     * 新增人脉关系记录
     * 
     * @param contact 人脉关系记录信息
     * @return 结果
     */
	public int insertContact(Contact contact);
	
	/**
     * 修改人脉关系记录
     * 
     * @param contact 人脉关系记录信息
     * @return 结果
     */
	public int updateContact(Contact contact);
		
	/**
     * 删除人脉关系记录信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteContactByIds(String ids);
	
}
