package scics.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import scics.dao.IMessageDao;
import scics.pojo.Message;
import scics.pojo.Page;
import scics.service.IMessageService;
import scics.util.IConst;

@Service("messageService")
public class MessageServiceImpl implements IMessageService {

	@Resource
	private IMessageDao messageDao;
	@Override
	public List<Message> queryMessageList(Message message) {
		System.out.println("command:"+message.getCommand());
		
		return messageDao.queryMessageList(message);
	}
	
	@Override
	public void deleteById(Integer id) {
		messageDao.deleteById(id);
	}

	@Override
	public void deleteByIds(String[] ids) {
//		List<String> idList = Arrays.asList(ids);
		List<Integer> idList = new ArrayList<Integer>();
		if (ids.length>0) {
			for (String id : ids) {
				idList.add(Integer.valueOf(id));
			}
			
			messageDao.deleteByIds(idList);
		}
	}

	@Override
	public String queryByCommand(Message message) {
		List<Message> messageList;
		if(IConst.HELP_COMMAND.equals(message.getCommand())) {
			messageList = messageDao.queryMessageList(new Message());
			StringBuilder result = new StringBuilder();
			for(int i = 0; i < messageList.size(); i++) {
				if(i != 0) {
					result.append("<br/>");
				}
				result.append("回复[" + messageList.get(i).getCommand() + "]可以查看" + messageList.get(i).getDescription());
			}
			return result.toString();
		}
		messageList = messageDao.queryMessageList(message);
		if(messageList.size() > 0) {
			return messageList.get(0).getContent();
		}
		return IConst.NO_MATCHING_CONTENT;
	}
	
	/**
	 * 根据查询条件分页查询消息列表
	 */
	@Override
	public List<Message> queryMessageListByPage(Message message,Page page) {
		Map<String,Object> parameter = new HashMap<String, Object>();
		parameter.put("message", message);
		parameter.put("page", page);
		// 分页查询并返回结果
		return messageDao.queryMessageListByPage(parameter);
	}

}
