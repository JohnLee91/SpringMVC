package scics.pojo;

public class CommandContent {
	
	private Integer id;
	private Integer commandId;
	private Command command;
	private String content;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCommandId() {
		return commandId;
	}
	public void setCommandId(Integer commandId) {
		this.commandId = commandId;
	}
	public Command getCommand() {
		return command;
	}
	public void setCommand(Command command) {
		this.command = command;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
