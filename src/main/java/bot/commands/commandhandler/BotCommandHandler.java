package bot.commands.commandhandler;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.util.Arrays;
import java.util.List;

public class BotCommandHandler extends ListenerAdapter {
    /*
    Parses all of the arguments from `message` to The list L.
     */
    public static List<String> Parse(Message message, List<String>L) throws RuntimeException {

        return Arrays.asList(message.getContentRaw().split(" "));
    }
    public static String shift(List<String>Arg) throws Exception {
        return Arg.get(0).substring(1, '\n').trim();
    }
    public static void Login(String token) throws LoginException {
        JDABuilder.createLight(token, GatewayIntent.GUILD_MESSAGES, GatewayIntent.DIRECT_MESSAGES)
                .addEventListeners(new BotCommandHandler())
                .setActivity(Activity.playing("With the OpenJDK"))
                .build();
    }
}
