package scics.service;

import java.util.List;

import scics.pojo.Message;
import scics.pojo.Page;

public interface IMessageService {
	public List<Message> queryMessageList(Message message);
	public void deleteById(Integer id);
	public void deleteByIds(String[] ids);
	public String queryByCommand(Message message);
	public List<Message> queryMessageListByPage(Message message,Page page);

}
