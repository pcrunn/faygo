package me.pcrunn.faygo.command.impl;

import app.ashcon.intake.Command;
import app.ashcon.intake.bukkit.parametric.annotation.Sender;
import me.pcrunn.data.DataPlugin;
import me.pcrunn.data.data.DataService;
import me.pcrunn.data.rank.Rank;
import me.pcrunn.data.user.User;
import me.pcrunn.faygo.FaygoPlugin;
import me.pcrunn.faygo.profile.Profile;
import net.sf.cglib.asm.$MethodVisitor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListCommand {

    private DataService service = DataPlugin.getDataPlugin().getDataService();

    @Command(
            aliases = "list",
            desc = "gives you a list of all the online players"
    )
    public void list(@Sender Player player) {
        int online = Bukkit.getOnlinePlayers().size();
        int max = Bukkit.getMaxPlayers();

        String ranks = Stream.of(Rank.values())
                .sorted(Comparator.comparing(Rank::getColor))
                .map(rank -> rank.getColor() + rank.toString())
                .collect(Collectors.joining(ChatColor.WHITE + ", "));

        String players = Bukkit.getOnlinePlayers().stream()
                .map(current -> this.service.getUser(current.getName()))
                .sorted(Comparator.comparing(User::getRank).reversed())
                .map(user -> user.getRank().getColor() + user.getName())
                .collect(Collectors.joining(ChatColor.WHITE + ", "));

        player.sendMessage(ranks);
        player.sendMessage("");
        player.sendMessage("Online Players: " + online + " / " + max);
        player.sendMessage(players);
    }

    @Command(
            aliases = "dp",
            desc = "debug profiles",
            perms = "faygo.debug"
    )
    public void debugProfiles(@Sender Player player) {
        for (Profile profile : FaygoPlugin.getFaygo().getProfileService().getProfiles()) {
            player.sendMessage("- " + profile.getName());
        }
    }

}
