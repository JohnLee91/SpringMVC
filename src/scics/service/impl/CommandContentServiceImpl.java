package scics.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import scics.dao.ICommandContentDao;
import scics.pojo.CommandContent;
import scics.service.ICommandContentService;

@Service("commandContentService")
public class CommandContentServiceImpl implements ICommandContentService {

	@Resource
	private ICommandContentDao commandContentDao;

	@Override
	public void insertBatch(List<CommandContent> contentList) {
		commandContentDao.insertBatch(contentList);		
	}

}
