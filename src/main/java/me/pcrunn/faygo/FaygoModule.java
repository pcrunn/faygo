package me.pcrunn.faygo;

import app.ashcon.intake.parametric.AbstractModule;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import me.pcrunn.data.rank.Rank;
import me.pcrunn.data.user.User;
import me.pcrunn.faygo.arena.Arena;
import me.pcrunn.faygo.arena.ArenaProvider;
import me.pcrunn.faygo.ladder.Ladder;
import me.pcrunn.faygo.ladder.LadderProvider;
import me.pcrunn.faygo.rank.RankProvider;
import me.pcrunn.faygo.user.UserProvider;

@RequiredArgsConstructor
public class FaygoModule extends AbstractModule {

    @NonNull
    private FaygoPlugin plugin;

    @Override
    protected void configure() {
        this.bind(FaygoPlugin.class).toInstance(this.plugin);
        this.bind(User.class).toProvider(new UserProvider());
        this.bind(Rank.class).toProvider(new RankProvider());
        this.bind(Arena.class).toProvider(new ArenaProvider());
        this.bind(Ladder.class).toProvider(new LadderProvider());
    }

}
