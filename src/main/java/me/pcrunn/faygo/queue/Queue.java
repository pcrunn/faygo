package me.pcrunn.faygo.queue;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import me.pcrunn.faygo.ladder.Ladder;
import me.pcrunn.faygo.profile.Profile;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
public class Queue {

    @NonNull
    private Ladder ladder;

    @NonNull
    private QueueType type;

    private List<Profile> players = new ArrayList<>();

}
