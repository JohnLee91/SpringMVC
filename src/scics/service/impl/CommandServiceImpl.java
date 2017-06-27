package scics.service.impl;

import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import scics.dao.ICommandDao;
import scics.pojo.Command;
import scics.pojo.CommandContent;
import scics.service.ICommandService;
import scics.util.IConst;

@Service("commandService")
public class CommandServiceImpl implements ICommandService {

	@Resource
	private ICommandDao commandDao;
	@Override
	public List<Command> queryCommandList(Command command) {		
		return commandDao.queryCommandList(command);
	}

	@Override
	public String queryByCommand(Command command) {
		List<Command> commandList;
		if(IConst.HELP_COMMAND.equals(command.getCommand())) {
			commandList = commandDao.queryCommandList(new Command());
			StringBuilder result = new StringBuilder();
			for(int i = 0; i < commandList.size(); i++) {
				if(i != 0) {
					result.append("<br/>");
				}
				result.append("回复[" + commandList.get(i).getCommand() + "]可以查看" + commandList.get(i).getDescription());
			}
			return result.toString();
		}
		commandList = commandDao.queryCommandList(command);
		if(commandList.size() > 0) {
			List<CommandContent> contentList = commandList.get(0).getContentList();
			return contentList.get(new Random().nextInt(contentList.size())).getContent();
		}
		return IConst.NO_MATCHING_CONTENT;
	}

}
