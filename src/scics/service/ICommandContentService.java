package scics.service;

import java.util.List;

import scics.pojo.CommandContent;

public interface ICommandContentService {
	
	/**
	 * 批量新增
	 * @param contentList
	 */
	public void insertBatch(List<CommandContent> contentList);
}
