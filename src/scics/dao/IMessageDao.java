package scics.dao;

import java.util.List;
import java.util.Map;

import scics.pojo.Message;

public interface IMessageDao {
	public List<Message> queryMessageList(Message message);
	public void deleteById(Integer id);
	public void deleteByIds(List<Integer> idList);
	/**
	 * 根据查询条件分页查询消息列表
	 */
	public List<Message> queryMessageListByPage(Map<String,Object> parameter);

}
