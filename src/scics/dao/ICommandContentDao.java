package scics.dao;

import java.util.List;

import scics.pojo.CommandContent;

public interface ICommandContentDao {
	public void insertBatch(List<CommandContent> contentList);

}
