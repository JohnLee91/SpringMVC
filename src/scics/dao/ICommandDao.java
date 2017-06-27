package scics.dao;

import java.util.List;

import scics.pojo.Command;

public interface ICommandDao {
	public List<Command> queryCommandList(Command command);

}
