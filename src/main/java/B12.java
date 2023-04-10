import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;
import java.util.Objects;

public class B12 extends ListenerAdapter {
    public static void main(String[] args) throws LoginException {

        JDA bot = JDABuilder.createDefault("token")
                .setActivity(Activity.playing("Dragon Quest XI"))
                .addEventListeners(new B12())
                .build();
    }


    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (!event.getAuthor().isBot()){
            String messageSent = event.getMessage().getContentRaw();
            if (messageSent.equals("!potato")){
                // pings author
                String userName = event.getAuthor().getAsMention();
                event.getTextChannel().sendMessage(userName + ":said potato").queue();
            }
        }
    }


    @Override
    public void onMessageReactionAdd(@NotNull MessageReactionAddEvent event) {
        String messageReactionEmoji = event.getReactionEmote().getAsReactionCode();
        if (messageReactionEmoji.equals("\uD83E\uDD23")){
            String userName = Objects.requireNonNull(event.getUser()).getAsMention();
            event.getTextChannel().sendMessage( userName + "don't laugh!").queue();
        }
    }


}
