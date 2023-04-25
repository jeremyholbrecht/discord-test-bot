import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;
import java.io.File;
import java.util.Objects;
import java.util.Random;

public class B12 extends ListenerAdapter {
    public static void main(String[] args) throws LoginException {

        // add your token here
        JDA bot = JDABuilder.createDefault("MTA5NDcxMzc2NDM0OTIxODg1Ng.GQz7oD.hgYfn6ThpntpwM-ADCvwmnYiaSFNg6SGC6Me7Y")
                .setActivity(Activity.playing("Dragon Quest XI"))
                .addEventListeners(new B12())
                .build();
    }


    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (!event.getAuthor().isBot()){
            String messageSent = event.getMessage().getContentRaw();
            if (messageSent.equals("!veigar")){
                // pings author
                String userName = event.getAuthor().getAsMention();
                Random rand = new Random();
                int imageNumber = rand.nextInt(5);
                // no need for BufferedImage cause discord just asks for a filepath and will look at the extension
                File file = new File("C:\\Users\\jere\\Documents\\Veigar\\" + imageNumber +".jpg");
                event.getTextChannel().sendMessage(userName).addFile(file).queue();
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
