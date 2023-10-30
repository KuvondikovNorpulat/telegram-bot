package uz.kuvondikov.bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.bot.BaseAbilityBot;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.abilitybots.api.objects.Flag;
import org.telegram.abilitybots.api.objects.Reply;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.function.BiConsumer;

import static org.telegram.abilitybots.api.objects.Locality.USER;
import static org.telegram.abilitybots.api.objects.Privacy.PUBLIC;
import static org.telegram.abilitybots.api.util.AbilityUtils.getChatId;

@Component
public class JavinatorBot extends AbilityBot {
    private final ResponseHandler responseHandler;

    @Autowired
    public JavinatorBot(Environment environment) {
        super("6476933204:AAFvjQDz4ipQHVu6aCLFlC3ZU5efOBEY-kA", "javinator_bot");
        responseHandler = new ResponseHandler(silent, db);
    }

//    public Ability startBot() {
//        return Ability
//                .builder()
//                .name("start")
//                .locality(USER)
//                .privacy(PUBLIC)
//                .action(ctx -> responseHandler.replyToStart(ctx.chatId()))
//                .build();
//    }

    public Reply replyToButtons() {
        BiConsumer<BaseAbilityBot, Update> action = (abilityBot, upd) -> responseHandler.sendMessage(getChatId(upd),"hellooo");
        return Reply.of(action, Flag.TEXT, upd -> responseHandler.userIsActive(getChatId(upd)));
    }

    @Override
    public long creatorId() {
        return 1L;
    }

}
