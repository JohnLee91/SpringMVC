package scics.service;

import java.util.List;

import scics.pojo.Command;

public interface ICommandService {
	public List<Command> queryCommandList(Command command);
	public String queryByCommand(Command command);

}
