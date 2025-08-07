package commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class PingCommand {
    public void handle(MessageReceivedEvent event) {
        event.getChannel().sendMessage("pong!").queue();
    }
}
