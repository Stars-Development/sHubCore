package online.starsmc.hubcore.module;

import online.starsmc.hubcore.listener.ChatListener;
import online.starsmc.hubcore.listener.PlayerListeners;
import org.bukkit.event.Listener;
import team.unnamed.inject.AbstractModule;

public class ListenerModule extends AbstractModule {

    @Override
    protected void configure() {
        multibind(Listener.class)
                .asSet()
                .to(PlayerListeners.class)
                .to(ChatListener.class);
    }
}
